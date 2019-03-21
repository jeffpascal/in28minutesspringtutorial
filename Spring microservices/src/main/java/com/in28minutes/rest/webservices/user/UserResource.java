package com.in28minutes.rest.webservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource { //UserController

	@Autowired
	private UserDaoService service;

	// GET /users
	// retrieveAllUsers
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// GET /users/{id}
	// retrieveUser int id
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		return user;
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
	}

	// CREATED
	// input - details of user
	// output - CREATED & return the created URI
	// whatever i pass in the request will be mapped to the user
	// name will be mapped to name
	// date will be mapped to date
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){

		System.out.println(user);
		User savedUser = service.save(user);
		//CREATED
		// /user/user.getId
		//http://localhost:8080/users/4
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		//<201 CREATED Created,[Location:"http://localhost:8080/users/4"]>
		return ResponseEntity.created(location).build();
	}
}
;