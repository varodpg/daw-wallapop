package com.practicaDaw.Dawllapop.controller;


import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.CategoryRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.services.ProductServices;

import antlr.collections.List;
import javassist.compiler.ast.ArrayInit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

@Controller
public class CategoryController {

		@Autowired
		private CategoryRepository repository;
		@Autowired
		private ProductRepository repository2;

		@Autowired
		private ProductServices prs;
		
		//private Map<Integer,Product> productos = new ConcurrentHashMap<Integer, Product>();
		
		@PostConstruct
		public void init() {
			Category c= new Category("Informatica");
			//repository.save(c);
		}


		@RequestMapping("/category")
		public String Categorias(Model model, Pageable page) {
			
			Page<Product> products = prs.getAllProducts(page);

			model.addAttribute("products", products);
			
			model.addAttribute("nextPage", products.getNumber()+1);
			model.addAttribute("prevPage", products.getNumber()-1);
			
			return "category";
		}
		
		
		@RequestMapping(value="/categoryAjax", produces = "application/json; charset=UTF-8")
		public @ResponseBody Page<Product> CategoriasAjax(Model model, Pageable page) {

			System.out.println( "Los elementos son :" );
			System.out.println(prs.getAllProducts(page).toString());
			return prs.getAllProducts(page);

		
		}

		

}
