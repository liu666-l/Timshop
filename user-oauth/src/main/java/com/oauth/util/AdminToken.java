package com.oauth.util;

import com.alibaba.fastjson.JSON;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

public class AdminToken {
public static String admintoken(){
    /*
    管理员令牌发放
     */
    //基于私钥生成jwt
    //1. 创建一个秘钥工厂
    //1: 指定私钥的位置
    ClassPathResource classPathResource = new ClassPathResource("admin.jks");
    //2: 指定秘钥库的密码
    String keyPass = "admin";
    KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource,keyPass.toCharArray());

    //2. 基于工厂获取私钥
    String alias = "admin";
    String password = "admin";
    KeyPair keyPair = keyStoreKeyFactory.getKeyPair("admin", "admin".toCharArray());
    //将当前的私钥转换为rsa私钥
    RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

    //3.生成jwt
    Map<String,Object> map = new HashMap();
    map.put("company","user");
    map.put("address","beijing");
    map.put("authorities",new String[]{"admin","user"});

    Jwt jwt = JwtHelper.encode(JSON.toJSONString(map), new RsaSigner(rsaPrivateKey));
    //获取令牌数据
    String jwtEncoded = jwt.getEncoded();
    System.out.println(jwtEncoded);
    return jwtEncoded;

}


}
