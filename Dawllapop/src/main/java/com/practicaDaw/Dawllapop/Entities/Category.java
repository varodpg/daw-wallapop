package com.practicaDaw.Dawllapop.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	public Category() {
	}
	
	public Category(String name) {
		this.name=name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}

