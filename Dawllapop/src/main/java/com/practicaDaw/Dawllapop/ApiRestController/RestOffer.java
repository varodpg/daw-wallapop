package com.practicaDaw.Dawllapop.ApiRestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.OfferRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.security.UserComponent;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestOffer {

	@Autowired
	private OfferRepository offerRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private UserComponent userComponent;
	
	
	@JsonView(Offer.BasicInformation.class)
	@RequestMapping(value = "/api/offers/{id}", method = RequestMethod.GET)
	public ResponseEntity<Offer> getOfferById(@PathVariable long id) {
		Offer offer = offerRepo.getOne(id);
		if (offer != null)
			return new ResponseEntity<>(offer, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@JsonView(Offer.BasicInformation.class)
	@RequestMapping(value = "/api/offers/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Offer>> getOffersByUser(@PathVariable long id) {
		User user = userRepo.getOne(id);
		if (user != null) {
			List<Offer> offers = user.getOffers();
			return new ResponseEntity<>(offers, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
//
//	@JsonView(Offer.BasicInformation.class)
//	@RequestMapping(value = "/api/offers/product/{id}", method = RequestMethod.GET)
//	public ResponseEntity<List<Offer>> getOffersByProduct(@PathVariable long id) {
//		Product product = productRepo.getOne(id);
//		if (product != null) {
//			List<Offer> offers = product.getOffers();
//			return new ResponseEntity<>(offers, HttpStatus.OK);
//		} else
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//	}
//	
	@RequestMapping(value = "/api/offers/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Offer> addOffer(@RequestBody Map<String, Object> rBody) {
		User u = userRepo.findById((int) rBody.get("userId"));
		Offer o = new Offer(Integer.parseInt((String) rBody.get("price")), (String) rBody.get("message"), 0, u);
		Product p = productRepo.getOne(Long.parseLong(new Integer((int) rBody.get("productId")).toString()));
		o.setProduct(p);		
		offerRepo.save(o);
		return new ResponseEntity<>(o, HttpStatus.OK);		

	}
}