package com.agungfAl.actionlearning.security;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {
    private SecretKey secretKey;
    private String rahasia = "rahasia";
    private static final String AUTH_KEY="roles";

    // inisialisasi
    @PostConstruct
    public void init(){
        //secret key
        // secret = Base64.getEncoder().encodeToString("secret".getBytes());
        String secret = Base64.getEncoder().encodeToString(rahasia.getBytes());
        this.secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");

    }
    // create token
    public String createToken(Authentication authentication){
        String username = authentication.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Date sekarang = new Date();
        if(!authorities.isEmpty()){
            String roles = authorities.stream().map(GrantedAuthority::getAuthority).reduce((a,b)->a+","+b).get();
            return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(sekarang)
            .claim(AUTH_KEY, roles)
            .signWith(SignatureAlgorithm.HS256,secretKey)
            .compact();
        }
        
        return Jwts.builder().setIssuedAt(sekarang).setSubject(username).signWith(SignatureAlgorithm.HS256,secretKey).compact();
    }
    // validate token
    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

            return true;
        } catch (Exception e) {
        }
        return false;
    }

    // get autentication
    public Authentication getAuthentication(String token){
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody(); 
        Object authClaim = claims.get(AUTH_KEY);
        Collection<? extends GrantedAuthority> authorities = 
            authClaim == null ? 
                AuthorityUtils.NO_AUTHORITIES : 
                AuthorityUtils.commaSeparatedStringToAuthorityList(authClaim.toString());

        User user = new User(claims.getSubject(),"",authorities);
        return new UsernamePasswordAuthenticationToken(user, "", authorities);
    }
}
