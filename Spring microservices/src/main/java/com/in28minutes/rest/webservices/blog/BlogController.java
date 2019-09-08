package com.in28minutes.rest.webservices.blog;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.user.Post;
import com.in28minutes.rest.webservices.user.User;

@RestController
public class BlogController {
	
	
	@GetMapping(value="/blogs")
	public List<Post> serveBlog() {
		User user = new User();
		Post post1 = new Post(1,"titlu1", user);
		Post post2 = new Post(2,"titlu2", user);
		Post post3 = new Post(3,"titlu3", user);
		Post post4 = new Post(4,"titlu4", user);
		Post post5 = new Post(5,"titlu5", user);
		String autor = "autorul principal";
		
		List<Post> listaPosturi = Arrays.asList(post1, post2, post3, post4, post5);
		
		
		
		return listaPosturi;
	}
	

	
}
