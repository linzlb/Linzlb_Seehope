---
prev: 4密码学
next: 6vuepress
---
* [返回主页](../home.md)
# markdown语法
### 1 标题
::: tip 标题的2种写法
Markdown 支持两种标题的语法，类 Setext 和类 atx 形式。<br>
类 Setext 形式是用底线的形式，利用 = （最高阶标题）和 - （第二阶标题)。<br>
类 Atx 形式则是在行首插入 1 到 6 个 # ，对应到标题 1 到 6 阶。<br>
:::

```markdown
类 Atx 形式写法：
# 一级标题
## 二级标题
### 三级标题
#### 四级标题
##### 五级标题
###### 六级标题
```
分割线的三种表示方法：
```markdown
*** 
--- 
___
```
效果：<br>
*** 
--- 
___


### 2 换行
```text
方法1：连敲2个以上空格+enter键；
方法2：利用html语法，<br>。
```

### 3 缩进/空格
```text
由于平时中文的排版习惯，首行通常缩进两字符什么的，所以顺便也了解以下操作,在markdown里这个还稍微有点麻烦，不是敲两下空格键就搞定的。这里需要借用html方面的空格实体。
首先明确1个汉字=2个空格大小
1、一个空格大小的表示&ensp; &#8194;两种用法显示效果一致。
2、两个空格大小的表示&emsp; &#8195;两种用法显示效果一致。
3、不换行空格的表示&nbsp; &#160;也是占一个空格的宽度大小。
```

### 4 正文字体
#### 1、粗/斜/删除线/下划线
```markdown
**加粗**，__加粗__  
*斜体*，_斜体_
***加粗斜体***
~~删除~~
```
效果：<br>
**加粗**，__加粗__ <br>
*斜体*，_斜体_ <br>
***加粗斜体*** <br>
~~删除~~
#### 2、反转义符号
```markdown
\\ 反斜杠
\` 反引号
\* 星号
\_ 下划线
\{\} 大括号
\[\] 中括号
\(\) 小括号
\# 井号
\+ 加号
\- 减号
\. 英文句号
\! 感叹号
```
#### 3、字体、字号、颜色
```markdown
指定字体类型： <font face="黑体">我是黑体字</font>
指定字体大小： <font size=12>我是12号字</font>
指定字体颜色：<font color=#0099ff>我是蓝色字</font> #0099ff 为颜色的16进制代码
指定字体颜色、字号、字体类型<font color=#0099ff size=12 face="黑体">黑体</font>
```

### 5 引用
> 如果一段的内容是引用别人的话，在被引用的文本前加上符号>。

> 嵌套引用1层
>> 嵌套引用2层
>>> 嵌套引用3层


### 6 插入图片
```markdown
![图片alt](图片地址  "optional title")
图片alt就是显示在图片下面的文字，相当于对图片内容的解释，可以不写~
图片地址链接可以是图片的本地地址或网址。
图片optional title是图片的标题，当鼠标悬置于图片上时显示的内容。title可加可不加~
```
<div align="center">
    <img src="../../picture/Ashe.png" width="10%">
</div>

![](../../picture/Ashe.png)

### 7 插入列表
#### （1） 无序列表
```markdown
- 列表内容
+ 列表内容
* 列表内容
```
#### （2）有序列表
1. 列表内容
2. 列表内容
3. 列表内容

#### （3）列表嵌套
```markdown
上一级和下一级之间敲三个空格即可。注意符号之后的空格不能少，符号之前的空格也不能少。
```
+ 一级目录
   + 二级目录
     + 三级目录

### 8 插入超链接
```markdown
[超链接名](超链接地址 "超链接title")
title可加可不加
文字链接 [链接名称](http://链接网址)
网址链接 <http://链接网址>
实例：
[简书](http://jianshu.com) &emsp;<http://jianshu.com>
[我的简书主页](https://www.jianshu.com/u/aaf8afe551a4 "浅羡")
```

### 9 表格
```markdown
| Tables        | Are           | Cool  |
| ------------- |:-------------:| -----:|
| col 3 is      | right-aligned | $1600 |
| col 2 is      | centered      |   $12 |
| zebra stripes | are neat      |    $1 |
```
效果:<br>
| Tables        | Are           | Cool  |
| ------------- |:-------------:| -----:|
| col 3 is      | right-aligned | $1600 |
| col 2 is      | centered      |   $12 |
| zebra stripes | are neat      |    $1 |


下面的在vuepress中才能显示，属于vuepress扩展
### 10 自定义容器
```markdown
::: tip 提醒
This is a tip
:::

::: warning 警告
This is a warning
:::

::: danger 🈲️
This is a dangerous warning
:::
```
效果：<br>
::: tip 提醒
This is a tip
:::

::: warning 警告
This is a warning
:::

::: danger 🈲️
This is a dangerous warning
:::

### 11 在代码块中高亮显示行
``` js{4}
export default {
  data () {
    return {
      msg: 'Highlighted!'
    }
  }
}
```

### 12 高级技巧
#### html元素
```text
不在 Markdown 涵盖范围之内的标签，都可以直接在文档里面用 HTML 撰写。
目前支持的 HTML 元素有：<kbd> <b> <i> <em> <sup> <sub> <br>等 ，如：
```
使用 <kbd>Ctrl</kbd>+<kbd>Alt</kbd>+<kbd>Del</kbd> 重启电脑


* [返回主页](../home.md)