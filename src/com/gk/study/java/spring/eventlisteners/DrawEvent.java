package com.gk.study.java.spring.eventlisteners;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent {
	
	public DrawEvent(Object source){
		super(source);
	}
	
	public String toString(){
		return "Message from the Draw Event";
	}

}
