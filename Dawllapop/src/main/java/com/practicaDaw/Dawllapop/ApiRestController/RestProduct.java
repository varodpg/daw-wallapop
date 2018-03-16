package com.practicaDaw.Dawllapop.ApiRestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.security.UserComponent;
import com.practicaDaw.Dawllapop.services.ProductServices;

@RestController
public class RestProduct {
	@Autowired
	private ProductRepository pRepository;
	@Autowired
	private ProductServices pServices;
	@Autowired
	private UserRepository uRepository;
	@Autowired
	private UserComponent userComponent;
	@Autowired
	private UserRepository userRepo;

	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deletedProduct(@PathVariable long id) {
		Product p = pRepository.findOne(id);
		if (p != null) {
			pRepository.delete(p);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@JsonView(Product.BasicInformation.class)
	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable long id) {
		Product product = pRepository.getOne(id);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@JsonView(Product.BasicInformation.class)
	@RequestMapping(value = "/api/products/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getUserProducts(@PathVariable("id") long id) {
		User user = uRepository.getOne(id);
		if (user != null) {
			List<Product> products = pServices.getAllProductsByUser(user.getId());
			return new ResponseEntity<>(products, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/api/products/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		if (pRepository.findByNameIgnoreCase(product.getName()) == null) {
			pRepository.save(product);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(product, HttpStatus.IM_USED);
		}

	}

	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.PUT)
	@JsonView(Product.BasicInformation.class)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> editProduct(@PathVariable long id, HttpSession session,@RequestBody Product productUpdate) {
		
		Product product = pRepository.findOne(id);
		User userlog =(User) session.getAttribute("user");
		
		if(userlog.getId()==id) {
			
		
		if (product != null) {	

			product.setId(id);
			
		
			if ((productUpdate.getName())!= null) {
				product.setName(productUpdate.getName());
			} else {
				product.setName(product.getName());
			}
			if ((productUpdate.getDescription())!= null) {
				product.setDescription(productUpdate.getDescription());
			} else {
				product.setDescription(product.getDescription());
			}
			if ((productUpdate.getState())!= null) {
				product.setState(productUpdate.getState());
			} else {
				product.setState(product.getState());
			}
			if ((productUpdate.getEspecifications())!= null) {
				product.setSpecifications(productUpdate.getEspecifications());
			} else {
				product.setSpecifications(product.getEspecifications());
			}
			if ((productUpdate.getTags())!= null) {
				product.setTags(productUpdate.getTags());
			} else {
				product.setTags(product.getTags());
			}
			
			
			product.setSold(false);
			product.setPrice(productUpdate.getPrice());
			product.setDate(product.getDate());
		
			
			
			pRepository.saveAndFlush(product);

			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		} else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

}
