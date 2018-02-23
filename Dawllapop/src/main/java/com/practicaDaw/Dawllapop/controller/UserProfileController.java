package com.practicaDaw.Dawllapop.controller;

import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.Rol;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import com.practicaDaw.Dawllapop.security.*;

@Controller

public class UserProfileController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserComponent userComponent;

	@RequestMapping("/add_new_user")
	public String add_new_user(Model model, User user) {
		repository.save(user);
		return "index";
	}

	@RequestMapping("/edit_user")
	public String edit_user(Model model, User user) {
		repository.saveAndFlush(user);
		return "index";
	}
	@RequestMapping("/delete_user")
	public String delete_user(Model model, User user) {
		repository.delete(user);
		return "index";
	}

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void init() {

		User u = new User("Alvaro", "varo@hotmail.com", "", "password", true, "Mostoles", "ROLE_ADMIN", "ROLE_USER");
		repository.save(u);
		User u2 = new User("Juanma", "juanma@hotmail.com", "", "password", true, "Alcorocn", "ROLE_USER");
		repository.save(u);
		repository.save(u2);

	}

	@RequestMapping("/user-profile")
	public String serveUserProfile(Model model, @RequestParam Optional<String> emailUser,
			@RequestParam Optional<String> passUser, @RequestParam Optional<Boolean> sent) {
		if (sent.isPresent()) {
			if (emailUser.isPresent()) {
				userComponent.getLoggedUser().setEmail(emailUser.get());
			}
			if (!passUser.get().equals("")) {
				userComponent.getLoggedUser().setPasswordHash(passUser.get());
			}
			userRepository.save(userComponent.getLoggedUser());
		}

		return "user-profile";
	}

}
