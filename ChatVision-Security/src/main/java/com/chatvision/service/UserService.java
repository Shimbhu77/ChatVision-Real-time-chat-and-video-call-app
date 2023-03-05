package com.chatvision.service;

import com.chatvision.model.User;

public interface UserService {

	public User registerUser(User user);
	public String loginUser();
	public String welcomePage();
}
