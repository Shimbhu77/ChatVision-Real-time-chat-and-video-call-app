package com.chatvision.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Authority {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer authId;
	
	private String name;
	
//	@JsonIgnore
//	@ManyToOne
//	private User user;
}
