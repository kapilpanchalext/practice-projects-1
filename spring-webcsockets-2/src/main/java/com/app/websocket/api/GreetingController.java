package com.app.websocket.api;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.app.websocket.bean.Greeting;
import com.app.websocket.bean.HelloMessage;

@Controller
public class GreetingController {

	@MessageMapping(value = "/hello")
	@SendTo(value = "/topic/greetings")
	public Greeting greeting(HelloMessage message) throws InterruptedException {
	
//		Thread.sleep(1000);
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}
}
