package com.edson.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edson.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//O email será a busca do jwp para autenticar
	User findByEmail(String email); //Com esse nome a interface ja cria a busca por email automaticamente

}
