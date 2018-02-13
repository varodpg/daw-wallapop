package com.practicaDaw.Dawllapop.controller;

import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Repository.CategoryRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
@Controller
@RequestMapping("/category")


public class CategoryController {

		@Autowired
		private CategoryRepository repository;

		@PostConstruct
		public void init() {

			Category c= new Category("Informatica");
			repository.save(c);

		}





}
