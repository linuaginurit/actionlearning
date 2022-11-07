package com.agungfAl.actionlearning.security;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtProvider {
    private SecretKey secretKey;
    private static final String AUTH_KEY="reoles";
    
    // inisialisasi
    public void init(){
        //secret key
        // secret = Base64.getEncoder().encodeToString("secret".getBytes());
       
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
