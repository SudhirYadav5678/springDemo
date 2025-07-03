package org.sudhir.service;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = "adsjfjkasdfkahsfkjhsdkfhkjasdhfkjsfuefhsdaf";
    private static final long ACCESS_TOKEN_EXPIRATION = 15*60*1000;
    private static final long REFRESH_TOKEN_EXPIRATION = 15*60*60*1000;

    //generate
    public String generateToken(String userName,Boolean isAccessToken){
        long expiration = isAccessToken?ACCESS_TOKEN_EXPIRATION:REFRESH_TOKEN_EXPIRATION;

        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUserNameFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validate(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token);
        } catch (JwtException ex){
            return false;
        }
        return true;
    }
}
