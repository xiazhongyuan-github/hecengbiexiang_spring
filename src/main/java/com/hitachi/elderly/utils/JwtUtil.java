package com.hitachi.elderly.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JwtUtil {
    /**
    * @Description: 验证Token的合法性
    * @Param: [jsonWebToken, base64Security]
    * @return: io.jsonwebtoken.Claims
    * @Author: lizhe
    * @Date: 2018/9/4
    */
    public static Claims parseJWT(String jsonWebToken, String base64Security){
        try
        {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    /**
    * @Description:  根据账户编号，账户名等生成Token
    * @Param: [name, code, audience, TTLMillis, base64Security]
    * @return: java.lang.String
    * @Author: lizhe
    * @Date: 2018/9/4
    */
    public static String createJWT(String name, String code, String audience, long TTLMillis, String base64Security)
    {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .claim("name", name)
                .claim("code", code)
                .setAudience(audience)
                .setSubject(code)
                .signWith(signatureAlgorithm, signingKey);
        //添加Token过期时间
        if (TTLMillis >= 0) {
            long expMillis = nowMillis + TTLMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }

        //生成JWT
        return builder.compact();
    }
    /** 
    * @Description: 根据请求头返回请求人Code 
    * @Param: [request, base64Security] 
    * @return: java.lang.String 
    * @Author: lizhe 
    * @Date: 2018/9/12 
    */
    public static String  getStaffCode(HttpServletRequest request, String base64Security){
        try
        {
            String authorization = request.getHeader("Authorization");
            String token = authorization.substring(7);
            Claims claims = parseJWT(token, base64Security);
            return claims.get("code", String.class);
        }
        catch(Exception ex)
        {
            return null;
        }
    }
}
