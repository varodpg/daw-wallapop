package com.practicaDaw.Dawllapop.controller;


import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class Add_productController {
	
	@Autowired
    private ProductRepository repository;
	
	@RequestMapping("/add_product")
	public String addProduct() {	
		return "add_product";
	}

	@RequestMapping("/add_new_product")
	public String add_new_product(Model model, Product product){
		product.setState("on_sale");
		repository.save(product);
		return "add_product";
	}
}
