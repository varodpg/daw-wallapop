package com.practicaDaw.Dawllapop.Entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Friend_request {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String message, state;
	private Date creationDate;
	
	@OneToOne
	private User from;//User who sends the request
	
	@OneToOne
	private User to;//User who have the request
	
	public Friend_request() {
		
	}
	
	public Friend_request(String message, User from, User to) {
		this.message = message;
		this.from = from;
		this.to = to;
		this.state = "pending";
		this.creationDate = new Date();
	}
	
	public Friend_request(String message, User from, User to, String state) {
		this.message = message;
		this.from = from;
		this.to = to;
		this.state = state;
		this.creationDate = new Date();
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
