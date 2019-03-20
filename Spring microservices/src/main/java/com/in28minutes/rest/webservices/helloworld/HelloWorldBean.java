package com.in28minutes.rest.webservices.helloworld;

public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message) {
		this.message = message;
	}
	
	//you must create a getter to not get an error
	//There was an unexpected error (type=Internal Server Error, status=500).
	//No converter found for return value of type: class com.in28minutes.rest.webservices.HelloWorldBean
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
}
