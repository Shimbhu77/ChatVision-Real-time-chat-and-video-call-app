package com.chatvision.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.chatvision.jwt.JwtGeneratorFilter;
import com.chatvision.jwt.JwtValidationFilter;

@Configuration
public class SecurityConfig {
	
	@Bean
    SecurityFilterChain mySecurity(HttpSecurity http) throws Exception
	{
//		http.
//		sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and().
//		authorizeHttpRequests((auth) -> 
//		auth.requestMatchers("/app/**").permitAll()
//		.requestMatchers("/login/**").authenticated()
//		.requestMatchers("/swagger-ui/**","/v3/api-docs/**").permitAll()
//		).csrf().disable()
//		.addFilter(null).httpBasic(); 
		
		http
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/app/**").permitAll()
		.requestMatchers(HttpMethod.GET, "/login/**").hasRole("ADMIN")
		.requestMatchers(HttpMethod.GET, "/login/**").hasAnyRole("ADMIN","USER")		
		.anyRequest().authenticated().and()
		.addFilterAfter(new JwtGeneratorFilter(), BasicAuthenticationFilter.class)
		.addFilterBefore(new JwtValidationFilter(), BasicAuthenticationFilter.class)
		.formLogin()
		.and()
		.httpBasic();
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
