package com.edson.hrapigatewayzull.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer //agora é um ressourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	//Esses string vao ser usados para liberar ou nao os caminhos, que foram pego la no properties do zuul
	private final static String[] PUBLIC = {"/hr-oauth/oauth/token**"};
	private final static String[] OPERATOR = {"/hr-work/**"};
	private final static String[] ADMIN = {"/hr-payroll/**", "/hr-user/**"};
	
	@Autowired
	private JwtTokenStore tokenstore;
	
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		
		resources.tokenStore(tokenstore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		.antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR","ADMIN")
		.antMatchers(ADMIN).hasRole("ADMIN")
		.anyRequest().authenticated(); //qualquer outra req precisa estar autenticada
	}
	

}
