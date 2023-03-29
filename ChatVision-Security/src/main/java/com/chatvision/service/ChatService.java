package com.chatvision.service;

import java.util.List;

import com.chatvision.exceptions.ChatException;
import com.chatvision.exceptions.UserException;
import com.chatvision.model.Chat;
import com.chatvision.model.dto.ChatDTO;

public interface ChatService {

	 Chat newChat(ChatDTO chat,int receiverUserId) throws ChatException, UserException;
	 Chat getChat(Integer Id) throws ChatException;
	 List<Chat> getAllChats() throws ChatException;
}
