package com.practicaDaw.Dawllapop.ApiRestController;



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

@RestController
public class RestCategory {
	
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@JsonView(Category.BasicInformation.class)
	@RequestMapping(value = "/api/cat/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> getCategoryById(@PathVariable long id) {
		Category category = categoryRepo.findOne(id);
		if (category != null) {
			return new ResponseEntity<>(category, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}	

}
