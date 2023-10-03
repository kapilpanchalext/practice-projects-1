package com.app.activemq.listener;

import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;

@Component
public class Listener {

	@JmsListener(destination = "tutorial1.queue")
//	@SendTo("outbound.queue")
	public void receiveMessage(final String message) throws JMSException{
		
		System.err.println("JMS LISTENER FROM MICROSERVICE 2: " + message);
//		String messageData = null;
//		
//		System.err.println("RECEIVED MESSAGE FROM LISTENER: " + jsonMessage);
//		String response = null;
//		
//		if(jsonMessage instanceof TextMessage) {
//			TextMessage textMessage = (TextMessage) jsonMessage;
//			messageData = textMessage.getText();
////			Map map = new Gson().f
//			response = "Hello " + messageData;			
//		}
//		System.err.println("LISTENER: " + messageData);
//		return response;
	}
}