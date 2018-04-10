package com.practicaDaw.Dawllapop.Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class User {
	public interface BasicInformation {}
	
	@JsonView(BasicInformation.class)
	private String url = "/user/";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonView(BasicInformation.class)
	private String name;
	@JsonIgnore
	private String passwordHash;
	@JsonView(BasicInformation.class)
	private String email;
	@JsonView(BasicInformation.class)
	private String location;
	@JsonView(BasicInformation.class)
	private String image;
	@JsonView(BasicInformation.class)
	private long phone;
	@JsonView(BasicInformation.class)
	private Date registerDate;
	@JsonView(BasicInformation.class)
	private boolean activatedUser;
	@JsonView(BasicInformation.class)
	private boolean isAdmin;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles = new ArrayList();
	
	@OneToMany(mappedBy = "user")
	@JsonBackReference(value = "reference-to-user")
	private List<Product> productos; 
	
	@OneToMany
	@JsonBackReference(value = "reference-to-offers")
	private List<Offer> offers; 
	
	
	
	//Constructor, getter and setters
	
	
	public User() {
		
	}

//	public User(String name, String email, String image, String passwordHash, boolean activedUser, String location,String...roles) {
//		this.name = name;
//		this.email=email;
//		this.image = image;
//		this.activatedUser=activedUser;
//		this.location=location;
//		this.passwordHash= new BCryptPasswordEncoder().encode(passwordHash);
//		this.roles = new ArrayList<>(Arrays.asList(roles));
//	}
	
	
	
	public User(String name, String email, String location, String image, String passwordHash, long phone, Date registerDate,
			boolean activatedUser, String...roles) {		
		this.name = name;
		this.email = email;
		this.location = location;
		this.image = image;
		this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash);
		this.phone = phone;
		this.registerDate = registerDate;
		this.activatedUser = activatedUser;
		this.roles = new ArrayList<>(Arrays.asList(roles));
		this.setRoles("ROLE_USER");
		
		if (this.getRoles().contains("ROLE_ADMIN")){
			this.isAdmin = true;
		} else {
			this.isAdmin = false;
		}
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
		this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash);
	}

	public List<String> getRoles() {
		return roles;
	}

	@JsonIgnore
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	@JsonIgnore
	public void setRoles(String roles) {
		this.roles.add(roles);
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public List<Product> getProductos() {
		return productos;
	}

	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
	
}
