package com.springsec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsec.model.MyUserDetails;
import com.springsec.model.User;
import com.springsec.repo.MyUserDetailsRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	MyUserDetailsRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUsername(username);
		
		if(user == null ) {
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("User Not Found");
		}
		
		return new MyUserDetails(user);
	}

}
