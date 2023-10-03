package com.app.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringActiveMqSubscriber2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringActiveMqSubscriber2Application.class, args);
	}

}
