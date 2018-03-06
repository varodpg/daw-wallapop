package com.practicaDaw.Dawllapop.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.practicaDaw.Dawllapop.Entities.Product.BasicInformation;

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
	@JsonBackReference
	private List<Product> productos; 
	
	public Category() {
	}
	
	public Category(String name) {
		this.name=name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProductos() {
		return productos;
	}

	public void setProductos(List<Product> productos) {
		this.productos = productos;
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

