package com.example.spring_controller_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_controller_basic.dto.ChatMessage;

@RestController
public class ChatController {
	@Autowired 
	SimpMessagingTemplate template;
	
	@MessageMapping("/send")
    public void receiveTo(ChatMessage message, SimpMessageHeaderAccessor headerAccessor) {
		template.convertAndSend("/receivePoint/receive", message);
    }
}
