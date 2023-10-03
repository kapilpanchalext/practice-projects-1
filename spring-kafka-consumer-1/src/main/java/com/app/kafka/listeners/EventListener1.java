package com.app.kafka.listeners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.app.kafka.events.EventHandler1;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EventListener1 {

	@EventListener(classes = {EventHandler1.class})
	public void onEventTriggerAction1(EventHandler1 event) {
		log.info("EVENT 1 HANDLER: " + event.getTimestamp() + " ms");
		System.err.println("EVENT 1 HANDLER: " + event.getTimestamp() + " ms");
	}
}
