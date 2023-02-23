package com.chatvision.userdetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chatvision.model.Authority;
import com.chatvision.model.User;
import com.chatvision.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> opt = userRepository.findByEmail(username);
		
		if(opt.isPresent())
		{
			User user = opt.get();
			
			List<GrantedAuthority> authorities = new ArrayList<>();
			
//			List<Authority> auths = user.getAuthorities();
//			
//			for(Authority auth : auths)
//			{
//				SimpleGrantedAuthority sga = new SimpleGrantedAuthority(auth.getName());
//				
//				authorities.add(sga);
//			}
			
			String role = "ROLE_"+user.getRole().toUpperCase();
			
			SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(role);
			authorities.add(simpleGrantedAuthority);
			
			return new MyUserDetails(user);
			
		}
		else
		{
			throw new BadCredentialsException("no user found with this name : "+username);
		}
		
		
	}

}
