package com.in28minutes.rest.webservices.user;

import java.util.Date;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "All details about the user")
@Entity
public class User {
	
	/*protected User() {
		
	}*/
	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public User() {
		
	}
	
	@Id  //make it primary key
	@GeneratedValue
	private Integer id;
	
	//size validaiton
	@ApiModelProperty(notes="At least 2 characters")
	@Size(min=2, message = "Name should have at least 2 characters")
	private String name;
	//date must be in the past
	@ApiModelProperty(notes="Birtdate should be in the past")
	@Past
	private Date birthDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	public LinkedList<Post> getPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
