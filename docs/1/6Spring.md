---
prev: 5操作系统
next: 7MySql
---
* [返回主页](../home.md)
# 6Spring
## 定义
> 开源的轻量级 Java 开发框架，旨在提高开发人员的开发效率以及系统的可维护性
> 
> 最核心的思想就是不重新造轮子，开箱即用

## Spring Framework
![](../../picture/1/6springframework.png)

## Spring IOC & AOP
### IOC
![](../../picture/1/6IOC.png)

### AOP
![](../../picture/1/6AOP.png)
#### AOP原理
![](../../picture/1/6AOP2.png)

## Bean
![](../../picture/1/6Springbean.png)

## BeanFactory VS ApplicationContext
::: tip BeanFactory
Spring基础设施，面向Spring生产和管理Bean的
:::
::: tip ApplicationContext
面向开发者，再BeanFactory的基础上，扩展了面向应用的功能，如监听器
:::

## Filter VS  Interceptor
```text
共同点——都是AOP的体现
Filter是Servlet规定的，只能用于Web程序，Interceptor可以用于其他
Filter依赖web容器，拦截器是spring框架支持的，是spring组件
过滤器只能在servlet前后起作用，拦截器能深入到方法/异常前后
```

## SpringMVC
![](../../picture/1/6SpringMVC.png)

## Spring用到的设计模式
![](../../picture/1/6Spring用到的设计模式.png)

## Spring事务
![](../../picture/1/6Spring事务.png)

## Spring解决循环依赖
![](../../picture/1/6Spring解决循环依赖.png)

### 循环依赖与加载类型、作用域的关系
```text
在开始介绍各种情况之前，首先要了解以下三个知识点：
Spring中依赖注入的方式有两种，属性注入与构造器注入。上面的代码中，类A就是通过属性注入的方式注入了B，类B是通过构造器注入的方式注入了A。
Spring中的bean根据作用域的不同，可以大体分为两类，singleton和prototype。singleton在一个容器中，只会有一个实例；而prototype在每次调用时，都会产生一个新的实例。
Spring中，单例bean有延迟加载和立即加载两种加载方式，其中立即加载模式会在容器启动的时候就创建bean，而延迟加载会在容器启动后，使用到bean的时候再加载它。本篇分析一律使用延迟加载，因为有时候单例bean的加载顺序，会影响到创建bean的成功或失败。
```
![](../../picture/1/6spring循环依赖demo.png)
```text
如果循环依赖的bean都是通过构造器注入依赖，那么不管它们是singleton还是prototype，都会失败。
如果循环依赖的bean都是prototype，那么不管它们是通过构造器注入依赖还是通过属性注入依赖，都会失败。
如果循环依赖的bean既有构造器注入也有属性注入，既有singleton也有prototype，在容器启动后，只有当获取的第一个bean是通过属性注入依赖的singleton时，才会成功，别的情况都会失败。
```
::: tip 结论
如果多个bean存在循环依赖，在Spring容器启动后，只有当获取的第一个bean是通过属性注入依赖的singleton时，才会成功，别的情况都会失败。
:::

### setting注入避免循环依赖的问题
::: tip Spring容器启动后，如果我们去获取singletonA，那么容器的操作步骤大致如下：
1、尝试创建bean singletonA，发现singletonA是singleton，且不是通过构造器注入依赖，那么先使用默认构造器创建一个A的实例，并保存对它的引用，并且将singletonA标记为“正在创建中的singleton”。然后发现singletonA依赖了singletonB，所以尝试创建singletonB。
<br><br>2、尝试创建bean singletonB，发现singletonB是singleton，且不是通过构造器注入依赖，那么先使用默认构造器创建一个B的实例，并保存对它的引用，并且将singletonB标记为“正在创建中的singleton”。然后发现singletonB依赖了singletonA，所以尝试创建singletonA。
<br><br>3、尝试创建singletonA，注意，这时Spring容器发现singletonA“正在创建中”，那么就不会再去创建singletonA，而是返回容器之前保存了的对singletonA的引用（首先会读取singletonObjects缓存中的实例,如果存在则直接返回。因为当我们实例化完成的时候,会通过addSingleton加入到缓存,所以Address注入User的时候不会重新加载一遍,只是从缓存中直接读取,所以不会有循环引用的问题）。
<br><br>4、容器将singletonA通过setter方法注入到singletonB，从而singletonB完成创建。
<br><br>5、容器将singletonB通过setter方法注入到singletonA，从而singletonA完成创建。
:::
* [返回主页](../home.md)