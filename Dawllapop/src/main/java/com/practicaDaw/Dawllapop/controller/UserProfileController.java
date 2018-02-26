package com.practicaDaw.Dawllapop.controller;

import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.Rol;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.practicaDaw.Dawllapop.security.*;
import com.practicaDaw.Dawllapop.services.UserServices;

@Controller

public class UserProfileController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserComponent userComponent;
	@Autowired
	private UserServices uss;

	@RequestMapping("/add_new_user")
	public String add_new_user(Model model, User user) {
		repository.save(user);
		return "index";
	}

	@RequestMapping("/edit_profile")
	public String editProfile(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute(user);
		return "user-profile";
	}

	@RequestMapping("/editEmailProfileBBDD")
	public String editEmailProfileBBDD(Model model, @RequestParam String email, HttpSession session) {
		User user = (User) session.getAttribute("user");
		user.setEmail(email);
		repository.saveAndFlush(user);
		return "/";
	}

	@RequestMapping("/editDatesProfileBBDD")
	public String editDatesProfileBBDD(Model model, @RequestParam String name, @RequestParam String location,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		user.setName(name);
		user.setLocation(location);
		repository.saveAndFlush(user);
		return "/";
	}

	@RequestMapping("/editPasswordProfileBBDD")
	public String editPasswordProfileBBDD(Model model, @RequestParam String passwordHash, HttpSession session) {
		User user = (User) session.getAttribute("user");
		user.setPasswordHash(passwordHash);
		repository.saveAndFlush(user);
		return "/";
	}

	@RequestMapping("/deleteProfileBBDD")
	public String deleteProfileBBDD(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		repository.delete(user);
		return "/";
	}

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void init() {

	

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
