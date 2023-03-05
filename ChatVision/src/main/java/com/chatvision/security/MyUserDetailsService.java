package com.chatvision.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chatvision.model.User;
import com.chatvision.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByName(username);
		
		if(user!=null)
		{
			return new MyUserDetails(user);
		}
		
		throw new UsernameNotFoundException("user not found with this username : "+username);
		
	}

}
