package com.edson.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edson.hroauth.entities.User;
import com.edson.hroauth.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//cria uma instancia de um serviço que conecta ao user para pesquisar
	@Autowired
	private UserService service;
	
	@GetMapping(value="/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		try {
			User user = service.findByEmail(email);//instancia um user local, e passa pra eles os valores pegos do user certo via feign.service
			return ResponseEntity.ok(user);
			
		} catch (IllegalArgumentException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();			
		}
		
	}

}
