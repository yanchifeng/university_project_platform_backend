package com.example.university_project_platform_backend.common;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
public class TokenCommon {

    /**
     * 密钥
     */
    private static final String SECRET = "big_band";

    /**
     * 过期时间（单位：秒）
     **/
    private static final long EXPIRATION = 3600L;

    /**
     * 生成用户token,设置token超时时间
     *
     * @param
     * @param userPassword
     * @return
     */
    public static String createToken( String userID, String userPassword) {
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                // 添加头部
                .withHeader(map)
                // 放入用户的id
                .withAudience(String.valueOf(userID))
                // 可以将基本信息放到claims中
                .withClaim("account", userID)
                .withClaim("password", userPassword)
                // 超时设置,设置过期的日期
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                // 签发时间
                .withIssuedAt(new Date())
                // SECRET加密
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    public static Long getUserIdFormToken(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            List<String> audience = jwt.getAudience();
            Claim data =jwt.getClaim("password");
            System.out.println(audience);
            System.out.println(data.asString());
            return Long.parseLong(audience.get(0));
        } catch (IllegalArgumentException e) {

            e.printStackTrace();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }
        return null;
    }


}
