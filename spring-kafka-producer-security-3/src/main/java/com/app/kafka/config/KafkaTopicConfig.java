package com.app.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	NewTopic loginTopic() {
		return TopicBuilder.name(KafkaTopicConstants.USER_LOGIN).partitions(3).replicas(1).build();
	}

	@Bean
	NewTopic loginResponseTopic() {
		return TopicBuilder.name(KafkaTopicConstants.USER_LOGIN_RESPONSE).partitions(3).replicas(1).build();
	}
}
