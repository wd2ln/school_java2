package com.zp.interceptor;



import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zp.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String data = request.getParameter("data");
        Map<String, Object> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        //判断token是否存在
        if (data==""){
            System.out.println("token is not haves");
            map.put("code",-1);
            map.put("success",false);
            map.put("message","没有token请登录");
            String s = objectMapper.writeValueAsString(map);
        }else {

            //token存在
            try {
                Map<String, Object> token = JwtUtil.getToken(data);
                request.setAttribute("claim", token);
                return true;
            } catch (AlgorithmMismatchException e) {
                map.put("message", "算法不匹配");
            } catch (InvalidClaimException e) {
                map.put("message", "非法载荷");
            } catch (SignatureVerificationException e) {
                map.put("message", "签名验证失败");
            } catch (TokenExpiredException e) {
                map.put("message", "token已过期");
            } catch (Exception e) {
                map.put("message", "token发生异常");
            }
            map.put("code", 1);
            map.put("success", true);
            String s = objectMapper.writeValueAsString(map);
           // response.getWriter().write(s);
            return true;
        }
        return false;
    }
}
