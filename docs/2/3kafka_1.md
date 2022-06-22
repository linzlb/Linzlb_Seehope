---
prev: 2MQ
next: 3kafka_2
---

* [返回主页](../home.md)
# kafka
## 核心概念
![img.png](../../picture/2/3核心概念.png)

## 核心设计
![img.png](../../picture/2/3核心设计.png)

## 索引
![img.png](../../picture/2/3索引.png)

## 存储结构
![img.png](../../picture/2/3存储结构.png)

## 控制器
![img.png](../../picture/2/3控制器.png)

## Partition副本选举Leader机制
controller感知到分区leader所在的broker挂了(controller监听了很多zk节点可以感知到broker存活)，<br>
controller会从每 个parititon的 replicas 副本列表中取出第一个broker作为leader，当然这个broker需要也同时在ISR列表里。

## rebalance
![img.png](../../picture/2/3rebalance.png)

## KafkaBroker网络通信模型
![img.png](../../picture/2/3KafkaBroker网络通信模型.png)

## 请求处理优先级
![img.png](../../picture/2/3请求处理优先级.png)

## zk和kafka
![img.png](../../picture/2/3zk和kafka.png)

## 场景问题
![img.png](../../picture/2/3场景问题.png)

## 集群
![img.png](../../picture/2/3集群.png)






* [返回主页](../home.md)