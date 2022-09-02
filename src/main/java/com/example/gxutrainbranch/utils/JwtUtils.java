package com.example.gxutrainbranch.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.gxutrainbranch.entity.Admin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MaoMao
 * @Description
 * @create 2022-09-02 9:23 AM
 */


@Component
public class JwtUtils {
    private static  final String CLAIM_KEY_USERNAME = "sub";//用户
    private static  final String CLAIM_KEY_CREATED = "created";//创建时间
//    @Value("${jwt.secret}")
    private String secret = "secret";//密钥
//    @Value("${jwt.expiration}")
    private Long expiration = Long.valueOf(3000);// 过期时间  毫秒

    /**
     *  根据用户信息生成Token
     * @param userName
     * @return
     */
    public String generateToken(String userName){
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userName);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /**
     *     根据claims生产token   private方法 给上面的调用
     * @param claims
     * @return
     */
    private String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+expiration*1000))//失效时间
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
     *  从Token中获取用户名
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token){
        String username;
        try {
            Claims claims = getClaimsFormToken(token);
            username = claims.getSubject();//获取用户名
        } catch (Exception exception) {
            username = null;
        }
        return username;
    }

    /**
     *  根据token获取载荷（claim）  **************************
     * @param token
     * @return
     */
    private Claims getClaimsFormToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return claims;
    }

    /**
     *  判断token是否有效
     * @param token
     * @param
     * @return
     */
    public boolean validateToken(String token){
        String username = getUsernameFromToken(token);
        return !isTokenExpired(token);
    }

    /**
     *  判断token是否可以被刷新  token过期了就不可以被刷新
     * @param token
     * @return
     */
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }


    /**
     *   刷新token 就是修改创建时间
     * @param token
     * @return
     */
    public String refreshToken(String token){
        Claims claims = getClaimsFormToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);//重新生成token
    }

    /**
     *  判断token是否过期
     * @param token
     * @return
     *
     *  失效时间时间在当前时间之前就是失效了
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());   //expiredDate < new Date()  true
    }

    /**
     *  token 中获取过期时间
     * @param token
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFormToken(token);
        Date expiration = claims.getExpiration();
        return expiration;
    }
}