package com.chatvision.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatvision.exceptions.ChatException;
import com.chatvision.exceptions.MessageException;
import com.chatvision.exceptions.UserException;
import com.chatvision.model.Chat;
import com.chatvision.model.Message;
import com.chatvision.model.User;
import com.chatvision.model.dto.ChatDTO;
import com.chatvision.model.dto.MessageDTO;
import com.chatvision.repo.ChatRepo;
import com.chatvision.repo.MessageRepo;
import com.chatvision.repo.UserRepo;
import com.chatvision.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepo messageRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserServiceImpl uServiceImpl;
	
	@Autowired
	private ChatServiceImpl chatServiceImpl;
	
	@Override
	public Message newMessage(MessageDTO message) throws MessageException, ChatException, UserException {
		
		System.out.println(message.toString()+" ******************** before ");
		System.out.println(message.toString()+" ******************** before ");
		
		Message addNewMessage = new Message();
		
		addNewMessage.setText(message.getText());
		addNewMessage.setTimestamp(LocalDateTime.now());
		
		User user = uServiceImpl.getLoginUser();
		
		User receiver = userRepo.findByName(message.getReceiverUserEmail());
		
		System.out.println(message.toString()+" ******************** ");
		System.out.println(message.toString()+" ******************** ");
		
		if(receiver!=null)
		{
			String name = user.getName()+" to "+receiver.getName();
			
			ChatDTO chatDto = new ChatDTO();
			chatDto.setName(name);
			Chat messageChat = chatServiceImpl.newChat(chatDto, receiver.getId());
			
			addNewMessage.setChat(messageChat);
			
			addNewMessage.setSender(user);
			
			messageChat.getMessages().add(addNewMessage);
			
			return messageRepo.save(addNewMessage);
		}
		throw new UserException("User not found with this email : "+message.getReceiverUserEmail());
		
		
	}

	@Override
	public Message getMessage(Integer Id) throws MessageException {
		
		Optional<Message> opt = messageRepo.findById(Id);
		
		if(opt.isPresent())
		{
			return opt.get();
		}
		
		throw new MessageException("Message not found with this id : "+Id);
	}

	@Override
	public List<Message> getAllMessages() throws MessageException {
		
		return messageRepo.findAll();
	}

}
