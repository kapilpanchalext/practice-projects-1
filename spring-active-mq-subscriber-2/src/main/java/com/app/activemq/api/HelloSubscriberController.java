package com.app.activemq.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class HelloSubscriberController {

private final Logger logger = LoggerFactory.getLogger(HelloSubscriberController.class);
	
	@Autowired
	private JmsTemplate template;
	
	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHello(){
		logger.info("getHello");
//		template.convertAndSend("outbound.queue", "getHelloFromOutboundQueue");
		String outboundMessage = (String) template.receiveAndConvert("outbound.queue");
		System.err.println("MESSAGE FROM ACTIVEMQ LISTENER: " + outboundMessage);
		String inboundMessage = (String) template.receiveAndConvert("outbound.queue");
		System.err.println("MESSAGE FROM ACTIVEMQ LISTENER: " + inboundMessage);		
		return ResponseEntity.status(HttpStatus.OK).body("Success");
	}
}
