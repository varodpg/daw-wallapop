package com.practicaDaw.Dawllapop.Entities;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date date;
	private int price;
	private String message;
	private OfferEnum offerEnum;
	@ManyToOne
	@JsonBackReference
	private User buyer;

	@ManyToOne
	@JsonBackReference
	private User seller;

	@ManyToOne
	@JsonBackReference
	private Product product;

	protected Offer() {
	}

	public Offer(int price, String message, OfferEnum offerEnum, User buyer, User seller, Product product) {
		this.price = price;
		this.message = message;
		this.offerEnum = offerEnum;
		this.buyer = buyer;
		this.seller = seller;
		this.product = product;
		this.date=new Date();

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

	public void setOfferEnum(OfferEnum offerEnum) {
		this.offerEnum = offerEnum;
	}

	public Product getProduct() {
		return product;
	}
}
