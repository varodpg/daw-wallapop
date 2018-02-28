package com.practicaDaw.Dawllapop.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.practicaDaw.Dawllapop.ChatMessage;
import com.practicaDaw.Dawllapop.Entities.User;

@Controller
public class ChatController {
	@MessageMapping("/send/{user}")
    @SendTo("/topic/recieve/{user}")
    public String[] greeting(ChatMessage chatMessage) throws Exception {		
		//Thread.sleep(1000);	
		String [] response = new String[2];
		response[0] = chatMessage.getUsername();
		response[1] = chatMessage.getMessage();
        return response;
    }
}
