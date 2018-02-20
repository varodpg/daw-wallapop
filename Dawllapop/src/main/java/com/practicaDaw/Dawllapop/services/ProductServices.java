package com.practicaDaw.Dawllapop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;



@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;

	public Page<Product> getAllProducts(Pageable page) {
		return productRepository.findAll(page);
	}

	public List<Product> getAllProducts() {
		return  productRepository.findAll();
	}

}