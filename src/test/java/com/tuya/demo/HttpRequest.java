package com.tuya.demo;

import cn.hutool.core.net.url.UrlBuilder;

/**
 * @description:
 * @author: LX.LIU
 * @create: 2022/4/2 下午4:19
 */
public class HttpRequest extends cn.hutool.http.HttpRequest {
    public HttpRequest(UrlBuilder url) {
        super(url);
    }
}
