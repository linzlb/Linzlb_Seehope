package com.tuya.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


public class TestJsonInclude {

    public static void main(String[] args) {
        Data data = Data.builder()
                .a(null)
                .b(null)
                .c(null).build();
        System.out.println(JSON.toJSONString(data, SerializerFeature.WriteMapNullValue));
        System.out.println(JSON.toJSONString(data));


        //测试经过了网关后暴露出去的，还也没有null字段
        //结论：找不到了
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://smarthome-api-dev.coli688.com/idueros/third-center/callback";
            String req = "{\n" +
                    "    \"header\":{\n" +
                    "        \"payloadVersion\":\"1\",\n" +
                    "        \"name\":\"DiscoverAppliancesRequest\",\n" +
                    "        \"namespace\":\"DuerOS.ConnectedHome.Discovery\",\n" +
                    "        \"messageId\":\"_Smarthome_617f9065561536.34776942\"\n" +
                    "    },\n" +
                    "    \"payload\":{\n" +
                    "        \"accessToken\":\"kOZjpuIRaSuEdy8iXrAGGDMwCEXDirpxmyOSjgF8aquH4fg94N\",\n" +
                    "        \"openUid\":\"linzlb\"\n" +
                    "    }\n" +
                    "}";
            Object reqObj = JSONObject.parseObject(req);
            ResponseEntity<Object> response = restTemplate.postForEntity(url, reqObj, Object.class);
            Object responseBody = response.getBody();
            System.out.println(JSON.toJSONString(responseBody, SerializerFeature.WriteMapNullValue));

        } catch (RestClientException e) {
            e.printStackTrace();
        }
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