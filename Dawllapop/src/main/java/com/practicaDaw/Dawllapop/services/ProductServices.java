package com.practicaDaw.Dawllapop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;



@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;

	public Page<Product> getAllProducts(Pageable page) {
		return productRepository.findAll(page);
	}
	
	public long getNumberOfProductsByCat(Category cat) {
		return productRepository.countByCategory(cat);
	}

	
	public List<Product> getAllProducts() {
		return  productRepository.findAll();
	}

	public Product findOne(long id) {
		return productRepository.findOne(id);
	}

	public Page<Product> getAllbyCat(Pageable page, Category cat) {
		return productRepository.findByCategory(page, cat);
	}


	public Page<Product> getAllbyCatAndFilterExample(String state, Pageable page) {
		return productRepository.findByCategoryFilteringExample(state, page);
		
	}

	public Page<Product> getAllbyCatAndFilter(String state, Category cat_selected, Pageable page) {
		return productRepository.findByCategoryFiltering(state, cat_selected, page);
	}
	
	public Page<Product> getAllByUser(Pageable pageable, User user) {
		return productRepository.findByUser(pageable, user);
	}
	
	
}