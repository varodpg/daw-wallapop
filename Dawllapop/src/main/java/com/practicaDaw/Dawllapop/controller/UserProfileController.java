package com.practicaDaw.Dawllapop.controller;

import com.practicaDaw.Dawllapop.Entities.Rol;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import javax.annotation.PostConstruct;

@Controller

public class UserProfileController {
	
	@RequestMapping("/user-profile")
	public String userProfile() {
		return "user-profile";
	}

	@Autowired    
	private UserRepository repository;

	@PostConstruct
	public void init() {



        User u = new User("Alvaro", "varoTheBestNoob@hotmail.com", "soy tontito", "Mostoles", Rol.Admin);
        repository.save(u);


	}


}
