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



        User u = new User("user", "email@hotmail.com", "userpass", "Mostoles", "ROLE_USER");
        repository.save(u);
		User u2 = new User("admin", "email2@hotmail.com", "adminpass", "Alcorcon", "ROLE_ADMIN");
		repository.save(u);
		repository.save(u2);


	}


}
