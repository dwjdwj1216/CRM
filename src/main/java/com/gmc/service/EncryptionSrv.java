package com.gmc.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 顾梦超 on 2016/4/24.
 */
@Service
public class EncryptionSrv {
    private static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /*
    * 加密
    * */
    public static String decode(String password) {
        return new String(md.digest(password.getBytes()));
    }
}
