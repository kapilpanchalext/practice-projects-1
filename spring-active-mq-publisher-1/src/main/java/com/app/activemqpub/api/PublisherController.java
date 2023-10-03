package com.app.activemqpub.api;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.Topic;


@RestController
@RequestMapping(path = "/api/v1")
public class PublisherController {
	
	@Autowired
	private JmsTemplate template;

	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHello() throws URISyntaxException, Exception{
		
		Topic topic = template.getConnectionFactory().createConnection()
	            .createSession(false, Session.AUTO_ACKNOWLEDGE)
	            .createTopic("CustomTopic1");
				
		template.send(topic, new MessageCreator() {			
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage("Topic 2");
//				message.setStringProperty("CustomTopic1", topic.getTopicName());
				return message;
			}
		});
		return ResponseEntity.status(HttpStatus.OK).body("Success");
	}
}