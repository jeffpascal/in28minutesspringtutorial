package com.in28minutes.rest.webservices;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvcBuilder;

import com.in28minutes.rest.webservices.user.User;
import com.in28minutes.rest.webservices.user.UserJPAResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMicroservicesApplicationTests {
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testGetAllUsers() {
		User user1 = new User(1,"Homa",new Date(11, 11, 11));
		User user2 = new User(2,"Homa",new Date(12, 12, 12));
		
		
	}

}
