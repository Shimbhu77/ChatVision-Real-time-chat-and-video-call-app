package com.chatvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatvision.model.User;
import com.chatvision.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService uService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/app/home/register")
	public ResponseEntity<User> registerUser(@Validated @RequestBody User user) 
	{
		user.setPassword(passwordEncoder.encode(user.getPassword())); 
         
		User p = uService.registerUser(user);
		
		return new ResponseEntity<User>(p,HttpStatus.CREATED);
	}
	
	@GetMapping("/app/home")
	public ResponseEntity<String> LoginUserWelcome()
	{

		String p = "Welcome to Masai Website";
		
		return new ResponseEntity<String>(p,HttpStatus.OK);
	}
	
	@GetMapping("/login/user")
	public ResponseEntity<String> LoginUser()
	{
		
		String p = "Welcome to Masai Website  : " + uService.loginUser();
		
		return new ResponseEntity<String>(p,HttpStatus.OK);
	}
}
