package com.practicaDaw.Dawllapop.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.OfferRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.services.OfferServices;
import com.practicaDaw.Dawllapop.services.ProductServices;



@Controller

public class AdminController {
	@Autowired UserRepository userRepository;
	@Autowired ProductRepository productRepository;
	@Autowired ProductServices prs;
	@Autowired OfferRepository offerRepository;
	@Autowired OfferServices oss;
	
	@RequestMapping("/admin/index")
	public String admin_index () {
		return "admin/index";
	}
	
	@RequestMapping("/admin/charts")
	public String charts() {
		return "admin/charts";
	}
	
	@RequestMapping("/admin/tables") 
	public String tables(Model model) {
		List<User> usuarios = userRepository.findAll();
		model.addAttribute("usuario", usuarios);
		System.out.println(model);
		return "admin/tables";
	}
	
	@RequestMapping("/admin/edit")
	public String editDatesProfileBBDD(Model model
			//@RequestParam ("name")String name
			//@RequestParam String email, @RequestParam String passwordHash, @RequestParam String location, @RequestParam String roles
			) {
		List<User> usuarios = userRepository.findAll();
		model.addAttribute("usuario", usuarios);
		return "admin/edit";
	}
	
	@RequestMapping("/admin/edit/{id}")
	public String editSingleUser (Model model, @PathVariable long id) {
		User u = userRepository.findById(id);
		model.addAttribute("usuarios",u);
		
		return "admin/edit";
	}
	
	@RequestMapping("/admin/deleteuser/{id}")
	public String deleteUser(Model model, @PathVariable long id) {
		User u = userRepository.findById(id);
//		List<Product> products = prs.getAllProductsByUser(id);
//		productRepository.delete(products);
//		List<Offer> offers = oss.getAllOfferByUser(id);
//		offerRepository.delete(offers);
		userRepository.delete(u);
		return "redirect:/admin/tables";
	}
	
	@RequestMapping("/admin/editandsave/{id}")
	public String editAndSave (Model model, User user, @PathVariable long id, @RequestParam String passwordHash) {
		
		user.setId(id);
		//User u = userRepository.findById(id);
		user.setPasswordHash(passwordHash);
		userRepository.saveAndFlush(user);
		
		return "redirect:/admin/tables";
	}
	
	@RequestMapping("/admin/adminProducts")
	public String editProducts(Model model) {
		List<Product> products = prs.getAllProducts();
		model.addAttribute("products",products);
		List<User> u = userRepository.findAll();
		model.addAttribute("usuarios",u);
		
		model.addAttribute("user_search_name", "todos");
		return "admin/adminProducts";
	}
	
	@RequestMapping("/admin/adminProductsByUser")
	public String editProductsByUser(Model model, @RequestParam Long id_user_search) {
		
		List<User> u = userRepository.findAll();
		model.addAttribute("usuarios",u);
		List<Product> products = prs.getAllProductsByUser(id_user_search);
		
		User user_search = userRepository.findById(id_user_search);
		String user_search_name = user_search.getName();
		model.addAttribute("user_search_name", user_search_name);
		
		model.addAttribute("products",products);
		return "admin/adminProducts";
	}

	@RequestMapping("/admin/editProduct/{id}")
	public String editSingleProduct (Model model, @PathVariable long id) {
		Product p = prs.findOne(id);
		model.addAttribute("product", p);

		
		return "admin/editProduct";
		
	}
		
	@RequestMapping("/admin/editandsaveproduct/{id}")
	public String editAndSaveProduct(Model model, Product product, @PathVariable long id) {
		Product p = prs.findOne(id);
		product.setUser(p.getUser());
		product.setCategory(p.getCategory());
		product.setId(id);
		product.setDate(p.getDate());
		product.setEspecifications(p.getEspecifications());
		product.setImages(p.getImages());
		productRepository.saveAndFlush(product);
		
		return "redirect:/admin/adminProducts";
	}
	
	@RequestMapping("/admin/deleteproduct/{id}")
	public String deleteProduct(Model model, @PathVariable long id) {
		Product p = prs.findOne(id);
		productRepository.delete(p);
		return "redirect:/admin/adminProducts";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin/index";
	}
	
	
}
