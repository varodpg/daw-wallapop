package com.practicaDaw.Dawllapop.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.AssessmentRepository;
import com.practicaDaw.Dawllapop.Repository.OfferRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.services.AssessmentServices;
import com.practicaDaw.Dawllapop.services.ProductServices;
import com.practicaDaw.Dawllapop.services.UserServices;
import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Entities.OfferEnum;
import com.practicaDaw.Dawllapop.Entities.Product;

@Controller
public class DashboardPublicController {
	
	@Autowired
	UserServices userService;
	@Autowired
	private ProductServices prs;
	@Autowired
	private AssessmentServices assessmentService;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	ProductServices productServices;
	
	@Autowired
	private OfferRepository offerRepository;
	
	@PostConstruct
	public void init() {
	
		
	}
	
	
	@RequestMapping("/publicDashboard/{id}")
	public String dashBoardPublic(Model model, @PathVariable long id, HttpSession session, Authentication http) {	
		User user = userService.findUser(id);
		if (http != null) {
			model.addAttribute("userlog", userRepository.findByName(http.getName()));
		
		}
		
		List<Assessment> assessments = assessmentService.getUserAssessmentsNoPageable(user);
		User userLogged = (User) session.getAttribute("user");
		
		
		//list all products on sold
				List<Product> user_products_selling = prs.getAllProductsByUserAndStateNoOffers(user.getId(), false);
				model.addAttribute("products_selling", user_products_selling);
				
		//list all products sold
				List<Product> user_products_sold = prs.getAllProductsByUserAndState(user.getId(), 1, true);
				model.addAttribute("products_sold", user_products_sold);
				
		model.addAttribute("assessments", assessments);
		model.addAttribute("user", user);		
		model.addAttribute("userLogged", userLogged);
		
		return "dashboard-public";
	}

}
