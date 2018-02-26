package com.practicaDaw.Dawllapop.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.AssessmentRepository;
import com.practicaDaw.Dawllapop.Repository.OfferRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.services.AssessmentServices;
import com.practicaDaw.Dawllapop.services.ProductServices;
import com.practicaDaw.Dawllapop.services.UserServices;
import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Entities.OfferEnum;
import com.practicaDaw.Dawllapop.Entities.Product;

@Controller
public class Dashboard_publicController {
	
	@Autowired
	UserServices userService;
	@Autowired
	private ProductServices prs;
	@Autowired
	private AssessmentServices assessmentService;

	@Autowired
	ProductServices productServices;
	
	@Autowired
	private OfferRepository offerRepository;
	
	@PostConstruct
	public void init() {
	
		
	}
	
	
	@RequestMapping("/publicDashboard/{id}")
	public String dashBoardPublic(Model model, @PathVariable long id, @PageableDefault(size = 10) Pageable page) {	
		User user = userService.findUser(id);
		Page<Product> products = prs.getAllByUser(page, user);
		Page<Assessment> assessments = assessmentService.getUserAssessments(user, page);
		
		model.addAttribute("assessments", assessments);
		model.addAttribute("user", user);		
		model.addAttribute("products", products);
		
		return "dashboard-public";
	}

}
