package cn.bm;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

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
        String encode = DigestUtils.md5DigestAsHex("123".getBytes());
        //02cb962ac59075b964b07152d234b70
        System.out.println(encode);
    }

}
