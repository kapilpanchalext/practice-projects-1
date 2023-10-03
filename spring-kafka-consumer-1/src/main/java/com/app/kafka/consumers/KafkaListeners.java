package com.app.kafka.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.app.kafka.bean.StudentBean;
import com.app.kafka.events.EventHandler1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaListeners {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	public static final String TOPIC_NAME = "login.user";	

	@KafkaListener(topics = {TOPIC_NAME, TOPIC_NAME}, groupId = "groupId")
	public void listeners(String studentBean) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		StudentBean studentBeanObject = objectMapper.readValue(studentBean, StudentBean.class);
		
		System.err.println("Received Message: " + studentBeanObject);
				
		log.info("Received Message: " + studentBeanObject);
		EventHandler1 event = new EventHandler1(this);		
		publisher.publishEvent(event);
	}
}
