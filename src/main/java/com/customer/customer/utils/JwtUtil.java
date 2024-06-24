package com.customer.customer.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.customer.customer.entities.User;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY ="j64ydu29ed";

    public static String generateToken (User user){
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        String token = JWT.create()
                .withIssuer("Marlon")
                .withClaim("userId", user.getId())
                .withExpiresAt(getExpiresDate())
                .sign(algorithm);
        return token;
    }

    private static Date getExpiresDate(){
      return   new Date(System.currentTimeMillis()+ (1000L* 60 * 60 * 24 * 7)); // 7 dias
    }
}
