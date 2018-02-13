package com.practicaDaw.Dawllapop.Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name, email, location;
	private String passwordHash;
	private Rol rol;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	//Constructor, getter and setters
	
	
	public User() {
		
	}
	
	public User(String name, String email, String password, String location,Rol rol) {
		this.name = name;
		this.email=email;
		this.passwordHash=password;
		this.location=location;
		this.rol=rol;
		//this.passwordHash = new BCryptPasswordEncoder().encode(password);
		//this.roles = new ArrayList<>(Arrays.asList(roles));
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
}
