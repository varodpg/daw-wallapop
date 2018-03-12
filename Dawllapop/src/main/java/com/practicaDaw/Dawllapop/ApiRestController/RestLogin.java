package com.practicaDaw.Dawllapop.ApiRestController;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.controller.LoginController;
import com.practicaDaw.Dawllapop.security.UserComponent;

@RestController
public class RestLogin {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserComponent userComponent;

	@RequestMapping("/api/login")
	@JsonView(User.BasicInformation.class)
	public ResponseEntity<User> logIn() {

		if (!userComponent.isLoggedUser()) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			User loggedUser = userComponent.getLoggedUser();
			log.info("Logged as " + loggedUser.getName());
			return new ResponseEntity<>(loggedUser, HttpStatus.OK);
			
		}
	}

	@RequestMapping("/api/logout")
	public ResponseEntity<Boolean> logOut(HttpSession session) {
		if (!userComponent.isLoggedUser()) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			session.invalidate();
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
	}

}
