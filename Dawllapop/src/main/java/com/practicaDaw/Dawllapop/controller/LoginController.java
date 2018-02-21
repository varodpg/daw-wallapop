package com.practicaDaw.Dawllapop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/loginerror")
	public String loginerror() {
		return "loginerror";
	}
	
//	@RequestMapping("/dashboard")
//	public String home(Model model, HttpServletRequest request) {
//		
//		model.addAttribute("admin", request.isUserInRole("ADMIN"));
//	
//		return "dashboard";
//	}
}
