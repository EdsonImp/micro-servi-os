package com.edson.hruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableEurekaClient //também é um cliente eureka
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner {//imlementa Commandolineruner par aimprimir no console ao rodar
	
	@Autowired//injetei o metodo criado no config com @Bean
	private BCryptPasswordEncoder passwordEncoder; //usarei para encriptografar 

	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("BCRYPT = "+ passwordEncoder.encode("123456"));
		
	}

}
