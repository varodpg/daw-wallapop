package com.practicaDaw.Dawllapop.controller;


import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.services.ProductServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class Add_productController {
	@Autowired
	private ProductServices prs;
	
	@Autowired
    private ProductRepository repository;
	
	@RequestMapping("/add_product")
	public String addProduct() {	
		return "add_product";
	}

	@RequestMapping("/add-new-product")
	public String add_new_product(Model model, Product product){
		product.setState("on_sale");
		repository.save(product);		
		return "add_product";
	}
	
	@RequestMapping("/edit_single_product/{id}")
	public String editSingleProduct(Model model, @PathVariable long id) {	
		Product product = prs.findOne(id);
		model.addAttribute(product);		
		return "edit_single_product";
	}
	
	@RequestMapping("/edit_product_db/{id}")
	public String editProductDb(Model model, Product product, @PathVariable long id) {
		product.setId(id);	
		repository.saveAndFlush(product);		
		return "/";
	}
	
	@RequestMapping("/deleteProduct/{id}")
	public String deleteProduct(Model model, @PathVariable long id) {
		Product product = prs.findOne(id);
		repository.delete(product);
		return "/";
	}
	
}
