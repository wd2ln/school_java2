package util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.HashMap;
import java.util.Map;

public  class  JwtUtil {
    private static final String ALG="HS256";
    private static final String TYP="JWT";
    private static final Map<String,Object> HEADER=new HashMap<>();
    private static final Algorithm ALGORITHM;
    private static final String STAT="fjeiafl";

    static {
        HEADER.put("alg",ALG);
        HEADER.put("typ",TYP);
        ALGORITHM=Algorithm.HMAC256(STAT);
    }
    //创建token
    public static String createToken(Map<String,Object> claim){
        String token = JWT.create()
                .withHeader(HEADER)
                .withClaim("claim", claim)
                .sign(ALGORITHM);

        return token;
    }
    //解析token
    public static DecodedJWT decToken(String token) {
        return JWT.require(ALGORITHM).build().verify(token);
    }
    //获取载荷
    public static Map<String,Object> getToken(String token){
        return decToken(token).getClaim("claim").asMap();
    }
}
