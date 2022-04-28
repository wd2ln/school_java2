package test;


import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;
import util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

public class TestJwtUtil {
    @Test
    public void test(){
        Map<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","tom");
        String token = JwtUtil.createToken(map);
        System.out.println(token);
    }
    @Test
    public void test1(){
        String tocken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjF9._4N3oVppV5_ASvh54CaU--UVkh4CpvYNdTx2J_kHAM8";
        DecodedJWT decodedJWT = JwtUtil.decToken(tocken);

        System.out.println(decodedJWT.getHeader());
        System.out.println(decodedJWT.getClaim("id"));
        System.out.println(decodedJWT.getClaim("name"));
    }
}
