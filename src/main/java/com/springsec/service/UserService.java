package com.springsec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsec.model.User;
import com.springsec.repo.MyUserDetailsRepo;

@Service
public class UserService {
	
	@Autowired
	private MyUserDetailsRepo userRepo;
	
	private BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder(12);
	
	public User registerUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

}
