package com.edson.hroauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

	@Bean// configura uma classe usada para criptografa senha
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean// metodo para setar a key de assinatura do token para o tokem, vai ser instanciado mais a frente
	public JwtAccessTokenConverter jtaAccessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("MY-SECRET-KEY");
		return  tokenConverter;
	}
	@Bean //metodo para ler as informaçoes do  tokem, o argumento recebido é o metodo acima
	public JwtTokenStore jtwJwtTokenStore() {
		return new JwtTokenStore(jtaAccessTokenConverter());
	}
}
