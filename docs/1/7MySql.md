---
prev: 6Spring
next: false
---
* [返回主页](../home.md)
# 7MySql
## 数据库范式
::: tip 1NF 无重复列
属性不可再分（就是字段只能是一个值）
:::

::: tip 2NF 有唯一键
在1NF的基础上增加了一个列，这个列称为主键，非主属性都依赖于主键 
:::

::: tip 3NF 数据不冗余
在2NF基础上，非主键要依赖主键，不能依赖其他 
:::

## 存储引擎
![](../../picture/1/7存储引擎.png)

## 基础架构
![](../../picture/1/7基础架构.png)

## InnoDB 存储引擎的锁
+ 表锁
+ 行锁
    + Record lock
        + 记录锁，单个行记录上的锁
    + Gap lock
        + 间隙锁，锁定一个范围，不包括记录本身
    + Next-key lock
        + record+gap 临键锁，锁定一个范围，包含记录本身

## InnoDB行格式
![](../../picture/1/7InnoDB行格式.png)

* [返回主页](../home.md)