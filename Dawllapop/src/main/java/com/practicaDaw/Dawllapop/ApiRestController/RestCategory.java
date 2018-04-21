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
import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.CategoryRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;

@RestController
public class RestCategory {
	
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@JsonView(Category.BasicInformation.class)
	@RequestMapping(value = "/api/category/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> getCategoryById(@PathVariable long id) {
		Category category = categoryRepo.findOne(id);
		if (category != null) {
			return new ResponseEntity<>(category, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@JsonView(Category.BasicInformation.class)
	@RequestMapping(value = "/api/category/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> getCategoryByProduct(@PathVariable long id) {
		Product product = productRepo.findOne(id);
		if (product != null) {
			return new ResponseEntity<>(product.getCategory(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@JsonView(Category.BasicInformation.class)
	@RequestMapping(value = "/api/category", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getCategories(){
		List<Category> categories = categoryRepo.findAll();
		if(!categories.isEmpty()) {
			return new ResponseEntity<>(categories, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
