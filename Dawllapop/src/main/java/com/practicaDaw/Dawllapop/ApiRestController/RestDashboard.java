package com.practicaDaw.Dawllapop.ApiRestController;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Friend_request;
import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Entities.OfferEnum;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.AssessmentRepository;
import com.practicaDaw.Dawllapop.Repository.Friend_RequestRepository;
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
	private AssessmentRepository aRepository;
	@Autowired
	private FriendRequestServices fRequestService;
	@Autowired
	private OfferRepository offerRepository;
	@Autowired
	Friend_RequestRepository fRequestRepo;
	
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
	public ResponseEntity<Offer> acceptOffer(@PathVariable long id, @PathVariable long offer_id, HttpSession session){
		
		User userlog =(User) session.getAttribute("user");
		Offer of = offerRepository.getOne(offer_id);
		if ((offerRepository.findOne(offer_id)) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			
			if(userlog.getId()==of.getProduct().getUser().getId()) {
				Product p = of.getProduct();
				of.setState(1);
				offerRepository.saveAndFlush(of);
				p.setSold(true);
				pRepository.saveAndFlush(p);
				return new ResponseEntity<>(of, HttpStatus.OK);
			} else
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(value = "/canceltoffer/{offer_id}", method = RequestMethod.PUT)
	@JsonView(Product.BasicInformation.class)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Offer> cancelOffer(@PathVariable long id, @PathVariable long offer_id, HttpSession session){
		
		User userlog =(User) session.getAttribute("user");
		Offer of = offerRepository.getOne(offer_id);
		if ((offerRepository.findOne(offer_id)) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		} else {
			//if(userlog.getId()==of.getProduct().getUser().getId()) {
				Product p = of.getProduct();
				of.setState(2);
				offerRepository.saveAndFlush(of);
				return new ResponseEntity<>(of, HttpStatus.OK);
			//}  else
			//	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}				
	}

	@RequestMapping(value = "/declineFriendRequest/{friend_id}", method = RequestMethod.PUT)
	@JsonView(Product.BasicInformation.class)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Friend_request> declineFriend(@PathVariable long id, @PathVariable long friend_id, HttpSession session){
		
		User userlog =(User) session.getAttribute("user");
		Friend_request fr = fRequestRepo.getOne(friend_id);
		if (fRequestRepo.getOne(friend_id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		} else {
			if(userlog.getId() == fr.getTo().getId()) {
				fr.setState("declined");
				fRequestRepo.saveAndFlush(fr);
				return new ResponseEntity<>(fr, HttpStatus.OK);
			} else
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}		
	}
	
	@RequestMapping(value = "/acceptFriendRequest/{friend_id}", method = RequestMethod.PUT)
	@JsonView(Product.BasicInformation.class)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Friend_request> acceptFriend(@PathVariable long id, @PathVariable long friend_id, HttpSession session){
		
		User userlog =(User) session.getAttribute("user");
		Friend_request fr = fRequestRepo.getOne(friend_id);
		if (fRequestRepo.getOne(friend_id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		} else {
			if(userlog.getId() == fr.getTo().getId()) {
				fr.setState("accepted");
				fRequestRepo.saveAndFlush(fr);
				return new ResponseEntity<>(fr, HttpStatus.OK);
			} else
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}		
	}
	
	@RequestMapping(value = "/getFriends/", method = RequestMethod.GET)
	@JsonView(Product.BasicInformation.class)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<User>> getFriends(@PathVariable long id){
		User user = userService.findUser(id);
		List<User> friends = fRequestService.getUserFriends(user);
		return new ResponseEntity<>(friends, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addAssessment/{id_to}", method = RequestMethod.POST)
	@JsonView(Product.BasicInformation.class)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Assessment> addAssessment(@PathVariable long id, @PathVariable long id_to,@RequestBody Assessment ass, HttpSession session){
		User user_from = uRepository.findById(id);
		User user_to = uRepository.findById(id_to);
		aRepository.save(assessment);
		return new ResponseEntity<>(assessment, HttpStatus.OK);
	}
	
}
