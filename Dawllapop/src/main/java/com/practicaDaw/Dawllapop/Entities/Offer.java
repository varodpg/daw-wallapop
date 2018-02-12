package com.practicaDaw.Dawllapop.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int price;
	private String message;
	
	protected Offer() {
	}

	public Offer(int price,String message) {
		super();
		this.price=price;
		this.message = message;
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

}
