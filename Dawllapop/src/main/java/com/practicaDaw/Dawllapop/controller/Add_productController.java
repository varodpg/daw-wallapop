package com.practicaDaw.Dawllapop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Add_productController {
	
	

	
	@RequestMapping("/add_product")
	public String addProduct() {	
		return "add_product";
	}

}
