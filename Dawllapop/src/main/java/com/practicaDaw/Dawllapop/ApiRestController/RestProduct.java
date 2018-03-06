package com.practicaDaw.Dawllapop.ApiRestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;

@RestController
public class RestProduct {
	@Autowired
	private ProductRepository p_repository;
	
	@RequestMapping(value = "/api/deleteProduct/{id}", method = RequestMethod.DELETE)
	public boolean deletedProduct(@PathVariable long id) {
		Product p = p_repository.findOne(id);
		p_repository.delete(p);
		return true;
	}
}
