package com.in28minutes.rest.webservices.user;

import java.util.Date;

public class Post {
	private int id;
	private String content;
	private Date date;
	public Post(int id, String content, Date date) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", date=" + date + "]";
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
