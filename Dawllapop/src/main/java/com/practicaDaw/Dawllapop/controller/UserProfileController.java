package com.practicaDaw.Dawllapop.controller;

import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.Rol;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.annotation.PostConstruct;
import com.practicaDaw.Dawllapop.security.*;

@Controller

public class UserProfileController {
	
	@RequestMapping("/user-profile")
	public String userProfile() {
		return "user-profile";
	}
	
	@RequestMapping("/add_new_user")
	public String add_new_user(Model model, User user){		
		repository.save(user);
		return "index";
	}

	@Autowired    
	private UserRepository repository;

	@PostConstruct
	public void init() {



        User u = new User("Alvaro", "varo@hotmail.com","", "password",true, "Mostoles", "ROLE_ADMIN");
        repository.save(u);
		User u2 = new User("Juanma", "tengomuchosproblemas@hotmail.com","", "tonto",true, "Alcorocn", "ROLE_USER");
		repository.save(u);
		repository.save(u2);

	}


}
