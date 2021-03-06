package com.practicaDaw.Dawllapop.Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Product {
	public interface BasicInformation {}
	
	@Autowired
	@JsonView(BasicInformation.class)
	private String url = "/product/";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(BasicInformation.class)
	private long id;
	
	@JsonView(BasicInformation.class)
	private String name, description, state;
	
	@JsonView(BasicInformation.class)
	private ArrayList<String[]> specifications=new ArrayList<>();
	
	@JsonView(BasicInformation.class)
	private ArrayList<String> tags;
	
	@JsonView(BasicInformation.class)
	private double price;
	
	@JsonView(BasicInformation.class)
	private ArrayList<String> images = new ArrayList();
	
	@JsonView(BasicInformation.class)
	private String mainimage;
	
	@JsonView(BasicInformation.class)
	private boolean sold = false;
	
	@JsonView(BasicInformation.class)
	private Date date; 
	
	
	
	

	@ManyToOne
	@JsonManagedReference(value = "reference-to-category")
	@JsonIgnore
	@JsonView(BasicInformation.class)
	private Category category;

	@ManyToOne
	@JsonManagedReference(value = "reference-to-user")
	@JsonIgnore
	@JsonView(BasicInformation.class)
	private User user;

	@OneToMany(mappedBy="product")
	@JsonManagedReference(value = "reference-to-offers")
	@JsonIgnore
	private List<Offer> offers;
	
	
	protected Product() {
	}

	public Product(String name, String description, String state, ArrayList<String[]> specifications,
			ArrayList<String> tags, double price) {
		this.name = name;
		this.description = description;
		this.state = state;
		this.specifications = specifications;
		this.tags = tags;
		this.price = price;
	}

	public Product(String name, String description, String state, ArrayList<String[]> especifications,
			ArrayList<String> tags, double price, boolean sold, Date date2) {
		this.name = name;
		this.description = description;
		this.state = state;
		this.specifications = especifications;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", state=" + state
				+ ", especifications=" + specifications + ", tags=" + tags + ", price=" + price + ", images=" + images
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
		return specifications;
	}

	public void setSpecifications(ArrayList<String[]> specifications) {
		this.specifications = specifications;
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


	public boolean isSold() {
		return sold;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
	public void addOffer(Offer offer) {
		this.offers.add(offer);
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
