package com.in28minutes.rest.webservices.user;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource { //UserController

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	// GET /users
	// retrieveAllUsers
	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers() {
		System.out.println("asdasdsadas");
		System.out.println("asdasdsadas"+ userRepository.findAll());
		
		return userRepository.findAll();
	}

	// GET /users/{id}
	// retrieveUser int id
	@GetMapping(path = "/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		//retrieveAllUsers
		Resource<User> resource = new Resource<User>(user.get());

		//builds a link that points to the retrieveallusers method
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	// CREATED
	// input - details of user
	// output - CREATED & return the created URI
	// whatever i pass in the request will be mapped to the user
	// name will be mapped to name
	// date will be mapped to date
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){

		User savedUser = userRepository.save(user);
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
	
	@GetMapping("/jpa/user/{id}/posts")
	public List<Post> retrieveAllPostsId(@PathVariable int id) {
		Optional<User> findById = userRepository.findById(id);
		
		if(!findById.isPresent())
			throw new UserNotFoundException("id-" + id);
		
		if(findById.get().getPosts() == null)
			throw new PostNotFoundException("User has no posts");
		
		return findById.get().getPosts();
	}
	
	
	
	//@Requestbody means that the content of the post will be in the body of the request
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post){

		Optional<User> findById = userRepository.findById(id);
		
		if(!findById.isPresent())
			throw new UserNotFoundException("id-" + id);
		//CREATED
		// /user/user.getId
		//http://localhost:8080/users/4
		
		User user = findById.get();
		
		post.setUser(user);
		
		postRepository.save(post);
			
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(post.getId())
				.toUri();
		
		//<201 CREATED Created,[Location:"http://localhost:8080/users/4"]>
		return ResponseEntity.created(location).build();
	}
}
;