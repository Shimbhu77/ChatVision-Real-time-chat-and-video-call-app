package com.chatvision.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.chatvision.exceptions.UserException;
import com.chatvision.model.Authority;
import com.chatvision.model.User;
import com.chatvision.repository.UserRepository;
import com.chatvision.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User signUp(User user) throws UserException {

//		List<Authority> authorities= user.getAuthorities();
//		
//		for(Authority authority:authorities) {
//			authority.setUser(user);
//		}
		
		return userRepository.save(user);
	}

	@Override
	public User signIn(Authentication auth) throws UserException {
		
		Optional<User> opt= userRepository.findByEmail(auth.getName());
		
		if(opt.isPresent())
		{
			User user = opt.get();
					
		    return user;			
		}
		else
		{
			throw new UserException("Invalid username or Password");
		}
	}

	@Override
	public User getUserDetails(String email) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUserDetails() throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
