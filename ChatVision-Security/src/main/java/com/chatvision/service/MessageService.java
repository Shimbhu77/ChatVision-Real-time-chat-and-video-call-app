package com.chatvision.service;

import java.util.List;

import com.chatvision.exceptions.ChatException;
import com.chatvision.exceptions.MessageException;
import com.chatvision.exceptions.UserException;
import com.chatvision.model.Message;
import com.chatvision.model.dto.MessageDTO;

public interface MessageService {

	Message newMessage(MessageDTO message) throws MessageException, ChatException, UserException;
	Message getMessage(Integer Id) throws MessageException;
	List<Message> getAllMessages() throws MessageException;
}
