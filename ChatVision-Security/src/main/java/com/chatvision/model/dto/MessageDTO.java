package com.chatvision.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

	private String receiverUserEmail;
	private String text;
//    private LocalDateTime timestamp;
}
