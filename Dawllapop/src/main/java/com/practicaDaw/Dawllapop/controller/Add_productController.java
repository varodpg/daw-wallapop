package com.practicaDaw.Dawllapop.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class Add_productController {
	
	
	
	@RequestMapping("/")
	public String index() {	
		return "index";
	}

}