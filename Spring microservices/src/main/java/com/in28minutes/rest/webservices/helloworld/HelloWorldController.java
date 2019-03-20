package com.in28minutes.rest.webservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	// get
	// hello-world uri
	// method HelloWorld
	// @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String HelloWorld() {
		return "Hello World !";
	}

	// returning a bean back
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World !");
	}

	// getting a path variable from the uri
	///hello-world/path-variable/in28minutes
	//will be mapped into the variable name
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
