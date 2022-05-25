package com.edson.hrapigatewayzull.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@RefreshScope //para atualizar em tempo real, do actuator
@Configuration
public class AppConfig { //pegando configuração do application.properties do config no github
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	@Bean// metodo para setar a key de assinatura do token para o tokem, vai ser instanciado mais a frente
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(jwtSecret);//a secret esta vindo direto de uma variavel quepega da nuvem no git, de forma segura
		return  tokenConverter;
	}
	@Bean //metodo para ler as informaçoes do  tokem, o argumento recebido é o metodo acima
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

}
