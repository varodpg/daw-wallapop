package com.practicaDaw.Dawllapop.Entities;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Offer {
	public interface BasicInformation {}
	
	@JsonView(BasicInformation.class)
	private String url = "/offer/";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonView(BasicInformation.class)
	private Date date;
	@JsonView(BasicInformation.class)
	private int price;
	@JsonView(BasicInformation.class)
	private String message;
	@JsonView(BasicInformation.class)
	private int state;
	
	@OneToOne
	private User buyer;

	@ManyToOne
	@JsonBackReference(value = "reference-from-product-to-offer")
	@JsonView(BasicInformation.class)
	private Product product;

	protected Offer() {
	}

	public Offer(int price, String message, int state, User buyer) {
		this.price = price;
		this.message = message;
		this.state = state;
		this.date=new Date();
		this.buyer=buyer;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
}
