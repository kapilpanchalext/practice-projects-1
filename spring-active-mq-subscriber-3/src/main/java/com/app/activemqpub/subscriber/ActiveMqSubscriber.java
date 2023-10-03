package com.app.activemqpub.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageConsumer;
import jakarta.jms.MessageListener;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import jakarta.jms.Topic;

//@Component
public class ActiveMqSubscriber { //implements MessageListener

//	@Autowired
//	private JmsTemplate template;
//	
//	@Bean
//	@Override
//	public void onMessage(Message message){
//		TextMessage textMessage = (TextMessage) message;
//		try {
//			String topicName = textMessage.getStringProperty("CustomTopic1");
//			System.err.println("TOPIC NAME: " + topicName);
//		} catch (JMSException e) {
//			e.printStackTrace();
//		}
//		System.err.println("MESSAGE FROM TOPIC: " + textMessage);
//		
//		try {
//			Topic topic = template.getConnectionFactory().createConnection()
//			        .createSession(false, Session.AUTO_ACKNOWLEDGE)
//			        .createTopic("CustomTopic1");
//			
//			MessageConsumer subscriber = template.getConnectionFactory().createConnection().createSession().createConsumer(topic);
//			Message msg = subscriber.receive();
//			String response = ((TextMessage) msg).getText();
//			System.err.println("RESPONSE: " + response);
//		} catch (JMSException e) {
//			e.printStackTrace();
//		}
//	}
}
