---
prev: 5markdown语法
next: 7dockerAndK8s常用命令
---
* [返回主页](../home.md)
# vuepress快速上手
### 0 参考资料
* [vuepress v2.x](https://v2.vuepress.vuejs.org/zh/)

### 1 依赖环境

* [nodejs](https://nodejs.org/en/)
```text
使用 pnpm 时，你可能需要安装 vue 和 @vuepress/client 作为 peer-dependencies ，
即 pnpm add -D vue @vuepress/client@next 。
```
如果有yum源，可以直接安装

```shell
yum -y install nodejs
yum install npm
yum install git
git clone -b master https://***.git
git pull
```


### 2手动安装
+ 步骤1: 创建并进入一个新目录
```shell
mkdir vuepress-starter
cd vuepress-starter
```
+ 步骤2: 初始化项目
```shell
git init
npm init
```
+ 步骤3: 将 VuePress 安装为本地依赖！
```shell{1}
npm install -D vuepress@next
```
+ 步骤4: 在 package.json 中添加一些 scripts (可选)
```json
{
  "scripts": {
    "docs:dev": "vuepress dev docs",
    "docs:build": "vuepress build docs"
  }
}
```
+ 步骤5: 将默认的临时目录和缓存目录添加到 .gitignore 文件中
```shell
echo 'node_modules' >> .gitignore
echo '.temp' >> .gitignore
echo '.cache' >> .gitignore
```
+ 步骤6: 创建你的第一篇文档
```shell
mkdir docs
echo '# Hello VuePress' > docs/README.md
```

+ 步骤7: 在本地启动服务器来开发你的文档网站!
```shell{1}
npm run dev
```
```text
关闭进程：
Ctrl + Z 会占用端口
    如果没安装lsof则：yum install lsof
    lsof -i tcp:8080 查看PID
    kill -9 PID
Ctrl + C 不会占用端口
```
结果：
```text
vite v2.9.9 dev server running at:

  > Local:    http://localhost:8080/
  > Network:  http://10.202.161.208:8080/
  > Network:  http://2.0.2.174:8080/
```

+ 将启动命令放到后台执行
```shell
nohup npm run dev > docs.log 2>&1 &
```


+ node版本不够报错的时候
```shell
node -v  #查看当前版本

whereis node #查看node地址
node: /usr/bin/node /usr/local/bin/node /usr/share/node /usr/share/man/man1/node.1.gz

# 找到用来安装指定版本的n命令
cd /usr/local/bin/
ls
chardetect  cloud-id  cloud-init  cloud-init-per  corepack  jsonschema  n  node  npm  npx

./n v18.4.0  #安装指定版本
```

+ 更新版本
```shell
ssh root@45.40.228.219
cd /home/lighthouse/Linzlb_Seehope/
git pull
```
* [返回主页](../home.md)