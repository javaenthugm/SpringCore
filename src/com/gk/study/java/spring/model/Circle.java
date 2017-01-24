package com.gk.study.java.spring.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.gk.study.java.spring.eventlisteners.DrawEvent;

@Component
//@Controller
//@Service
public class Circle implements Shape,ApplicationEventPublisherAware {
	private Point center;
	
	@Autowired
	private MessageSource messageSource;
	
	private ApplicationEventPublisher eventPublisher;
	
	
	

	public ApplicationEventPublisher getEventPublisher() {
		return eventPublisher;
	}

	public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource= messageSource;
	}

	public Point getCenter() {
		return center;
	}

	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		System.out.println("Drawing Circle");
		//System.out.println("Point ("+center.getX()+","+center.getY()+")");
		System.out.println(messageSource.getMessage("draw.message", new Object[]{center.getX(),center.getY()}, "Default parameter Message", null));
		System.out.println(messageSource.getMessage("usingmessagesource", null, "Default Message", null));		
		eventPublisher.publishEvent(new DrawEvent(this));
	}
	
	@PostConstruct
	public void initializeCircle(){
		System.out.println("The Circle is initialized");
	}
	
	@PreDestroy
	public void destroyCircle(){
		System.out.println("Circle is destryed");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.eventPublisher = publisher;
	}

}
