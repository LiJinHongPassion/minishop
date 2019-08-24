package com.cqut.minishop.util.jwt;

import io.jsonwebtoken.Claims;

import java.util.Map;
import java.util.UUID;

/**
 * 描述:
 * JWT服务类
 *
 * @author LJH
 * @date 2019/7/16-10:50
 * @QQ 1755497577
 */
public class JwtService {

    private static final long TOKEN_EXPIRED_TIME = 30 * 24 * 60 * 60;

    private static final String JWT_SECRET = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";

    private static final String JWT_ISSUER = "LJH-CodeAnt-MiniShop";

    public static String createPersonToken(Map map, String audience) {
        String personToken = JwtUtils.createJWT(map, audience, UUID.randomUUID().toString(), JWT_ISSUER, TOKEN_EXPIRED_TIME, JWT_SECRET);
        return personToken;
    }

    public static Claims parsePersonJWT(String personToken) {
        Claims claims = JwtUtils.parseJWT(personToken, JWT_SECRET);
        return claims;
    }
}
