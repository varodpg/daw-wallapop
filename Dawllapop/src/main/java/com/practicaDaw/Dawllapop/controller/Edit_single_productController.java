package com.practicaDaw.Dawllapop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.services.ProductServices;

@Controller
public class Edit_single_productController {		
	
	
	/*
	@RequestMapping("/edit_product_view/{{id}}")
	public String edit_product_view(Model model, @PathVariable long id) {
		Product product = prs.findOne(id);
		model.addAttribute(product);
		
		return "edit_single_product";
	}*/

}
