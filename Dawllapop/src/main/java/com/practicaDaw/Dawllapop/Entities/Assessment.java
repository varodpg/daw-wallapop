package com.practicaDaw.Dawllapop.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.practicaDaw.Dawllapop.Entities.Product.BasicInformation;

@Entity
public class Assessment {
	public interface BasicInformation {}
	
	@Autowired
	@JsonView(BasicInformation.class)
	private String url = "/assessment/";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonView(BasicInformation.class)
	private String text;
	@JsonView(BasicInformation.class)
	private int value;
	@JsonView(BasicInformation.class)
	private Date date;
	
	@OneToOne
	@JsonBackReference
	private User userFrom;
	
	@OneToOne
	@JsonBackReference
	private User userTo;
	
	public Assessment() {
	}
	
	public Assessment(String text, int value, User userFrom, User userTo, Date date) {
		this.text = text;
		this.value = value;
		this.userFrom = userFrom;
		this.userTo = userTo;
		this.date = date;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setUserFrom(User userFrom) {
		this.userFrom = userFrom;
	}

	public void setUserTo(User userTo) {
		this.userTo = userTo;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
