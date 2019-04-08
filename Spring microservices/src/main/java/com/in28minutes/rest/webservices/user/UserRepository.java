package com.in28minutes.rest.webservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//repositories are interfaces ---- extends jparepo with class that needs the repo and the primary key type
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
}
