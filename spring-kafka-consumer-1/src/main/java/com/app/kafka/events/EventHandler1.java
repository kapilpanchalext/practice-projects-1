package com.app.kafka.events;

import org.springframework.context.ApplicationEvent;

public class EventHandler1 extends ApplicationEvent{

	private static final long serialVersionUID = 867685519852177280L;

	public EventHandler1(Object source) {
		super(source);		
	}
}