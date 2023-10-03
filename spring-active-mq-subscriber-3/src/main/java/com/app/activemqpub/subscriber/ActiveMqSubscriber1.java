package com.app.activemqpub.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import jakarta.jms.Connection;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageConsumer;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import jakarta.jms.Topic;

@Component
public class ActiveMqSubscriber1 {

	@Autowired
	private JmsTemplate template;
	
//	@Bean
	void getMessageFromSubscriber() throws JMSException {
		
		Connection connection = template.getConnectionFactory().createConnection();
		connection.start();
		
//		Topic topic = template.getConnectionFactory().createConnection()
//		        .createSession(false, Session.AUTO_ACKNOWLEDGE)
//		        .createTopic("CustomTopic1");
		Topic topic = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
		        .createTopic("CustomTopic1");
		
		MessageConsumer subscriber = template.getConnectionFactory().createConnection().createSession().createConsumer(topic);
		Message msg = subscriber.receive();
		String response = ((TextMessage) msg).getText();
		System.err.println("RESPONSE: " + response);
	}
	
}
