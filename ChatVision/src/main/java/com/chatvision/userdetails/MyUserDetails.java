package com.chatvision.userdetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.chatvision.model.Authority;
import com.chatvision.model.User;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class MyUserDetails implements UserDetails {

	private User user;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> authorities=new ArrayList<>();
		
//		List<Authority> auths= user.getAuthorities();
//
//		for(Authority auth:auths)
//		{
//			SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(auth.getName());
//			authorities.add(simpleGrantedAuthority);
//		}
		String role = "ROLE_"+user.getRole().toUpperCase();
		
		SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(role);
		authorities.add(simpleGrantedAuthority);
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	
}
