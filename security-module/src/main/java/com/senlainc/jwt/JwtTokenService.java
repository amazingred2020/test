package com.senlainc.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenService {

    @Value("${token.expiration-minutes}")
    private String tokenExpirationTime;

    @Value("${token.key}")
    private String tokenKey;

    @Autowired
    private UserDetailsService userDetailsService;

    public String generateToken(UserDetails userDetails){
        String token = "";
        Map<String,Object> claims = new HashMap<>();
        claims.put("privileges", userDetails.getAuthorities());
        try {
            token = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(LocalDateTime.now()
                        .plusMinutes(Integer.parseInt(tokenExpirationTime))
                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS256, tokenKey)
                .compact();
        } catch (JwtException e){
            e.printStackTrace();
        }
        return token;
    }

    public Claims getClaimsFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(tokenKey)
                .build()
                .parseClaimsJws(token.substring(7))
                .getBody();
    }

    public String updateExpirationDateToken(String token){
        Claims claims = getClaimsFromToken(token);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(Date.from(LocalDateTime.now()
                        .plusMinutes(Integer.parseInt(tokenExpirationTime))
                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS256, tokenKey)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(tokenKey)
                .parseClaimsJwt(token)
                .getBody();
        return claims.getSubject();
    }

    public UserDetails loadUserByUsername(String username) {
        return userDetailsService.loadUserByUsername(username);
    }

    private Date getExpirationDateFromToken(String token){
        return getClaimsFromToken(token).getExpiration();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public boolean validateJwtToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}