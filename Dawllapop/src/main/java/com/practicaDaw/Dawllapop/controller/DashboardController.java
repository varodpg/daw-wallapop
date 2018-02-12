package com.practicaDaw.Dawllapop.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class DashboardController {
	
	
	
	@RequestMapping("/dashboard")
	public String index() {	
		return "dashboard";
	}

}
