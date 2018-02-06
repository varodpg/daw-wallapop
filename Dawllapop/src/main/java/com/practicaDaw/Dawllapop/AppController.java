package com.practicaDaw.Dawllapop;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class AppController {
	
	
	
	@RequestMapping("/")
	public String index() {	
		return "index";
	}

}
