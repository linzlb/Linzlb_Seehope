package com.tuya.demo;

import cn.hutool.core.net.url.UrlBuilder;

public class HttpRequest extends cn.hutool.http.HttpRequest {
    public HttpRequest(UrlBuilder url) {
        super(url);
    }
}
