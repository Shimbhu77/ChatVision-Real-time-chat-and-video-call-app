package com.chatvision.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.chatvision.exceptions.UserException;
import com.chatvision.model.User;

public interface UserService {

	public User signUp(User user) throws UserException;
	public User signIn(Authentication auth) throws UserException;
	public User getUserDetails(String email) throws UserException;
	public List<User> getAllUserDetails() throws UserException;
	
}
