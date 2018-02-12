package com.practicaDaw.Dawllapop.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class Edit_single_productController {
	
	
	
	@RequestMapping("/edit_single_product")
	public String index() {	
		return "edit_single_product";
	}

}
