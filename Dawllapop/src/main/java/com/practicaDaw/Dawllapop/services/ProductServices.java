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

	public Page<Product> getAllbyCatAndFilter(String price_low, String price_top, String state, Category cat_selected, Pageable page) {
		return productRepository.findByCategoryFiltering(price_low, price_top, state, cat_selected, page);
	}
	
	public Page<Product> getAllByUser(Pageable pageable, User user) {
		return productRepository.findByUser(pageable, user);
	}

	public Page<Product> getAllbyCatAndFilter2(String price_low, String price_top, String product_state_1, String product_state_2, Category cat_selected,
			Pageable page) {
		return productRepository.findByCategoryFiltering2(price_low, price_top, product_state_1, product_state_2, cat_selected, page);
	}
	
	public List<Product> searchProductsByName(String name){
		return productRepository.searchByName(name);
	}
	

	public List<Product> getAllProductsByLocation(String location) {
		return productRepository.findFirst10ByUserLocation(location);
	}

	public List<Product> getAllProductsByDate() {
		return productRepository.findFirst8ByOrderByDateDesc();
	}

	public List<Product> getAllProductsByUser(Long id) {
		return productRepository.findAllByUserId(id);
	}
	

	
}