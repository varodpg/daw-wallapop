package com.practicaDaw.Dawllapop.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assessment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String text;
	private String name;
	private String email;
	private int value;

	public Assessment() {
	}

	public Assessment(String name, String email, String text,int value) {
		this.text = text;
		this.name = name;
		this.email = email;
		this.value=value;
		
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
