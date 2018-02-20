package com.practicaDaw.Dawllapop.Entities;


import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name, description, state;
	private ArrayList<String[]> especifications;
	private ArrayList<String> tags;
	private double price;

	
	@OneToOne(cascade=CascadeType.ALL)
	private Category category;
	
	protected Product() {
	}
	
	public Product(String name, String description, ArrayList<String[]> especifications, ArrayList<String> tags, double price) {
		this.name=name;
		this.description=description;
		this.especifications=especifications;
		this.tags=tags;
		this.price=price;

	}
	
	public Product(String name, String description, ArrayList<String[]> especifications, ArrayList<String> tags, double price, Category category) {
		this.name=name;
		this.description=description;
		this.especifications=especifications;
		this.tags=tags;
		this.price=price;
		this.category = category;
		
	}
	
	public Product(String name, String description, double price) {
		this.name=name;
		this.description=description;
		this.price=price;

	}
	
	public Product(String name, String description, double price, Category category) {
		this.name=name;
		this.description=description;
		this.price=price;
		this.category = category;
	}
	
	public String getName() {
		return name;
	}

	public void setName(int id) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "Producto [nombre=" + name + " y especificaciones: " + especifications + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ArrayList<String[]> getEspecifications() {
		return especifications;
	}

	public void setEspecifications(ArrayList<String[]> especifications) {
		this.especifications = especifications;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
