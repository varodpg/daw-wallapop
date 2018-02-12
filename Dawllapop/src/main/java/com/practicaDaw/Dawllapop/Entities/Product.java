package com.practicaDaw.Dawllapop.Entities;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	
	protected Product(String name, String description, ArrayList<String[]> especifications, ArrayList<String> tags, double price) {
		
	}
	
}
