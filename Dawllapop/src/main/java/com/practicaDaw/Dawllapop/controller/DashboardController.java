package com.practicaDaw.Dawllapop.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Entities.OfferEnum;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.AssessmentRepository;
import com.practicaDaw.Dawllapop.Repository.OfferRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.services.AssessmentServices;
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
	public String dashBoard(Model model, @PageableDefault(size = 10) Pageable page, Authentication http) {
		if (http != null) {
			model.addAttribute("usuario", userRepository.findByName(http.getName()));
			System.out.println(model.toString());
		}
		User user1 = userService.findUser(1);
		User user2 = userService.findUser(2);
		Product p = productServices.findOne(1);
		
		

		OfferEnum offerEnum = null;
		Offer o = new Offer(60, "Quiero este precio", offerEnum.Acepted, user1, user2, p);
		offerRepository.save(o);
		Offer o2 = new Offer(700, "Te ofrezco", offerEnum.Cancel, user1, user2, p);
		offerRepository.save(o2);
		Offer o3 = new Offer(650, "toma esto, no subo mas", offerEnum.Pending, user1, user2, p);
		offerRepository.save(o3);
		Page<Product> products = prs.getAllProducts(page);

		model.addAttribute("products", products);

		model.addAttribute("morePages", prs.getAllProducts(page).isFirst());

		List<Assessment> assessments = ass.getAllAssessment();
		List<Offer> offers = oss.getAllOffer();

		model.addAttribute("assessments", assessments);
		model.addAttribute("offers", offers);
		return "dashboard";
	}

	@RequestMapping("/pendingOfferAcept")
	public String pendingOfferAcept(Model model, Offer offer, Product product) {
		offer.setOfferEnum(OfferEnum.Acepted);
		product.setSold(true);
		return "dashboard";
	}

	@RequestMapping("/pendingOfferCancel")
	public String pendingOfferCancel(Model model, Offer offer, Product product) {
		offer.setOfferEnum(OfferEnum.Cancel);
		product.setSold(false);
		return "dashboard";
	}

}
