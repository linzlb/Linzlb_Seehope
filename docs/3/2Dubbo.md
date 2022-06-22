---
prev: 1分布式基础
next: 3SpringCloud     
---

* [返回主页](../home.md)
# Dubbo
## RPC
![](../../picture/3/2RPC.png)

## Dubbo基础
![](../../picture/3/2dubbo基础.png)

## Dubbo架构
![](../../picture/3/2Dubbo架构.png)

## dubbo调用过程
![img.png](../../picture/3/2dubbo调用过程.png)

## Invoker
![img.png](../../picture/3/2Invoker.png)

## dubbo集群容错策略
![img.png](../../picture/3/2dubbo集群容错策略.png)

## 服务暴露过程
![img.png](../../picture/3/2服务暴露过程.png)

## 服务引用
![img.png](../../picture/3/2服务引用.png)

## SPI 机制
![img.png](../../picture/3/2SPI机制.png)

## Dubbo 的负载均衡策略
```markdown
random 默认
RandomLoadBalance 权重随机
LeastActiveLoadBalance 最小活跃数
ConsistentHashLoadBalance 一致性Hash
RoundRobinLoadBalance 加权轮询
使用SPI方式可以自定义拓展
```

## dubbo 动态代理策略
+ 默认使用 javassist 动态字节码生成，创建代理类。但是可以通过 spi 扩展机制配置自己的动态代理策略。

## 协议
![img.png](../../picture/3/2协议.png)

## 如何基于 dubbo 进行服务治理、服务降级、失败重试以及超时重试？
![img.png](../../picture/3/2基于dubbo进行xxx.png)

## 设计一个RPC框架需要考虑什么
![img.png](../../picture/3/2设计一个RPC框架需要考虑什么.png)













* [返回主页](../home.md)