package com.app.activemq.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.activemq.model.SystemMessage;

@RestController
@RequestMapping(path = "/api/v1")
public class HelloController {

	@Autowired
	private JmsTemplate template;

//	@GetMapping(path = "/hello")
//	public ResponseEntity<String> getHello(){
//		logger.info("getHello");
//		template.convertAndSend("outbound.queue", "getHelloFromOutboundQueue-Message1");
//		template.convertAndSend("inbound.queue","received message from inbound.queue");
//		String outboundMessage = (String) template.receiveAndConvert("outbound.queue");
//		String inboundMessage = (String) template.receiveAndConvert("inbound.queue");
//		System.err.println("MESSAGE FROM ACTIVEMQ OUTBOUND: " + outboundMessage);
//		System.err.println("INBOUND MESSAGE: " + inboundMessage);
//		return ResponseEntity.status(HttpStatus.OK).body("Success");
//	}
	
	@PostMapping(path = "/publish-message")
	public ResponseEntity<String> getHello(@RequestBody SystemMessage systemMessage){
		
		try {
			template.convertAndSend("tutorial1.queue", systemMessage.toString());
			return ResponseEntity.status(HttpStatus.OK).body("Success");
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body("Failure");
		}
	}
}