---
prev: 6vuepress
next: 8UML
---

## docker&k8s常用命令
### 查看容器进程信息
```shell
docker ps |grep xxx
```

### 看容器中运行的进程信息
```shell
docker top angel-oem
```

### 查看日志
```shell
docker logs xxx -n 1000
docker logs -f --tail=1000 xxx
```

### 搜索
```shell
docker logs xxx|grep "xyz"
```
---

## k8s常用命令
### 获取命名空间列表
```shell
kubectl get ns
```
### 获取pod列表
```shell
kubectl -n xxx get po
```
		
### 删除pod
```shell
kubectl -n xxx delete po xxxx
```

### 查看日志
```shell
kubectl -n xxx logs -f xxxx
kubectl -n xxx logs -f --tail=1000 xxxx
```