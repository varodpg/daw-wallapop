package com.practicaDaw.Dawllapop.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class Dashboard_publicController {
	
	
	
	@RequestMapping("/dashboard-public")
	public String index() {	
		return "dashboard-public";
	}

}
