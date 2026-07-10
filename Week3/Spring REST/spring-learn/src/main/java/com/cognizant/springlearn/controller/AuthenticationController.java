package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START");
        LOGGER.debug("authHeader: {}", authHeader);
        
        String user = getUser(authHeader);
        String token = generateJwt(user);
        
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        
        LOGGER.info("END");
        return map;
    }

    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.substring(6); // Remove "Basic "
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);
        String user = credentials.split(":")[0];
        LOGGER.debug("User: {}", user);
        return user;
    }

    private String generateJwt(String user) {
        // Using Keys.hmacShaKeyFor since we are using jjwt 0.11.5
        // Needs a 256-bit (32 bytes) key.
        String secret = "secretkeyCognizantDigitalNurtureJavaFSE123456"; 
        
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        builder.signWith(Keys.hmacShaKeyFor(secret.getBytes()));
        
        return builder.compact();
    }
}
