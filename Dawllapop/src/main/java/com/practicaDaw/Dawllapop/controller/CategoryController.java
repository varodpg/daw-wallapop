package com.practicaDaw.Dawllapop.controller;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
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
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.services.ProductServices;




@Controller
public class CategoryController {

		@Autowired
		private CategoryRepository repository;
		@Autowired
		private ProductRepository repository2;

		@Autowired
		private ProductServices prs;
		
		@Autowired
		private UserRepository userRepository;
		
		
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
		

		@RequestMapping(value="/categoryAjax/{cat}/{pi}/{pt}/{pn}/{pnn}")
		public @ResponseBody Page<Product> CategoriasAjax(Model model, @PageableDefault(size = 10) Pageable page, @PathVariable long cat, @PathVariable String pi, @PathVariable String pt, @PathVariable String pn, @PathVariable String pnn) {

			System.out.println( "Los elementos son :" );
			System.out.println(prs.getAllProducts(page).toString());
			System.out.println(cat);
			System.out.println(pi);
			System.out.println(pt);
			System.out.println(pn);
			System.out.println(pnn);
			
			Category cat_selected = repository.getOne(cat);
			
			if((pi.equalsIgnoreCase("null"))&&(pt.equalsIgnoreCase("null"))) {
				//control of showMore or not showMore elements
				model.addAttribute("morePages", prs.getAllbyCat(page, cat_selected).getTotalPages()>1);
				return prs.getAllbyCat(page, cat_selected);
			}
				else {
					
			if((pn.equalsIgnoreCase("null"))&&(pnn.equalsIgnoreCase("null"))){
						//control of showMore or not showMore elements
						model.addAttribute("morePages", prs.getAllbyCat(page, cat_selected).getTotalPages()>1);
						return prs.getAllbyCatAndFilter2(pi, pt, "new", "not_new", cat_selected, page);
			}
			else if((pn.equalsIgnoreCase("null"))&&(pnn.equalsIgnoreCase("not_new"))) {
				//control of showMore or not showMore elements
				model.addAttribute("morePages", prs.getAllbyCat(page, cat_selected).getTotalPages()>1);
			    return prs.getAllbyCatAndFilter(pi, pt, "not_new", cat_selected, page);
			}
			else if((pnn.equalsIgnoreCase("null"))&&(pn.equalsIgnoreCase("new"))) {
				//control of showMore or not showMore elements
				model.addAttribute("morePages", prs.getAllbyCat(page, cat_selected).getTotalPages()>1);
				return prs.getAllbyCatAndFilter(pi, pt, "new", cat_selected, page);
			}
			else if((pn.equalsIgnoreCase("new"))&&(pnn.equalsIgnoreCase("not_new"))) {
				//control of showMore or not showMore elements
				model.addAttribute("morePages", prs.getAllbyCat(page, cat_selected).getTotalPages()>1);
				return prs.getAllbyCatAndFilter2(pi, pt, "new", "not_new", cat_selected, page);
				}
			}
			return null;
			
			
//			Category cat_selected = repository.getOne(cat);
//			return prs.getAllbyCatAndFilter2(pi, pt, "new", "not_new", cat_selected, page);

			
		}

		@RequestMapping("category/p{id}")
		public String Product(Model model, @PathVariable int id, Authentication http ) {
			
			Product p=prs.findOne(id);
			model.addAttribute("product",p);
			
			if (http != null) {
				model.addAttribute("usuario", userRepository.findByName(http.getName()));
			}
			
			System.out.println(p);
			return "single";
		}
		
		@RequestMapping("/category/{cat_id}")
		public String Category(Model model, @PageableDefault(size = 10) Pageable page, @PathVariable long cat_id, Authentication http) {
			
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
			
			//control of showMore or not showMore elements
			model.addAttribute("morePages", prs.getAllbyCat(page, cat_selected).getTotalPages()>1);
			
			model.addAttribute("inf", "null");
			model.addAttribute("top", "null");
			model.addAttribute("product_new", "null");
			model.addAttribute("product_not_new", "null");
			
			if (http != null) {
				model.addAttribute("usuario", userRepository.findByName(http.getName()));
			}
			
			return "category";
			
		}
		
		//Controller to filter products by new, not new, and price
		@RequestMapping("category/filter/{cat_id}")
		public String CategoryFiltering(Model model, @PageableDefault(size = 10) Pageable page, @PathVariable long cat_id, String price, @RequestParam(required = false) String product_new,  @RequestParam(required = false) String product_not_new) {
			
			Category cat_selected = repository.getOne(cat_id);
			Category cat_1 = repository.getOne((long) 1);
			Category cat_2 = repository.getOne((long) 2);
			Category cat_3 = repository.getOne((long) 3);
			Category cat_4 = repository.getOne((long) 4);
			Category cat_5 = repository.getOne((long) 5);
			
			//String price from [int,int] to-> inf,top
			
			String[] parts = price.split(",");
			String inf = parts[0]; 
			String top = parts[1]; 
			System.out.println("Precio inferior: " + inf);
			System.out.println("Precio superior: " + top);
			
			//queries for products list by category and product state
			
			if(((product_new==null)&&(product_not_new==null))){
				Page<Product> products = prs.getAllbyCatAndFilter2(inf, top, "new", "not_new", cat_selected, page);
				model.addAttribute("products", products);
				//control of showMore or not showMore elements
				model.addAttribute("morePages", prs.getAllbyCat(page, cat_selected).getTotalPages()>1);
				
			}else {
			if((product_new==null)&&(product_not_new.equalsIgnoreCase("not_new"))) {
			Page<Product> products = prs.getAllbyCatAndFilter(inf, top, "not_new", cat_selected, page);
			model.addAttribute("products", products);
			//control of showMore or not showMore elements
			model.addAttribute("morePages", prs.getAllbyCat(page, cat_selected).getTotalPages()>1);
			}
			else if((product_not_new==null)&&(product_new.equalsIgnoreCase("new"))) {
				Page<Product> products = prs.getAllbyCatAndFilter(inf, top, "new", cat_selected, page);
				model.addAttribute("products", products);
				//control of showMore or not showMore elements
				model.addAttribute("morePages", prs.getAllbyCat(page, cat_selected).getTotalPages()>1);
			}
			else if((product_new.equalsIgnoreCase("new"))&&(product_not_new.equalsIgnoreCase("not_new"))) {
				Page<Product> products = prs.getAllbyCatAndFilter2(inf, top, "new", "not_new", cat_selected, page);
				model.addAttribute("products", products);
				//control of showMore or not showMore elements
				model.addAttribute("morePages", prs.getAllbyCat(page, cat_selected).getTotalPages()>1);
			}
			}

			//queries for products list by category (products and number of products)
			long numOfSelectedCat = prs.getNumberOfProductsByCat(cat_selected);
			
			
			//queries to show the number of the rest of the products in other categories
			long num1 = prs.getNumberOfProductsByCat(cat_1);
			long num2 = prs.getNumberOfProductsByCat(cat_2);
			long num3 = prs.getNumberOfProductsByCat(cat_3);
			long num4 = prs.getNumberOfProductsByCat(cat_4);
			long num5 = prs.getNumberOfProductsByCat(cat_5);
			
			
			model.addAttribute("numberOfProducts", numOfSelectedCat);
			model.addAttribute("num1", num1);
			model.addAttribute("num2", num2);
			model.addAttribute("num3", num3);
			model.addAttribute("num4", num4);
			model.addAttribute("num5", num5);
			
			
			model.addAttribute("inf", inf);
			model.addAttribute("top", top);
			if(product_new!=null) {
				model.addAttribute("product_new", product_new);
			}
			if(product_not_new!=null) {
				model.addAttribute("product_not_new", product_not_new);
			}
			if(product_new==null) {
				String product_new1="null";
				model.addAttribute("product_new", product_new1);
			}
			if(product_not_new==null) {
				String product_not_new1="null";
				model.addAttribute("product_not_new", product_not_new1);
			}
			

			
			return "category";
			
		}
				

}
