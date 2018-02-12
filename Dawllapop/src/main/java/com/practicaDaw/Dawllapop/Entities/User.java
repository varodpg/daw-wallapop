package com.practicaDaw.Dawllapop.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name, email, password, location;
	
	protected User() {
		
	}
	
	protected User(String name, String email, String password, String location) {
		
	}
}
