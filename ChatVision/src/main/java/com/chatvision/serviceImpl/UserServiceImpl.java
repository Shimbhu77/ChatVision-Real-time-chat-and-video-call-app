package com.chatvision.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chatvision.model.User;
import com.chatvision.repository.UserRepository;
import com.chatvision.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User registerUser(User user) {
	 
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return  userRepo.save(user);
	}

}
