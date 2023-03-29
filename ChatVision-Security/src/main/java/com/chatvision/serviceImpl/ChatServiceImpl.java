package com.chatvision.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatvision.exceptions.ChatException;
import com.chatvision.exceptions.UserException;
import com.chatvision.model.Chat;
import com.chatvision.model.User;
import com.chatvision.model.dto.ChatDTO;
import com.chatvision.repo.ChatRepo;
import com.chatvision.repo.UserRepo;
import com.chatvision.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatRepo chatRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Override
	public Chat newChat(ChatDTO chat,int receiverUserId) throws ChatException, UserException {
		
		Chat addNewChat = new Chat();
		addNewChat.setName(chat.getName());
		
		Optional<User> Optuser = userRepo.findById(receiverUserId);
		
		if(Optuser.isPresent())
		{
			User user = Optuser.get();
			addNewChat.getUsers().add(user);
			
			User sender = userServiceImpl.getLoginUser();
			addNewChat.getUsers().add(sender);
			
			chatRepo.save(addNewChat);
			
			return addNewChat;
			
		}
		
		throw new UserException("enter valid user id");
		
		
	}

	@Override
	public Chat getChat(Integer Id) throws ChatException {
		Optional<Chat> Optchat = chatRepo.findById(Id);
		
		if(Optchat.isPresent())
		{
			Chat chat = Optchat.get();
			return chat;
		}
		
		throw new ChatException("No chat found with this id : "+Id);
	}

	@Override
	public List<Chat> getAllChats() throws ChatException {
		
		List<Chat> chats = chatRepo.findAll();
		
		return chats;
	}

}
