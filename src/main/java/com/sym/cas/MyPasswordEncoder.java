package com.sym.cas;


import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.util.Formatter;

/**
 * @author suyiming3333@gmail.com
 * @version V1.0
 * @Title: asd
 * @Package PACKAGE_NAME
 * @Description: TODO
 * @date 2019/4/12 17:23
 */
public class MyPasswordEncoder implements PasswordEncoder {
    public String encode(CharSequence password) {
        try {
            //给数据进行md5加密
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.toString().getBytes());
            return toHexString(md.digest());
            //return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean matches(CharSequence rawPassword, String encodePassword) {
        // 判断密码是否存在
        if (rawPassword == null) {
            return false;
        }

        //通过md5加密后的密码
        String pass = this.encode(rawPassword.toString());
        //比较密码是否相等的问题
        return pass.equals(encodePassword); }

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        String res = formatter.toString();
        formatter.close();

        return res;
    }

    public static void main(String[] args) {
        System.out.println(111);
    }
}
