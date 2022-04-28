package com.zp.test;

import com.zp.util.JwtUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestToken {
    @Test
    public void test1(){
        Map<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","tom");
        String salt="uuuiii";
        String token = JwtUtil.getToken(map, salt);
        System.out.println(token);
    }
    @Test
    public void test2(){
        Map<String, Object> map = JwtUtil.deToken("eydhbGcnOidIUzI1NicsJ3R5cCc6J0pXVCd9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY0OTMyMzg4ODczNSwiaWF0IjoxNjQ5MzIzODYzNzM1fQ==.64632820b92733d8e0849de4e696376d","uuuiii");
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
