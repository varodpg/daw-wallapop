package com.practicaDaw.Dawllapop.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.h2.mvstore.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.UserRepository;



@Controller

public class AdminController {
	@Autowired UserRepository userRepository;
	
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
	public String editDatesProfileBBDD(Model model) {
		List<User> usuarios = userRepository.findAll();
		model.addAttribute("usuario", usuarios);
//		for (int i = 0; i < usuarios.size(); i++) {
//			User user = usuarios.get(i);
//			user.setName(nombre);
//			user.setEmail(email);
//			user.setPasswordHash(passwordHash);
//			user.setLocation(location);
//			user.setRoles(roles);	
//			System.out.println("Dentro del bucle");
//			userRepository.saveAndFlush(user);
//		}
		return "admin/edit";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin/index";
	}
	
	
}
