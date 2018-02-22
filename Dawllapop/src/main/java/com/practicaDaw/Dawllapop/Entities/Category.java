package com.practicaDaw.Dawllapop.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
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
	
}

