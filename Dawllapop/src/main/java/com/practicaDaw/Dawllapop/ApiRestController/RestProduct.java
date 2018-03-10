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
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.services.ProductServices;

@RestController
@RequestMapping("/api/products")
public class RestProduct {
	@Autowired
	private ProductRepository pRepository;
	@Autowired
	private ProductServices pServices;
	@Autowired
	private UserRepository uRepository;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deletedProduct(@PathVariable long id) {
		Product p = pRepository.findOne(id);
		if(p != null) {
			pRepository.delete(p);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@JsonView(Product.BasicInformation.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable long id){
		Product product = pRepository.getOne(id);
		if(product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@JsonView(Product.BasicInformation.class)
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getUserProducts(@PathVariable("id") long id){
		User user = uRepository.getOne(id);
		if(user != null) {
			List<Product> products = pServices.getAllProductsByUser(user.getId());
			return new ResponseEntity<>(products, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}					
	}	
}
