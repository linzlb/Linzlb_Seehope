import { defineUserConfig } from 'vuepress'

// 配置vuepress的基本文件
export default defineUserConfig({

  port: "8080",
  title: 'Linzlb_Jiangwan',
  description: 'Linzlb学习&面经_笔记',
  //指定 vuepress build 的输出目录
  dest: "./dist",
  locales: {
        "/": {
          lang: "zh-CN"
        }
      },
  // 是否开启默认预加载 js
  shouldPrefetch: (file, type) => false
})