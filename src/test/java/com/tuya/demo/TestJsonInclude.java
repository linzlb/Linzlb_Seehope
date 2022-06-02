package com.tuya.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;


public class TestJsonInclude {

    public static void main(String[] args) {
        Data data = Data.builder()
                .a(null)
                .b(null)
                .c(null).build();
        System.out.println(JSON.toJSONString(data, SerializerFeature.WriteMapNullValue));
        System.out.println(JSON.toJSONString(data));
    }

}

@Builder
@lombok.Data
@JsonInclude(JsonInclude.Include.ALWAYS)
class Data{
    private String a;

    @JSONField(serialize = false)
    private String b;

    //为null当时候不返回
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String c;
}