package com.gk.study.java.spring.eventlisteners;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener  implements ApplicationListener<DrawEvent>{

	@Override
	public void onApplicationEvent(DrawEvent event) {
		System.out.println("Inside");
		System.out.println(event.toString());		
	}

	

}
