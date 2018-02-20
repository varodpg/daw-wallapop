package com.practicaDaw.Dawllapop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.services.ProductServices;

@Controller
public class DashboardController {
	
	@Autowired
	private ProductRepository repository;

	@Autowired
	private ProductServices prs;
	
	@RequestMapping("/dashboard")
	public String dashBoard(Model model, @PageableDefault(size = 10) Pageable page) {
		Page<Product> products = prs.getAllProducts(page);

		model.addAttribute("products", products);
		
		model.addAttribute("morePages", prs.getAllProducts(page).isFirst());
		
		return "dashboard";
	}	

}
