package jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestJwt {
//    编码
    @Test
    public void coding(){
        //设置hender
        Map<String, Object> hender = new HashMap<>();
        hender.put("alg","HS256");
        hender.put("typ","JWT");
        //设置载荷
        Map<String, Object> payLoad = new HashMap<>();
        payLoad.put("id",200);
        payLoad.put("name","tom");
        String sign = JWT.create()
                .withHeader(hender)
                .withPayload(payLoad)
                .withExpiresAt(new Date())//到期时间
                .sign(Algorithm.HMAC256("123456"));
        System.out.println(sign);
    }

    //解码
    @Test
    public void decoding(){
        JWTVerifier build = JWT.require(Algorithm.HMAC256("123456")).build();
        DecodedJWT verify = build.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjIwMH0.gnC6QlfhVrjmByaL5UwgdPsgwaIwu96LQTRJsrshRR0");
        //获取头
        System.out.println(verify.getHeader());
        //获取载荷
        System.out.println(verify.getPayload());
        //获取使用的算法
        System.out.println(verify.getAlgorithm());
        //获取签名
        System.out.println(verify.getSignature());

        //获取载荷里键的值
        System.out.println(verify.getClaim("name"));
    }
}
