package com.practicaDaw.Dawllapop.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Friend_request;
import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Entities.OfferEnum;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.ImageManager.Image;
import com.practicaDaw.Dawllapop.Repository.AssessmentRepository;
import com.practicaDaw.Dawllapop.Repository.Friend_RequestRepository;
import com.practicaDaw.Dawllapop.Repository.OfferRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.services.AssessmentServices;
import com.practicaDaw.Dawllapop.services.FriendRequestServices;
import com.practicaDaw.Dawllapop.services.OfferServices;
import com.practicaDaw.Dawllapop.services.ProductServices;
import com.practicaDaw.Dawllapop.services.UserServices;

@Controller
public class DashboardController {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private ProductServices prs;
	@Autowired
	private AssessmentServices ass;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AssessmentRepository assessmentRepository;
	@Autowired
	private OfferRepository offerRepository;

	@Autowired
	private OfferServices oss;
	@Autowired
	ProductServices productServices;
	@Autowired
	UserServices userService;
	@Autowired
	Friend_RequestRepository fRequestRepo;
	@Autowired
	FriendRequestServices fRequestService;

	@PostConstruct
	public void init() {

	}

	@RequestMapping("/dashboard")
	public String dashBoard(Model model, @PageableDefault(size = 10) Pageable page, Authentication http,
			HttpSession session) {
		if (http != null) {
			model.addAttribute("usuario", userRepository.findByName(http.getName()));
			// model.addAttribute("usuario",
			// userRepository.findByName(http.getName()).getRegisterDate());

		}

		User user = (User) session.getAttribute("user");
		Long user_id = user.getId();
		System.out.println(user_id);
		
		//list all products by user (including within or not offers)
		List<Product> user_products = prs.getAllProductsByUserAndStateNoOffers(user.getId(), false);
		model.addAttribute("products_all", user_products);
		
		//list all product with offers (product must be sold FALSE)
		List<Product> user_products_with_offers = prs.getAllProductsByUserAndState(user.getId(), 0, false);
		model.addAttribute("products_offers", user_products_with_offers);
		//System.out.println(user_products_with_offers);
		
		//list all products sold
		List<Product> user_products_sold = prs.getAllProductsByUserAndState(user.getId(), 1, true);
		model.addAttribute("products_sold", user_products_sold);

		//list products buyed
		List<Product> user_products_buy = prs.getAllProductsByUserBuyer(true, user.getId());
		model.addAttribute("products_buyed", user_products_buy);
		
		//Page<Assessment> assessments = ass.getUserAssessments(user, page);
		List<Assessment> assessments = ass.getUserAssessmentsNoPageable(user);
		List<Friend_request> fRequests = fRequestService.getUserRequests(user);

		model.addAttribute("assessments", assessments);
		model.addAttribute("friendRequests", fRequests);

		return "dashboard";
	}

	@RequestMapping(value = "/add-new-offer/{product_id}", method = RequestMethod.POST)
	public String add_new_offer(Model model, @RequestParam("price") int price, @RequestParam("message") String message,
			HttpSession session,
			@PathVariable("product_id") long product_id) {
		
		//user buying is user logged
		User user = (User) session.getAttribute("user");
		
		OfferEnum offerEnum = null;
		Offer offer = new Offer(price, message, 0, user);
		
		Product product_buying = prs.findOne(product_id);
		offer.setProduct(product_buying);

		offerRepository.save(offer);

		return "redirect:/dashboard";
	}

	@RequestMapping("/pendingOfferAcept/{id}")
	public String pendingOfferAcept(Model model, @PathVariable("id") long id) {
		Offer of = offerRepository.getOne(id);
		//of.setOfferEnum(OfferEnum.Acepted);
		Product p = of.getProduct();
		of.setState(1);
		offerRepository.saveAndFlush(of);
		p.setSold(true);
		repository.saveAndFlush(p);
		
		return "redirect:/dashboard";
	}

	@RequestMapping("/pendingOfferCancel/{id}")
	public String pendingOfferCancel(Model model, @PathVariable("id") long id) {
		Offer of = offerRepository.getOne(id);
		//of.setOfferEnum(OfferEnum.Cancel);
		Product p = of.getProduct();
		of.setState(2);
		offerRepository.saveAndFlush(of);
		return "redirect:/dashboard";
	}

	@RequestMapping("/declineFriendRequest/{id}")
	public String declineFriendRequest(Model model, @PathVariable("id") long id) {
		Friend_request fr = fRequestRepo.getOne(id);
		fr.setState("declined");
		fRequestRepo.saveAndFlush(fr);
		return "redirect:/dashboard";
	}

	@RequestMapping("/acceptFriendRequest/{id}")
	public String acceptFriendRequest(Model model, @PathVariable("id") long id) {
		Friend_request fr = fRequestRepo.getOne(id);
		fr.setState("accepted");
		fRequestRepo.saveAndFlush(fr);
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "getUserFriends", method = RequestMethod.POST)
	public @ResponseBody List<User> getUserFriends(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<User> friends = fRequestService.getUserFriends(user);
		return friends;
	}
	
	@RequestMapping(value = "/addAssessment/{id}", method = RequestMethod.POST)
	public String addAssessment(Model model, @PathVariable("id") long id, @RequestParam("message") String message, 
			@RequestParam("value") int value,HttpSession session) {
		User user = (User) session.getAttribute("user");
		User userTo = userRepository.getOne(id);
		Assessment assessment = new Assessment(message, 2, user, userTo, new Date());
		assessmentRepository.save(assessment);
		return "redirect:/dashboard";
	}
}
