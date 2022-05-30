* [返回主页](../home.md)
## 记一次应用接口注册不到zk的坑
### 现象
应用上线，部署后dubbo接口无法注册到zookeeper。

### 排查问题
检查业务代码，没有问题；
查询上线内容，有其他同事集成canal组件到应用中；
考虑组件到引入对启动流程有影响；

### SpringBoot的CommandLineRunner介绍
程序在启动完成的时候需要去处理某些业务，因此Spring Boot程序中需要去实现CommandLineRunner接口。
dubbo接口注册到zk的操作就属于这个；
#### CommandLineRunner方法执行顺序
程序启动后，会执行接口重写的run方法，如果有多个Service的话，执行是有顺序的，可以在类上添加Order注解，来制定该run方法的执行顺序，Order中value的值越小，执行的顺序越靠前。
```java
@Order(value = 200)
@Service
public class CatService implements CommandLineRunner
```
### 问题原因
#### 重写run方法中使用了阻塞程序
::: warning 警告
如果程序启动后，我们要执行一个阻塞程序，例如程序启动后我要从阻塞队列取数据，取到数据后完成我的业务逻辑，一般这样的逻辑会写成while(true)，一直去取数据处理数据，这样就会导致程序会阻塞。当然run方法不会结束。这样会带来一个问题，如果我有多个这样的业务逻辑操作，只会执行Order中value最小的那一个，其他的不会执行，因为这个执行是顺序执行，前面的阻塞了，后面的就不会被执行到。
:::

### 解决方法
#### 如果有阻塞逻辑，新开辟线程
::: tip 解决方法
为解决多个Service启动后执行，并且需要阻塞执行的问题，需要在run方法中使用线程池解决。
:::

```java {11}
@Order(value = 200)
@Service
public class CatService implements CommandLineRunner {
 
    private static Logger logger = LoggerFactory.getLogger(CatService.class);
 
    private static ExecutorService singlePool = Executors.newSingleThreadExecutor();
 
    @Override
    public void run(String... args) throws Exception {
        singlePool.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    logger.info("cat:" + Stream.of(args).collect(Collectors.joining("-")));
 
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
```
* [返回主页](../home.md)