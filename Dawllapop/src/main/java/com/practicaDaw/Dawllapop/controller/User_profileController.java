package com.practicaDaw.Dawllapop.controller;

import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Controller
@RequestMapping("/user-profile")
public class User_profileController {
	
	

	@Autowired
	private ProductRepository repository;

	@PostConstruct
	public void init() {

	}


}
