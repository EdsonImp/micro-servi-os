package com.edson.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edson.hruser.entities.User;
import com.edson.hruser.repositories.UserRepository;



@RestController
@RequestMapping(value= "/users")
public class UserResource {
	
	@Autowired
	UserRepository repository;
	
	@GetMapping (value= "/{id}")
	public ResponseEntity<User> findById(@PathVariable  Long id){
		User obj = repository.findById(id).get(); //retorna um optional, por isso o .get
		return ResponseEntity.ok(obj);

}
	@GetMapping (value= "/search")//nesse caso, nao sabemos o qque procura/ vai uma interrogação
	public ResponseEntity<User> findBy(@RequestParam  String email){ //REquest param, pois o param vem ao chamar o endpoint 
		User obj = repository.findByEmail(email); //retorna um optional, por isso o .get
		return ResponseEntity.ok(obj);

}
}
