package com.app.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	public static final String TOPIC_NAME = "login.user";

	@Bean
	NewTopic loginTopic() {
		return TopicBuilder.name(TOPIC_NAME).partitions(3).replicas(1).build();
	}
}
