package com.honger1234.springbootprojectseed.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Description: JWT工具类
 * @author: zt
 */
@Slf4j
public class JWTUtil {

    private static String SECRET="WgtqaT1HNTZPZNMDJu3k" ;

    private static long EXPIRE=60;//失效时间,60分钟

    /**
     * 生成token
     *
     * @param uid
     * @return
     */
    public static String generate(String uid,String subject) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + EXPIRE * 1000);
//        Map<String, Object> claims = new HashMap<>(1);
//        claims.put("id", uid);
        return Jwts.builder()
                .setId(uid) //jwt的唯一标识
                .setSubject(subject) //代表这个jwt的主体
//                .setClaims(claims)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * 解析Claims
     *
     * @param token
     * @return
     */
    public static Claims getClaim(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("token解析错误", e);
            throw new IllegalArgumentException("Token invalided.");
        }
        return claims;
    }

    /**
     * 获取jwt发布时间
     */
    public static Date getIssuedAt(String token) {
        return getClaim(token).getIssuedAt();
    }

    /**
     * 获取UID
     */
    public static String getUid(String token) {
        return (String) getClaim(token).get("id");
//        return TypeUtils.castToInt(getClaim(token).get(UID));
    }

    /**
     * 获取jwt失效时间
     */
    public static Date getExpiration(String token) {
        return getClaim(token).getExpiration();
    }

    /**
     * 验证token是否失效
     *
     * @param token
     * @return true:过期   false:没过期
     */
    public static boolean isExpired(String token) {
            Date expiration = getExpiration(token);
            return expiration.before(new Date());
    }

}
