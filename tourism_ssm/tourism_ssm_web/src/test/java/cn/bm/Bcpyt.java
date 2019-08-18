package cn.bm;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * 加密测试
 */
public class Bcpyt {

    @Test
    public void bcpty(){
        String str = "123";
        /*
        $2a$10$EwXxu2XI3Jz/ZtADnef1y.aP0TsrWfuKoEDX855azF3D4zRTXKByu
        $2a$10$pNWltMggCSJCW6WgK/Go3O5qUjhl.bG8l7779irOdkKwY0NelmvAe
        $2a$10$eOb.FVek3wfNdYC8K4YkJOAEgxjop4tihr6nqy07GVnwpljCqr1oy
         */
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(str);
        System.out.println(encode);
    }

    @Test
    public void  md5() throws NoSuchAlgorithmException {
        String str = "123";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        str = new BigInteger(1, md5.digest(str.getBytes())).toString(32);
        str = new String(str.getBytes());
        System.out.println(str);
    }

}
