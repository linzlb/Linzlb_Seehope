package com.tuya.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: LX.LIU
 * @create: 2022/4/2 下午4:20
 */
public class TestHttpRequest {

    private static final String SIGN_METHOD = "HMAC-SHA256";
    private static String SCENE_INFRARED_RULE = "/v2.0/infrareds/%s/categories/%s/brands/%s/remotes/%s/rules";
    private static String SCENE_INFRARED_CATEGORY = "/v2.0/infrareds/%s/categories";
    private static String SCENE_INFRARED_BRAND = "/v2.0/infrareds/%s/categories/%s/brands";
    private static String SCENE_INFRARED_STANDARD_COMMAND = "/v2.0/infrareds/%s/remotes/%s/command";
    private static String SCENE_INFRARED_QUERY_REMOTES = "/v2.0/infrareds/%s/remotes";

    public static void main(String[] args) {

//        testGetToken("f9yfafscad3kppdtor3d", "e28d6524af1749e183708db36f55c330");
        testInfraredCtrl("f9yfafscad3kppdtor3d", "e28d6524af1749e183708db36f55c330", "6ca153e3092d4857a20ejq", "6c798b4c5740944224nhbl");
//        testInfraredQueryCategory("f9yfafscad3kppdtor3d", "e28d6524af1749e183708db36f55c330", "6ca153e3092d4857a20ejq");
//        testInfraredQueryBrand("f9yfafscad3kppdtor3d", "e28d6524af1749e183708db36f55c330", "6ca153e3092d4857a20ejq", 2);
//        testInfraredQueryRules("f9yfafscad3kppdtor3d", "e28d6524af1749e183708db36f55c330", "6ca153e3092d4857a20ejq", 2, 27, 10982);
//        testInfraredQueryRemote("f9yfafscad3kppdtor3d", "e28d6524af1749e183708db36f55c330", "6ca153e3092d4857a20ejq");
    }

    public static String testInfraredQueryRemote(String clientId, String secret, String infraredId){
        String path = String.format(SCENE_INFRARED_QUERY_REMOTES, infraredId);
        String result = com.tuya.demo.HttpRequest.get("https://openapi.tuyacn.com"+path)
                .addHeaders(getInfraredHeader(clientId, secret))
                .execute().body();
        System.out.println("result:");
        System.out.println(result);
        return result;
    }



    public static String testInfraredQueryRules(String clientId, String secret, String infraredId, Integer categoryId, Integer brandId,  Integer remoteIndex){
        String path = String.format(SCENE_INFRARED_RULE, infraredId, categoryId, brandId, remoteIndex);
        String result = com.tuya.demo.HttpRequest.get("https://openapi.tuyacn.com"+path)
                .addHeaders(getInfraredHeader(clientId, secret))
                .execute().body();
        System.out.println("result:");
        System.out.println(result);
        return result;
    }

    public static String testInfraredQueryBrand(String clientId, String secret, String infraredId, Integer categoryId){
        String path = String.format(SCENE_INFRARED_BRAND, infraredId, categoryId);
        String result = com.tuya.demo.HttpRequest.get("https://openapi.tuyacn.com"+path)
                .addHeaders(getInfraredHeader(clientId, secret))
                .execute().body();
        System.out.println("result:");
        System.out.println(result);
        return result;
    }

    public static String testInfraredQueryCategory(String clientId, String secret, String infraredId){
        String path = String.format(SCENE_INFRARED_CATEGORY, infraredId);
        String result = com.tuya.demo.HttpRequest.get("https://openapi.tuyacn.com"+path)
                .addHeaders(getInfraredHeader(clientId, secret))
                .execute().body();
        System.out.println("result:");
        System.out.println(result);
        return result;
    }


    public static String testInfraredCtrl(String clientId, String secret, String infraredId, String remoteId){
        String path = String.format(SCENE_INFRARED_STANDARD_COMMAND, infraredId, remoteId);
        Map<String, Object> map = new HashMap();
        map.put("key", "Power");
        map.put("category_id", 2);
        String result = com.tuya.demo.HttpRequest.post("https://openapi.tuyacn.com"+path)
                .addHeaders(getInfraredHeader(clientId, secret))
                .body(JSON.toJSONString(map))
                .execute().body();
        System.out.println("result:");
        System.out.println(result);
        return result;
    }

    public static String testGetToken(String clientId, String secret) {
        String result = com.tuya.demo.HttpRequest.get("https://openapi.tuyacn.com/v1.0/token?grant_type=1")
                .addHeaders(getTokenHeader(clientId, secret))
                .execute().body();
        System.out.println("result:");
        System.out.println(result);
        JSONObject jsonObject = JSON.parseObject(result);
        String accessToken = JSON.parseObject(jsonObject.get("result").toString()).get("access_token").toString();
        System.out.println("accessToken:"+accessToken);
        return accessToken;
    }

    private static Map<String, String> getTokenHeader(String clientId, String secret) {
        Map<String, String> headers = new HashMap();
        headers.put("client_id", clientId);
        String t = String.valueOf(System.currentTimeMillis());
        headers.put("sign", calcSignSHA256(clientId, secret, t));
        headers.put("t", t);
        headers.put("sign_method", SIGN_METHOD);
        return headers;
    }

    private static Map<String, String> getInfraredHeader(String clientId, String secret) {
        Map<String, String> headers = new HashMap();
        headers.put("client_id", clientId);
        String t = String.valueOf(System.currentTimeMillis());
       String accessToken = testGetToken(clientId, secret);
        headers.put("access_token", accessToken);
        headers.put("sign", calcSignSHA256(accessToken, clientId, secret, t));
        headers.put("t", t);
        headers.put("sign_method", SIGN_METHOD);
        return headers;
    }

    private static String calcSignSHA256(String clientId, String secret, String timestamp) {
        return com.tuya.demo.HMACSHA256.hmacSha256(clientId + timestamp, secret).toUpperCase();
    }

    private static String calcSignSHA256(String accessToken, String clientId, String secret, String timestamp) {
        return com.tuya.demo.HMACSHA256.hmacSha256(clientId + accessToken + timestamp, secret).toUpperCase();
    }
}
