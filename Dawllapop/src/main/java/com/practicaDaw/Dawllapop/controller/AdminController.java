package com.practicaDaw.Dawllapop.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.h2.mvstore.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin/index";
	}
	
	
}
