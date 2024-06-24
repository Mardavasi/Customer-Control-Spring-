package com.customer.customer.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.customer.customer.entities.User;

import java.util.Date;

public class JwtUtil {

    // Clave secreta para firmar el token
    private static final String SECRET_KEY ="j64ydu29ed";
    // Algoritmo de firma del token
    private static  final  Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

    // Genera un token JWT para el usuario dado.
    public static String generateToken (User user){

        String token = JWT.create()
                .withIssuer("Marlon")// Emisor del token
                .withClaim("userId", user.getId())// Claim personalizado (en este caso, el ID del usuario)
                .withExpiresAt(getExpiresDate())// Fecha de expiración del token
                .sign(algorithm); // Firma del token con el algoritmo especificado
        return token;
    }

    /**
     * Obtiene la fecha de expiración para el token (7 días a partir de ahora).
     *
     * @return Fecha de expiración
     */
    private static Date getExpiresDate(){
      return   new Date(System.currentTimeMillis()+ (1000L* 60 * 60 * 24 * 7)); // 7 dias
    }

    /**
     * Obtiene el ID de usuario a partir del token JWT.
     *
     * @param token Token JWT del cual se extrae el ID de usuario
     * @return ID de usuario extraído del token
     */
    public static String getUserByToken(String token){
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("Marlon")
                .build();

        DecodedJWT decoded = verifier.verify(token);
        String userId = decoded.getClaim("userId").toString();
        return  userId;
    }

}
