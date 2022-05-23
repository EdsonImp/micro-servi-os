package com.edson.hrapigatewayzull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy //habilita servidor zull
@EnableEurekaClient // tamb´´me é cliente do eureka
@SpringBootApplication
public class HrApiGatewayZullApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApiGatewayZullApplication.class, args);
	}

}
