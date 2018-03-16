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
	
	private User userFrom;
	
	@OneToOne
	
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

	public String getText() {
		return text;
	}

	public User getUserFrom() {
		return userFrom;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getValue() {
		return value;
	}

	public User getUserTo() {
		return userTo;
	}

	@Override
	public String toString() {
		return "Assessment [url=" + url + ", id=" + id + ", text=" + text + ", value=" + value + ", date=" + date
				+ ", userFrom=" + userFrom + ", userTo=" + userTo + "]";
	}

}
