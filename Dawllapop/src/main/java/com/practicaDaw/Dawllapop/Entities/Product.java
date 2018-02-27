package com.practicaDaw.Dawllapop.Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.practicaDaw.Dawllapop.ImageManager.Image;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name, description, state;
	private ArrayList<String[]> especifications;
	private ArrayList<String> tags;
	private double price;
	private ArrayList<String> images = new ArrayList();
	private String mainimage;
	private boolean sold = false;
	private Date date; 

	@ManyToOne
	@JsonManagedReference
	private Category category;

	@ManyToOne
	@JsonManagedReference
	private User user;

	@OneToMany(mappedBy="product")
	@JsonManagedReference
	private List<Offer> offers;
	
	
	protected Product() {
	}

	public Product(String name, String description, String state, ArrayList<String[]> especifications,
			ArrayList<String> tags, double price) {
		this.name = name;
		this.description = description;
		this.state = state;
		this.especifications = especifications;
		this.tags = tags;
		this.price = price;
	}

	public Product(String name, String description, String state, ArrayList<String[]> especifications,
			ArrayList<String> tags, double price, boolean sold, Date date2) {
		this.name = name;
		this.description = description;
		this.state = state;
		this.especifications = especifications;
		this.tags = tags;
		this.price = price;
		this.sold = sold;
		this.date=date2;
	}

	public Product(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;

	}

	public Product(String name, String description, double price, Category category) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(int id) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", state=" + state
				+ ", especifications=" + especifications + ", tags=" + tags + ", price=" + price + ", images=" + images
				+ ", mainimage=" + mainimage + ", sold=" + sold + ", date=" + date + ", category=" + category
				+ ", user=" + user + ", offers=" + offers + "]";
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setSold(boolean sold) {
		this.sold = sold;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void addImage(String image) {
		images.add(image);
		this.mainimage = image;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public String getMainimage() {
		return mainimage;
	}

	public void setMainimage(String mainimage) {
		this.mainimage = mainimage;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public boolean isSold() {
		return sold;
	}
	
	// public ArrayList<Image> getImages() {
	// return this.images;
	// }
	// public void removeImage(Image image) {
	// if(this.images.contains(image)) {
	// images.remove(image);
	// }
	// }
	// public void addImage(Image image) {
	// this.images.add(image);
	// }
	// public void removeAllImages() {
	// this.images.clear();
	// }
}
