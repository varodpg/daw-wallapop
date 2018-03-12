package com.practicaDaw.Dawllapop.ApiRestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.services.AssessmentServices;
import com.practicaDaw.Dawllapop.services.ProductServices;
import com.practicaDaw.Dawllapop.services.UserServices;

@RestController
@RequestMapping("/api/dashboardPublic/{id}")
public class RestDashboard {
	@Autowired
	private ProductRepository pRepository;
	@Autowired
	private ProductServices pServices;
	@Autowired
	private UserRepository uRepository;
	@Autowired
	UserServices userService;
	@Autowired
	private AssessmentServices aServices;
	
	@RequestMapping(value = "/selling", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductsSelling(@PathVariable long id){
		
		User user = userService.findUser(id);
		
		//list all products selling
				List<Product> user_products_selling = pServices.getAllProductsByUserAndStateNoOffers(user.getId(), false);
				return new ResponseEntity<>(user_products_selling, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/sold", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductsSold(@PathVariable long id){
		
		User user = userService.findUser(id);
		
		//list all products sold
				List<Product> user_products_sold = pServices.getAllProductsByUserAndState(user.getId(), 1, true);
				return new ResponseEntity<>(user_products_sold, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/assessment", method = RequestMethod.GET)
	public ResponseEntity<List<Assessment>> getAssessments(@PathVariable long id){
		
		User user = userService.findUser(id);
		
		//list all assessment of an user
				List<Assessment> assessments = aServices.getUserAssessmentsNoPageable(user);
				return new ResponseEntity<>(assessments, HttpStatus.OK);		
	}
}
