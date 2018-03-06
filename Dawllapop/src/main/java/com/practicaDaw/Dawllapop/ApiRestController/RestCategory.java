package com.practicaDaw.Dawllapop.ApiRestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;

@RestController
public class RestCategory {
	@Autowired
	private ProductRepository p_repository;

	@RequestMapping(value = "/api/category/{id}", method = RequestMethod.GET)
	@JsonView(Product.BasicInformation.class)
	public Page<Product> getProductsByCategory(Pageable page, Category category) {
		return p_repository.findByCategory(page, category);
	}

}
