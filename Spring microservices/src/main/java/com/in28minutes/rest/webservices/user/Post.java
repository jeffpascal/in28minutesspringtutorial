package com.in28minutes.rest.webservices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private int id;
	
	private String content;
	
	@ManyToOne(fetch=FetchType.LAZY)
	//@JsonIgnore
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Post(int id, String content, User user) {
		super();
		this.id = id;
		this.content = content;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", user=" + user + "]";
	}
	
	
}
