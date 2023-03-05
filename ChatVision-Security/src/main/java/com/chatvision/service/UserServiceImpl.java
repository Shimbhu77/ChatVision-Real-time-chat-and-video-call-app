package com.chatvision.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.chatvision.model.User;
import com.chatvision.repo.UserRepo;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User registerUser(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public String loginUser() {
			
		SecurityContext sc  = SecurityContextHolder.getContext();
		
		Authentication auth  = sc.getAuthentication();
		
		String userName = auth.getName();
		
		User user = userRepo.findByName(userName);
		
		return user.toString();
		
	}

	@Override
	public String welcomePage() {
		// TODO Auto-generated method stub
		return null;
	}

}
