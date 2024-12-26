package com.crudspring.crud.infrasecurity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.crudspring.crud.model.Usuario;

@Service
public class TokenService {
	@Value("${api.security.token.secret}")
	private String secret;
	public String geraToken(Usuario usuario) {
		
	
		try {
			Algorithm alg  = Algorithm.HMAC256(secret);
			String token = JWT.create()
					.withIssuer("auth-api")
					.withSubject(usuario.getUsername())
					.withExpiresAt(geraDataExpirada())
					.sign(alg);
		}catch(JWTCreationException e ) {
			throw new RuntimeException("Problemas na criacao do TOKEN");
		}
		
		return "";
	}
	public String validacaoToke(String token) {
		try {
			Algorithm alg = Algorithm.HMAC256(secret);
			return JWT.require(alg)
					.withIssuer("auth-api")
					.build()
					.verify(token)
				.getSubject();
			
		} catch (JWTVerificationException e) {
			return "";
		}
	}
	
	public Instant geraDataExpirada() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-3:00"));
	}
	
}
