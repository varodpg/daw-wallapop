package com.practicaDaw.Dawllapop.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class User_profileController {
	
	
	
	@RequestMapping("/user-profile")
	public String index() {	
		return "user-profile";
	}

}
