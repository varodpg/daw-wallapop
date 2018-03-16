package com.practicaDaw.Dawllapop.controller;



import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.practicaDaw.Dawllapop.ChatMessage;

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
