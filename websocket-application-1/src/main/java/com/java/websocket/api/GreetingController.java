package com.java.websocket.api;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

import com.java.websocket.model.Greeting;
import com.java.websocket.model.HelloMessage;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting (HelloMessage message) throws InterruptedException {
		Thread.sleep(1000);
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}
	
	@MessageMapping("/text")
	@SendTo("/topic/updates")
	public String processText(String message) {
		return message;
	}
}
