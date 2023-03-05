package com.chatvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatvision.model.User;
import com.chatvision.repo.UserRepo;

@RestController
public class LoginController {

	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/signIn")
	public ResponseEntity<User> getLoggedInCustomerDetailsHandler(Authentication auth) throws BadCredentialsException{
		
		
		User customer= userRepo.findByName(auth.getName()) ; //.orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		
		if(customer!=null)
		{
			 return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
		}
		
		throw new BadCredentialsException("Invalid Username or password");
		
		 //to get the token in body, pass HttpServletResponse inside this method parameter 
		// System.out.println(response.getHeaders(SecurityConstants.JWT_HEADER));
		 
		 
		
	}		 
}
