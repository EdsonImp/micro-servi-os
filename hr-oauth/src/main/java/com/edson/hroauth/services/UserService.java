package com.edson.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edson.hroauth.entities.User;
import com.edson.hroauth.feignclients.UserFeignClient;


//será usada como userdetalheSErvice
@Service
public class UserService implements UserDetailsService {
	
	//Essa classe serviço criará uma instancia de user local
	//Depois usa essa instancia do userfeing para se comunicar com
	//A classe user e pegar o usuario pesquisado e salvar em memoria em
	//uma instancia de user local, clonada da user original
	@Autowired   
	private UserFeignClient userFeignClient; //Esse feign foi criado como interface para instanaciar esse serviço aki e pesquisar no outro microserviço user
	//abaixo apenas para estudo, nao é usada pelo jwt security
	public User findByEmail(String email) {
    User user = userFeignClient.findbyEmail(email).getBody();//precisa do getBody pra pegar esses dados
    if(user == null) {
    	throw new IllegalArgumentException("Email not found");
    }return user;
	}

	//metodo usado pelo userdetalhe service do jwt para pegar user por username
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findbyEmail(username).getBody();//precisa do getBody pra pegar esses dados
	    if(user == null) {
	    	throw new UsernameNotFoundException("Email not found");
	    }return user;
		}
	}

