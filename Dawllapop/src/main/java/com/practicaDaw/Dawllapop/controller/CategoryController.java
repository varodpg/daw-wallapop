package com.practicaDaw.Dawllapop.controller;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
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

		}


		@RequestMapping("/category")
		public String Categorias(Model model, @PageableDefault(size = 10) Pageable page) {
			
			//testing class of all products
			Category cat_1 = repository.getOne((long) 1);
			Category cat_2 = repository.getOne((long) 2);
			Category cat_3 = repository.getOne((long) 3);
			Category cat_4 = repository.getOne((long) 4);
			Category cat_5 = repository.getOne((long) 5);
			
			//queries for products list WITHOUT category (products and number of products)
			Page<Product> products = prs.getAllProducts(page);
			
			//queries to show the number of the rest of the products in other categories
			long num1 = prs.getNumberOfProductsByCat(cat_1);
			long num2 = prs.getNumberOfProductsByCat(cat_2);
			long num3 = prs.getNumberOfProductsByCat(cat_3);
			long num4 = prs.getNumberOfProductsByCat(cat_4);
			long num5 = prs.getNumberOfProductsByCat(cat_5);
			
			model.addAttribute("numberOfProducts", 0);
			model.addAttribute("num1", num1);
			model.addAttribute("num2", num2);
			model.addAttribute("num3", num3);
			model.addAttribute("num4", num4);
			model.addAttribute("num5", num5);
			
			model.addAttribute("products", products);
			
			model.addAttribute("morePages", prs.getAllProducts(page).isFirst());
			
			return "category";
		}
		
		@RequestMapping("/product")
		public @ResponseBody
		Product getProduct() {
			return new Product("MC", "es la lecheW", 300);
		}
		
		//interface CategoryListView extends Category.BasicAtt, Category.ProductAtt, Product.BasicAtt {}
		
		//@JsonView(Product.class)
		@RequestMapping(value="/categoryAjax")
		public @ResponseBody Page<Product> CategoriasAjax(Model model, @PageableDefault(size = 10) Pageable page) {

			System.out.println( "Los elementos son :" );
			System.out.println(prs.getAllProducts(page).toString());
			
			
			return prs.getAllProducts(page);

		
		}

		@RequestMapping("category/p{id}")
		public String Product(Model model, @PathVariable int id ) {
			
			Product p=prs.findOne(id);
			model.addAttribute("product",p);
			
			System.out.println(p);
			return "single";
		}
		
		@RequestMapping("/category/{cat_id}")
		public String Category(Model model, @PageableDefault(size = 10) Pageable page, @PathVariable long cat_id) {
			
			Category cat_selected = repository.getOne(cat_id);
			Category cat_1 = repository.getOne((long) 1);
			Category cat_2 = repository.getOne((long) 2);
			Category cat_3 = repository.getOne((long) 3);
			Category cat_4 = repository.getOne((long) 4);
			Category cat_5 = repository.getOne((long) 5);
			
			//queries for products list by category (products and number of products)
			Page<Product> products = prs.getAllbyCat(page, cat_selected);
			long numOfSelectedCat = prs.getNumberOfProductsByCat(cat_selected);
			
			//queries to show the number of the rest of the products in other categories
			long num1 = prs.getNumberOfProductsByCat(cat_1);
			long num2 = prs.getNumberOfProductsByCat(cat_2);
			long num3 = prs.getNumberOfProductsByCat(cat_3);
			long num4 = prs.getNumberOfProductsByCat(cat_4);
			long num5 = prs.getNumberOfProductsByCat(cat_5);
			
			model.addAttribute("products", products);
			model.addAttribute("numberOfProducts", numOfSelectedCat);
			model.addAttribute("num1", num1);
			model.addAttribute("num2", num2);
			model.addAttribute("num3", num3);
			model.addAttribute("num4", num4);
			model.addAttribute("num5", num5);
			model.addAttribute("cat_id", cat_id);
			
			model.addAttribute("morePages", prs.getAllbyCat(page, cat_selected).isFirst());

			
			return "category";
			
		}
		
		@RequestMapping("category/filter/{cat_id}")
		public String CategoryFiltering(Model model, @PageableDefault(size = 10) Pageable page, @PathVariable long cat_id, @RequestParam String price, @RequestParam String product_new) {
			
			Category cat_selected = repository.getOne(cat_id);
			Category cat_1 = repository.getOne((long) 1);
			Category cat_2 = repository.getOne((long) 2);
			Category cat_3 = repository.getOne((long) 3);
			Category cat_4 = repository.getOne((long) 4);
			Category cat_5 = repository.getOne((long) 5);
			String product_state = product_new;
			
			//queries for products list by category (products and number of products)
			Page<Product> products = prs.getAllbyCatAndFilter(product_state, cat_selected, page);
			//Page<Product> products = prs.getAllbyCatAndFilterExample(product_new, page);
			long numOfSelectedCat = prs.getNumberOfProductsByCat(cat_selected);
			
			
			//queries to show the number of the rest of the products in other categories
			long num1 = prs.getNumberOfProductsByCat(cat_1);
			long num2 = prs.getNumberOfProductsByCat(cat_2);
			long num3 = prs.getNumberOfProductsByCat(cat_3);
			long num4 = prs.getNumberOfProductsByCat(cat_4);
			long num5 = prs.getNumberOfProductsByCat(cat_5);
			
			model.addAttribute("products", products);
			model.addAttribute("numberOfProducts", numOfSelectedCat);
			model.addAttribute("num1", num1);
			model.addAttribute("num2", num2);
			model.addAttribute("num3", num3);
			model.addAttribute("num4", num4);
			model.addAttribute("num5", num5);
			
			model.addAttribute("morePages", prs.getAllbyCat(page, cat_selected).isFirst());
			
			model.addAttribute("price", price);
			model.addAttribute("product_new", product_new);
//			model.addAttribute("product_not_new", product_not_new);
			
			System.out.println(price);
			System.out.println(product_new);
//			System.out.println(product_not_new);
			return "category";
			
		}
				

}
