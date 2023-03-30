package com.chatvision.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

	@JsonProperty("receiverUserEmail")
	private String receiverUserEmail;
	
	@JsonProperty("text")
	private String text;
//    private LocalDateTime timestamp;
}
