package com.springsec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsec.model.User;

@Repository
public interface MyUserDetailsRepo extends JpaRepository<User,Integer>{
	
	User findByUsername(String username);

}
