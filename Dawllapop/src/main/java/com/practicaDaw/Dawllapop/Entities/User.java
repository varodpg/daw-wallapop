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

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String passwordHash;
	private String email;
	private String location;
	private String image;
	private boolean activatedUser;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	//Constructor, getter and setters
	
	
	public User() {
		
	}

	public User(String name, String email, String image, String passwordHash, boolean activedUser, String location,String...roles) {
		this.name = name;
		this.email=email;
		this.image = image;
		this.activatedUser=activedUser;
		this.location=location;
		this.passwordHash= new BCryptPasswordEncoder().encode(passwordHash);
		this.roles = new ArrayList<>(Arrays.asList(roles));
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isActivatedUser() {
		return activatedUser;
	}

	public void setActivatedUser(boolean activatedUser) {
		this.activatedUser = activatedUser;
	}
	@Override
	public String toString() {
		return this.name;
		
	}
	
}
