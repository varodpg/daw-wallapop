package com.practicaDaw.Dawllapop.Entities;

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
	
	@OneToOne(cascade=CascadeType.ALL)
	private User from;//User who sends the request
	
	@OneToOne(cascade=CascadeType.ALL)
	private User to;//User who have the request
	
	protected Friend_request() {
		
	}
	
	protected Friend_request(String message, User form, User to) {
		
	}
}
