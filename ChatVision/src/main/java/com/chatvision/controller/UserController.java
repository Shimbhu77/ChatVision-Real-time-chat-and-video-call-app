package com.chatvision.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatvision.exceptions.UserException;
import com.chatvision.model.User;
import com.chatvision.model.DTO.UserDTO;
import com.chatvision.service.UserService;

@RestController
public class UserController {
   
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome()
	{
		String message = "Welcome to ChatVision";
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserException
	{
		
		String password ="@sk$"+user.getPassword()+"77sk12";
		
		user.setPassword(passwordEncoder.encode(password));
		
		User userDetail = userService.signUp(user);
		
		return new ResponseEntity<User>(userDetail,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/users/SignIn")
	public ResponseEntity<User> signIn(Authentication auth) throws UserException
	{
		User userDetail = userService.signIn(auth);
		
		return new ResponseEntity<User>(userDetail,HttpStatus.ACCEPTED);
	}
	
}
