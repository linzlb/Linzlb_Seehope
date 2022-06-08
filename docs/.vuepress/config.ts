import { defineUserConfig } from 'vuepress'
import type { DefaultThemeOptions } from 'vuepress'

// 配置vuepress的基本文件
export default defineUserConfig<DefaultThemeOptions>({

  port: "80",
  title: 'AllRandomのNote',
  description: 'Linzlb学习&面经_笔记',
  //指定 vuepress build 的输出目录
  dest: "./dist",
  //浏览器页签左上角logo
  head: [
      ['link', { rel: 'icon', href: `/favicon.ico` }]
    ],
  locales: {
        "/": {
          lang: "zh-CN"
        }
      },
  // 是否开启默认预加载 js
  shouldPrefetch: (file, type) => false,
  themeConfig : {
    logo: '/logo.png',
  },
})