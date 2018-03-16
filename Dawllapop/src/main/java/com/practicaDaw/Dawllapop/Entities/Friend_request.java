package com.practicaDaw.Dawllapop.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Friend_request {
	public interface BasicInformation {}
	
	@Autowired
	@JsonView(BasicInformation.class)
	private String url = "/friend_request/";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@JsonView(BasicInformation.class)
	private long id;
	@JsonView(BasicInformation.class)
	private String message, state;
	@JsonView(BasicInformation.class)
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
	
	public String getState() {
		return state;
	}

	public User getFrom() {
		return from;
	}

	public User getTo() {
		return to;
	}
	
}
