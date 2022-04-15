package com.tuya.demo; /**
 *
 * Copyright (c) 2021 Tuya
 *
 * This file is part of Tuya IoT Core
 *
 * Please ensure that you will not distribute , modify the the source code and not develop
 * any derivative products through the source code . Please ensure that you will not
 * deliver or disclose the source code to any third party.
 */

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HMACSHA256 {
	/**
     * 将加密后的字节数组转换成字符串
     *
     * @param b 字节数组
     * @return 字符串
     */
    public  static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }
    /**
     * sha256_HMAC加密
     * @param message 消息
     * @param secret  秘钥
     * @return 加密后字符串
     */
    public static String hmacSha256(String message, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            hash = byteArrayToHexString(bytes);
        } catch (Exception e) {
            System.out.println("Error HmacSHA256 ===========" + e.getMessage());
        }
        return hash;
    }

    /**
     *
     * @param message 加密数据
     * @param secret 加密密钥
     * @return 加密 16 进制流转的字符串
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String hmacSha256_atop(String message, String secret) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
        return Hex.encodeHexString(bytes);
    }

    public static void main(String[] args) {
		System.out.println(HMACSHA256.hmacSha256("hsm5qu4vxxh49seqp4j5" + "1559724010751", "A_xha58tetet4fv43jhjn3ycrt74wndrda_mcg8wqa4wpgp8u5vm9c4tt9fatqruvdm").toUpperCase());
	}
}