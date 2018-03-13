package com.practicaDaw.Dawllapop.ApiRestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Friend_request;
import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Entities.OfferEnum;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.OfferRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.services.AssessmentServices;
import com.practicaDaw.Dawllapop.services.FriendRequestServices;
import com.practicaDaw.Dawllapop.services.ProductServices;
import com.practicaDaw.Dawllapop.services.UserServices;

@RestController
@RequestMapping("/api/dashboard/{id}")
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
	@Autowired
	private FriendRequestServices fRequestService;
	@Autowired
	private OfferRepository offerRepository;
	
	
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
	
	
	//PRIVATE DASHBOARD
	
	@RequestMapping(value = "/withoffers", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductsWithOffers(@PathVariable long id){
		
		User user = userService.findUser(id);
		
		//list all products selling with offers
				List<Product> user_products_with_offers = pServices.getAllProductsByUserAndState(user.getId(), 0, false);
				return new ResponseEntity<>(user_products_with_offers, HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/buyed", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductsBuyedByUser(@PathVariable long id){
		
		User user = userService.findUser(id);
		
		//list products buyed
		List<Product> user_products_buyed = pServices.getAllProductsByUserBuyer(true, user.getId());
		return new ResponseEntity<>(user_products_buyed, HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/friendsRequests", method = RequestMethod.GET)
	public ResponseEntity<List<Friend_request>> getfriendsRequests(@PathVariable long id){
		
		User user = userService.findUser(id);
		
		//list friend requests
		List<Friend_request> fRequests = fRequestService.getUserRequests(user);
		return new ResponseEntity<>(fRequests, HttpStatus.OK);	
		
	}
	
	
	@RequestMapping(value = "/acceptoffer/{offer_id}", method = RequestMethod.PUT)
	@JsonView(Product.BasicInformation.class)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Offer> acceptOffer(@PathVariable long id, @PathVariable long offer_id){
		
		Offer of = offerRepository.getOne(offer_id);
		if ((offerRepository.findOne(offer_id)) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			Product p = of.getProduct();
			of.setState(1);
			offerRepository.saveAndFlush(of);
			p.setSold(true);
			pRepository.saveAndFlush(p);
			return new ResponseEntity<>(of, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/canceltoffer/{offer_id}", method = RequestMethod.PUT)
	@JsonView(Product.BasicInformation.class)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Offer> cancelOffer(@PathVariable long id, @PathVariable long offer_id){
		
		Offer of = offerRepository.getOne(offer_id);
		if ((offerRepository.findOne(offer_id)) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		} else {
			Product p = of.getProduct();
			of.setState(2);
			offerRepository.saveAndFlush(of);
			return new ResponseEntity<>(of, HttpStatus.OK);
		}
		
		
	}

	
	
	
}
