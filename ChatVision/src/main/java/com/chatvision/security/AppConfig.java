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

@Configuration
public class AppConfig {
	
	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception
	{
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and()
//		.csrf().disable()
//		.authorizeHttpRequests()
//		.requestMatchers("/swagger-ui/**").permitAll()
////		.requestMatchers(HttpMethod.GET,"/users").hasRole("ADMIN")
////		.requestMatchers(HttpMethod.GET,"users/**").hasAnyRole("ADMIN","USER")
//		.anyRequest()
//		.authenticated().and()
//		.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
//		.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
//		.formLogin()
//		.and()
//		.httpBasic();
//		
//		return http.build();
		
		http
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST, "/users").permitAll()
		.requestMatchers("/swagger-ui/**","/v3/api-docs/**").permitAll()
		.anyRequest().authenticated().and()
		.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
		.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
		.formLogin()
		.and()
		.httpBasic();

		return http.build();

		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
