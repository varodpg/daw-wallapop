package com.practicaDaw.Dawllapop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Add_productController {
	
	@RequestMapping("/add_product")
	public String add_product() {
		return "add_product";
	}

	/*@RequestMapping("/add_new_product")
	public String add_product(Model model, Product product){
		System.out.println("Entrooo");
		return "";
	}*/

}
