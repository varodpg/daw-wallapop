package com.practicaDaw.Dawllapop.ApiRestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Repository.CategoryRepository;
import com.practicaDaw.Dawllapop.services.ProductServices;

@RestController
public class RestCategory {
	
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductServices productServices;

/*	@RequestMapping(value = "/api/category/{id}", method = RequestMethod.GET)
	@JsonView(Product.BasicInformation.class)
	public Page<Product> getProductsByCategory(Pageable page, Category category) {
		return p_repository.findByCategory(page, category);
	}*/
//	@RequestMapping(value = "/api/category/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Category> getCategoryById(@PathVariable long id) {
//		Category category = categoryRepo.getOne(id);
//		if(category != null)
//			return new ResponseEntity<>(category, HttpStatus.OK);
//		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//		}
//	
	
	
//	@RequestMapping(value = "/api/category/{id}", method = RequestMethod.GET)
//	public ResponseEntity<List<Page>> getAllProductsByCategory(@PageableDefault(size = 10) Pageable page
//			,@PathVariable long id) {
//		List<Page> pageList = new ArrayList<Page>();
//		Category category = categoryRepo.getOne(id);
//		if(category != null){
//			pageList.add(productServices.getAllbyCat(page, category));
//			return new ResponseEntity<>(pageList, HttpStatus.OK);
//		}
//		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		
//	}	

}
