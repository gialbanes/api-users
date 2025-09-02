package com.portfolio.api_users.business;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException; 
import com.portfolio.api_users.infrastructure.entity.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                .withIssuer("api-users") //quem criou
                .withSubject(user.getEmail()) //o usuário que está recebendo o token
                .withExpiresAt(generateExpirationDate()) //tempo de expiração
                .sign(algorithm); // faz a assinatura e geração final do token

            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro durante a geração do token.", exception);
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                .withIssuer("api-users")
                .build()
                .verify(token)
                .getSubject();
        } catch(JWTVerificationException exception){ 
            return "";
        }
    }

    // tempo de expiração de 2 horas no horário de Brasília
    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}