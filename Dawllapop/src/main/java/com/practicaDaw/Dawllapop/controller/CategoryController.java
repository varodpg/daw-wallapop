package com.practicaDaw.Dawllapop.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class CategoryController {
	
	
	
	@RequestMapping("/category")
	public String index() {	
		return "category";
	}

}
