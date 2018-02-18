package com.practicaDaw.Dawllapop.controller;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.CategoryRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.services.ProductServices;



@Controller
public class CategoryController {

		@Autowired
		private CategoryRepository repository;
		@Autowired
		private ProductRepository repository2;

		@Autowired
		private ProductServices prs;
		
		
		@PostConstruct
		public void init() {
			Category c= new Category("Informatica");
			repository.save(c);
		}


		@RequestMapping("/category")
		public String Categorias(Model model, Pageable page) {
			
			Page<Product> products = prs.getAllProducts(page);

			model.addAttribute("products", products);
			
			model.addAttribute("nextPage", products.getNumber()+1);
			model.addAttribute("prevPage", products.getNumber()-1);
			
			return "category";
		}
		
		@RequestMapping("/producto")
		public @ResponseBody
		Product getProduct() {
			return new Product("MC", "es la lecheW", 300);
		}
		

		
		@RequestMapping(value="/categoryAjax", produces = "application/json; charset=UTF-8")
		public @ResponseBody Page<Product> CategoriasAjax(Model model, Pageable page) {

			System.out.println( "Los elementos son :" );
			System.out.println(prs.getAllProducts(page).toString());
			return prs.getAllProducts(page);

		
		}

		

}
