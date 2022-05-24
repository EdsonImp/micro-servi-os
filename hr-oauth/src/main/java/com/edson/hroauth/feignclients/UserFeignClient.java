package com.edson.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edson.hroauth.entities.User;

@Component
@FeignClient(name = "hr-user", path = "/users") // com quem a classe Oaut vai se comunicar usando para isso o feign
public interface UserFeignClient {
	
	@GetMapping(value="/search")
	ResponseEntity<User> findbyEmail(@RequestParam String email);

}
