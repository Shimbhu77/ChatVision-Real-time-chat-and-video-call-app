package com.chatvision.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatvision.exceptions.ChatException;
import com.chatvision.exceptions.MessageException;
import com.chatvision.exceptions.UserException;
import com.chatvision.model.Chat;
import com.chatvision.model.Message;
import com.chatvision.model.dto.ChatDTO;
import com.chatvision.model.dto.MessageDTO;
import com.chatvision.service.ChatService;
import com.chatvision.service.MessageService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class MessageController {

	@Autowired
	private MessageService mService;
	
	@Autowired
	private ChatService cService;
	
	@PostMapping("/my-account/messages/send-message")
	public ResponseEntity<Message> sendNewMessage(@Validated @RequestBody MessageDTO dto) throws MessageException, ChatException, UserException
	{
		Message message = mService.newMessage(dto);
		
		return new ResponseEntity<Message>(message,HttpStatus.CREATED);
	}
	
	@GetMapping("/my-account/messages/{Id}")
	public ResponseEntity<Message> getMessage(@PathVariable("Id") Integer Id) throws MessageException, ChatException, UserException
	{
		Message message = mService.getMessage(Id);
		
		return new ResponseEntity<Message>(message,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/my-account/messages")
	public ResponseEntity<List<Message>> getAllMessages() throws MessageException, ChatException, UserException
	{
		List<Message> message = mService.getAllMessages();
		
		return new ResponseEntity<List<Message>>(message,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/my-account/chats/send-chat/{Id}")
	public ResponseEntity<Chat> sendNewChat(@Validated @RequestBody ChatDTO dto,@PathVariable("Id") Integer Id) throws MessageException, ChatException, UserException
	{
		Chat message = cService.newChat(dto,Id);
		
		return new ResponseEntity<Chat>(message,HttpStatus.CREATED);
	}
	
	@GetMapping("/my-account/chats/{Id}")
	public ResponseEntity<Chat> getChat(@PathVariable("Id") Integer Id) throws MessageException, ChatException, UserException
	{
		Chat message = cService.getChat(Id);
		
		return new ResponseEntity<Chat>(message,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/my-account/chats")
	public ResponseEntity<List<Chat>> getAllChats() throws MessageException, ChatException, UserException
	{
		List<Chat> message = cService.getAllChats();
		
		return new ResponseEntity<List<Chat>>(message,HttpStatus.ACCEPTED);
	}
}
