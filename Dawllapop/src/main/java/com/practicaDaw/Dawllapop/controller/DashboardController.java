package com.practicaDaw.Dawllapop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.services.ProductServices;

@Controller
public class DashboardController {
	
	@Autowired
	private ProductRepository repository;

	@Autowired
	private ProductServices prs;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/dashboard")
	public String dashBoard(Model model, @PageableDefault(size = 10) Pageable page, Authentication http) {
		if(http != null) {
			model.addAttribute("usuario",userRepository.findByName(http.getName()));
			System.out.println(model.toString());
		}
		Page<Product> products = prs.getAllProducts(page);

		model.addAttribute("products", products);
		
		model.addAttribute("morePages", prs.getAllProducts(page).isFirst());
		
		return "dashboard";
	}	

}
