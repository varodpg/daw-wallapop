package com.practicaDaw.Dawllapop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.AssessmentRepository;
import com.practicaDaw.Dawllapop.Repository.CategoryRepository;
import com.practicaDaw.Dawllapop.Repository.Friend_RequestRepository;
import com.practicaDaw.Dawllapop.Repository.OfferRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.services.OfferServices;
import com.practicaDaw.Dawllapop.services.ProductServices;
import com.practicaDaw.Dawllapop.services.UserServices;

@RestController
public class ApiRestController {
	@Autowired
	private ProductRepository p_repository;
	@Autowired
	private CategoryRepository c_repository;
	@Autowired
	private ProductServices prs;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserServices userServices;
	@Autowired
	UserServices userService;
	@Autowired
	private OfferServices oss;
	@Autowired
	private OfferRepository offerRepository;
	@Autowired
	private AssessmentRepository assessmentRepo;
	@Autowired
	private Friend_RequestRepository fRequestRepo;

	@RequestMapping(value = "/api/category/{id}", method = RequestMethod.GET)
	@JsonView(Product.BasicInformation.class)
	public Page<Product> getProductsByCategory(Pageable page, Category category) {
		return p_repository.findByCategory(page, category);
	}

	@RequestMapping(value = "/api/deleteProduct/{id}", method = RequestMethod.DELETE)
	public boolean deletedProduct(@PathVariable long id) {
		Product p = p_repository.findOne(id);
		p_repository.delete(p);
		return true;
	}
}
