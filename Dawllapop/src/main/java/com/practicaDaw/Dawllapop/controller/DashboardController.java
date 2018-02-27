package com.practicaDaw.Dawllapop.controller;

import java.io.File;
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

		// Assessment a = new Assessment("juanma", "juanma@hotmail.com", "increible
		// vendedor super amable", 5);
		// assessmentRepository.save(a);
		// Assessment a2 = new Assessment("David", "alvaro@hotmail.com", "envio un poco
		// lento", 4);
		// assessmentRepository.save(a2);

	}

	@RequestMapping("/add_new_assessment")
	public String add_new_user(Model model, Assessment assessment, HttpSession session) {
		System.out.println(session.getAttribute("user").toString());
		// assessment.setName(session.getAttribute("user").toString());
		// assessment.setEmail("juanma@hotmail.com");
		assessmentRepository.save(assessment);
		return "dashboard";
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

		Page<Product> products = prs.getAllProducts(page);

		model.addAttribute("products", products);

		model.addAttribute("morePages", prs.getAllProducts(page).isFirst());

		List<Assessment> assessments = ass.getAllAssessment();
		List<Offer> offers = oss.getOfferRequests(user);
		List<Friend_request> fRequests = fRequestService.getUserRequests(user);

		model.addAttribute("assessments", assessments);
		model.addAttribute("offers", offers);
		model.addAttribute("friendRequests", fRequests);

		return "dashboard";
	}

	@RequestMapping(value = "/add-new-offer/{seller_id}/{product_id}", method = RequestMethod.POST)
	public String add_new_offer(Model model, @RequestParam("price") int price, @RequestParam("message") String message,
			HttpSession session, @PathVariable("seller_id") long seller_id,
			@PathVariable("product_id") long product_id) {
		User user = (User) session.getAttribute("user");
		User user_seller = userRepository.findOne(seller_id);
		Product pr = repository.findOne(product_id);
		Offer of = new Offer(price, message, OfferEnum.Pending, user, user_seller, pr);
		offerRepository.save(of);
		return "redirect:/dashboard";
	}

	@RequestMapping("/pendingOfferAcept/{id}")
	public String pendingOfferAcept(Model model, @PathVariable("id") long id) {
		Offer of = offerRepository.getOne(id);
		of.setOfferEnum(OfferEnum.Acepted);
		Product p = of.getProduct();
		p.setSold(true);
		offerRepository.saveAndFlush(of);
		return "redirect:/dashboard";
	}

	@RequestMapping("/pendingOfferCancel/{id}")
	public String pendingOfferCancel(Model model, @PathVariable("id") long id) {
		Offer of = offerRepository.getOne(id);
		of.setOfferEnum(OfferEnum.Cancel);
		Product p = of.getProduct();
		p.setSold(false);
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

}
