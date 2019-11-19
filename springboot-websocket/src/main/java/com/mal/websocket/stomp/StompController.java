package com.mal.websocket.stomp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.socket.config.WebSocketMessageBrokerStats;

@Controller
public class StompController {
	
	@Autowired
	private SimpMessagingTemplate template;
	@Autowired
	private WebSocketMessageBrokerStats stats;
	@GetMapping("/stomp.do")
	public void sendAgentMessage() {
		System.out.println("/stomp.do");
		template.setSendTimeout(2);
		template.convertAndSend("/topic/server_info","{\"name\":\"hello\"}");
	}

}
