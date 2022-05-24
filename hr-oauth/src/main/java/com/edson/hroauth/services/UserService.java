package com.edson.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edson.hroauth.entities.User;
import com.edson.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	
	//Essa classe serviço criará uma instancia de user local
	//Depois usa essa instancia do userfeing para se comunicar com
	//A classe user e pegar o usuario pesquisado e salvar em memoria em
	//uma instancia de user local, clonada da user original
	@Autowired   
	private UserFeignClient userFeignClient; //Esse feign foi criado como interface para instanaciar esse serviço aki e pesquisar no outro microserviço user
	
	public User findByEmail(String email) {
    User user = userFeignClient.findbyEmail(email).getBody();//precisa do getBody pra pegar esses dados
    if(user == null) {
    	throw new IllegalArgumentException("Email not found");
    }return user;
	}
}
