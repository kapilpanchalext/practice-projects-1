package com.java.websocket.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.websocket.model.TextMessageDTO;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:9001")
@RequiredArgsConstructor
@EnableScheduling
public class GreetingController {
	
	@Autowired
	private final SimpMessagingTemplate template;
	private int counter = 0;

//	@MessageMapping("/hello")
//	@SendTo("/topic/greetings")
//	public Greeting greeting (HelloMessage message) throws InterruptedException {
//		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
//	}

	@PostMapping("/send")
	public ResponseEntity<Void> sendMessage(@RequestBody TextMessageDTO textMessageDTO) {
//		template.convertAndSend("/topic/message", textMessageDTO);
//		return new ResponseEntity<>(HttpStatus.OK);
		System.err.println("Message received in /send: " + textMessageDTO);
	    template.convertAndSend("/topic/greetings", textMessageDTO);
	    System.err.println("Message sent to /topic/greetings");
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@MessageMapping("/receive")
//	public void receiveMessage(@Payload TextMessageDTO textMessageDTO) {
//		System.err.println("RECEIVE MESSAGE: " + textMessageDTO);
//	}
//	
//	@MessageMapping("/hello")
//	@SendTo("/topic/greetings")
//	public TextMessageDTO broadcastMessage(@Payload TextMessageDTO textMessageDTO) {
//		return textMessageDTO;
//	}
//	
//	@MessageMapping("/hello")
//	@SendTo("/topic/greetings")
//	public TextMessageDTO broadcastMessage(@Payload TextMessageDTO textMessageDTO) {
//		System.err.println("1 Message received in /send: " + textMessageDTO);
//	    template.convertAndSend("/topic/greetings", textMessageDTO);
//	    System.err.println("1 Message sent to /topic/greetings");
//		return textMessageDTO;
//	}
//	
	// Method to publish "HelloWorld" message every 1 second
    @Scheduled(fixedRate = 1000)
    public void publishPeriodicMessages() {
        TextMessageDTO message = new TextMessageDTO();
        message.setMessage(String.valueOf(++counter));
        System.err.println("Publishing periodic message: " + message);
        template.convertAndSend("/topic/greetings", message);
    }
}
