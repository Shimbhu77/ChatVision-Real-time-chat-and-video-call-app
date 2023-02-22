package com.chatvision.model;

import jakarta.persistence.Entity;

@Entity
public class User {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private String password;
	private String role;
	private Gender gender;
}
