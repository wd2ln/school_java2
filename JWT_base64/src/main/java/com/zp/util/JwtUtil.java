package com.zp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    //获取token

    /**
     *
     * @param clami playload载荷
     * @param salt 盐
     * @return
     */
    public static String getToken(Map<String,Object> clami,String salt){
        //设置过期时间，创建时间
        clami.put("exp",System.currentTimeMillis()+1000*25);
        clami.put("iat",System.currentTimeMillis());
        //设置未编码的header
        String jsonHeander="{'alg':'HS256','typ':'JWT'}";
        //对header进行编码
        String enHeander = Base64.getEncoder().encodeToString(jsonHeander.getBytes());

        //对Playload进行操作
        ObjectMapper objectMapper = new ObjectMapper();
        String playLoad=null;
        try {
            playLoad = objectMapper.writeValueAsString(clami);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //给playload进行编码
        String enPlayLoad = Base64.getEncoder().encodeToString(playLoad.getBytes());

        //获取16进制的签名
        String sigture= DigestUtils.md5Hex(enHeander+"."+enPlayLoad+"."+salt);

        //最后组合
        StringBuilder stringBuilder = new StringBuilder();
        //token生成
        stringBuilder.append(enHeander)
                .append(".")
                .append(enPlayLoad)
                .append(".")
                .append(sigture);
        String token=new String(stringBuilder);
        return token;
    }

    /**
     * 解析token
     * @param token 要解析的token
     * @param salt 盐
     * @return
     */
    public static Map<String, Object> deToken(String token,String salt){
        Map<String, Object> result = new HashMap<>();

        //将token的header,playload,signatrue分开提取
        String[] split = token.split("\\.");
        String playLoad=split[1];
        //进行相应的解码
        byte[] jsonPlayLoad = Base64.getDecoder().decode(playLoad.getBytes(StandardCharsets.UTF_8));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> claim = null;
        try {
            claim = objectMapper.readValue(jsonPlayLoad, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取过期时间
        Long exp = (Long) claim.get("exp");
        if (System.currentTimeMillis()>exp){
            result.put("message", "token已经失效");
            result.put("code", -1);
            result.put("success", false);

            return result;
        }
        // 获取新的签名
        String sign = DigestUtils.md5Hex(split[0] + "." + split[1] +"."+ salt);

        // 签名相同说明token没问题
        if (sign.equals(split[2])) {
            result.put("message", "token没问题");
            result.put("code", 200);
            result.put("success", true);
            result.put("data", claim);
            return result;
        }

        result.put("message", "token无法验证");
        result.put("code", -1);
        result.put("success", false);

        return result;
    }
}
