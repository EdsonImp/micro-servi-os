package com.edson.hruser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

	//OBS, não existe instancia direta para o BCpasswordEncoder, por isso
	//é nescessário criar esse método e injetá-lo como @Bean para usa-lo depois
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
