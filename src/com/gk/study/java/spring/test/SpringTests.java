package com.gk.study.java.spring.test;

//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
//import org.springframework.core.io.FileSystemResource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.gk.study.java.spring.model.Shape;
import com.gk.study.java.spring.model.Triangle;


public class SpringTests {

	public static void main(String args[]) {
		//Traingle triangle = new Triangle();
		
	    //useBeanFactory();
		useApplicationContext();
		
	}
	
	private static void useBeanFactory(){
		System.out.println("Using BeanFactory to create the bean");
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/spring.xml"));
		Triangle triangle = (Triangle) factory.getBean("triangle");
		triangle.draw();
	}
	
	private static void useApplicationContext(){

		System.out.println("Using Application Context to create the bean");
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// this is required to call the callBack methods when the bean is created or destroyed
		context.registerShutdownHook(); 
		
		//Refereing bean Alias
		Shape shape = (Shape) context.getBean("triangle");
		//Triangle shape = (Triangle) context.getBean("triangle");
		//shape.getPointA().setX(5);
		shape.draw();
		//shape.printApplnCntxPointInfo();
		
		
	
	}

}
