package com.arnasrad.vismainternship.revolut.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenService {
    @Value("${jwt.issuer}")
    private String jwtIssuer;

    @Value("${jwt.subject}")
    private String jwtSubject;

    @Value("${jwt.audience}")
    private String jwtAudience;

    @Autowired
    private KeyLoadService keyLoadService;

    public String generateToken() {

        Map<String, Object> claims = new HashMap<>();
        PrivateKey signingKey = keyLoadService.getPrivateKeyFromResources();
        return buildJwt(claims, signingKey);
    }

    private String buildJwt(Map<String, Object> claims, PrivateKey signingKey) {

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer(jwtIssuer)
                .setSubject(jwtSubject)
                .setAudience(jwtAudience)
                .signWith(SignatureAlgorithm.RS256, signingKey)
                .compact();
    }
}