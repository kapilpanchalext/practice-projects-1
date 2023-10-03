package com.app.activemq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

	private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
	
//	@JmsListener(destination = "tutorial.queue")
//	public void messageListener(String systemMessage) {
//	
//		logger.info("System Message, {}", systemMessage.toString());
//	}
}
