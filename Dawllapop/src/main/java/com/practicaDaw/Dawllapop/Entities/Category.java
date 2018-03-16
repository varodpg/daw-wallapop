package com.practicaDaw.Dawllapop.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

@Entity
public class Category {
	public interface BasicInformation {}
	
	@Autowired
	@JsonView(BasicInformation.class)
	private String url = "/category/";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonView(BasicInformation.class)
	private String name;
	
	@OneToMany(mappedBy="category")
	@JsonBackReference(value = "reference-to-category")
	
	private List<Product> products; 
	
	public Category() {
	}
	
	public Category(String name) {
		this.name=name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
}

