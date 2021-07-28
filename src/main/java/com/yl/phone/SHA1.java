package com.yl.phone;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * @author: vaeling.you
 * @create: 2021/7/13
 */
public class SHA1 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.update("str".getBytes(StandardCharsets.UTF_8));
        System.out.println(byteToHex(crypt.digest()));
    }

    /**
     * 进行sha1加密
     *
     * @param hash 需要进行计算的字符串集合
     * @return 加密后的结果
     */
    private static String byteToHex(byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

}


