import { defineUserConfig } from 'vuepress'

export default defineUserConfig({

  port: "8080",
  title: 'Linzlb_Seehpe',
  description: 'Linzlb学习&面经_笔记',
  locales: {
        "/": {
          lang: "zh-CN"
        }
      },
  // 是否开启默认预加载 js
  shouldPrefetch: (file, type) => false
})