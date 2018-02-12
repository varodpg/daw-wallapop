package com.practicaDaw.Dawllapop.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class SingleController {
	
	
	
	@RequestMapping("/single")
	public String index() {	
		return "single";
	}

}
