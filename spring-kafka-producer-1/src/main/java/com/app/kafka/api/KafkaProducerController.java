package com.app.kafka.api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.kafka.bean.StudentBean;
import com.app.kafka.config.KafkaTopicConfig;

@RestController
@RequestMapping(path = "/api/v1")
public class KafkaProducerController {

	@Autowired
	private KafkaTemplate<String, Object> template;
	
	@GetMapping(path = "/send-message")
	public ResponseEntity<String> sendKafkaMessage(@RequestBody StudentBean studentBean) throws InterruptedException, ExecutionException{
		
		StringBuilder KEY = new StringBuilder();		
		KEY.append(studentBean.getStudentId());
		KEY.append(":");
		KEY.append(studentBean.getFirstName());
		KEY.append(":");
		KEY.append(studentBean.getLastName());		
		
		CompletableFuture<SendResult<String,Object>> future = template.send(KafkaTopicConfig.TOPIC_NAME, KEY.toString(), studentBean);
		future.thenAccept((element) -> {
			System.err.println("ELEMENT: " + element.toString());
		});
		
		future.get();
		return ResponseEntity.status(HttpStatus.OK).body("Successful");
	}
}
