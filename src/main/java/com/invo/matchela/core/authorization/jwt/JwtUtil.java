package com.invo.matchela.core.authorization.jwt;

import com.invo.matchela.core.authorization.user.User;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author : Rujan Maharjan on  6/12/2021
 **/
@Service
public class JwtUtil {

    private String secret;
    private int jwtExpirationInMs;
    private int refreshExpirationDateInMs;

    @Value("${jwt.secret}")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Value("${jwt.expirationDateInMs}")
    public void setJwtExpirationInMs(int jwtExpirationInMs) {
        this.jwtExpirationInMs = jwtExpirationInMs;
    }

    @Value("${jwt.refreshExpirationDateInMs}")
    public void setRefreshExpirationDateInMs(int refreshExpirationDateInMs) {
        this.refreshExpirationDateInMs = refreshExpirationDateInMs;
    }

    public String generateToken(User userDetails, String deviceId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("deviceId",deviceId);
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String doGenerateRefreshToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + refreshExpirationDateInMs))
                .signWith(SignatureAlgorithm.HS512, secret).compact();

    }

    public String generateTokenFromUsername(String username, Map<String, Object> claimsFromToken) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setClaims(claimsFromToken)
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationInMs)).signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
            throw new BadCredentialsException("Invalid Token");
        } catch (ExpiredJwtException ex) {
            throw new BadCredentialsException("Token Expired");
        }
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public Date getIssuedAtFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getIssuedAt();
    }

    public Object getDataFromToken(String token, String key){
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.get(key);
    }


    public Collection<GrantedAuthority> getRolesFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        List<Map<String, String>> roleList = claims.get("roles", List.class);
        List<GrantedAuthority> authorities = new ArrayList<>();
        roleList.forEach(stringStringMap -> authorities.add(new SimpleGrantedAuthority(stringStringMap.get("authority"))));
        return authorities;
    }

    public Map<String, Object> getClaimsFromToken(String accessToken) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(accessToken).getBody();
        Map<String, Object> copiedClaims = new HashMap<>();
        copiedClaims.put("deviceId",copiedClaims.get("deviceId"));
        copiedClaims.put("roles",copiedClaims.get("roles"));
        return copiedClaims;
    }
}
