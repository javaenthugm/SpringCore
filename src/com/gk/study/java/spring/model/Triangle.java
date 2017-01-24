package com.gk.study.java.spring.model;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;




public class Triangle implements Shape, ApplicationContextAware,BeanNameAware, InitializingBean,DisposableBean{
	
	/**
	 * BeanFacoty & Application Context
	 * Injecting values
	 */
	
	/*
	private String type;
	private int height;
		
	public Triangle(){
		System.out.println("No Argument Constructor");
	}
	
	public Triangle(String type){
		this.type=type;
		System.out.println("One Argument Constructor");
	}
	public Triangle(int height){
		this.height=height;
		System.out.println("One Argument Constructor");
	}
	
	public Triangle(String type,int height){
		this.type=type;
		this.height=height;
		System.out.println("Two Arguments Constructor");
	}


	public String getType() {
		return type;
	}
    
	public void setType(String type) {
		this.type = type;
	}
	
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void draw(){
		System.out.println(getType()+" Drawing Triangle "+getHeight());
	}*/
	
	
	/**
	 * Constructor Injection, Setter Injection,Inner Bean (no id), idref 
	 */
	
	/*
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
		
	public void draw(){
		System.out.println("Drawing Triangle {"+getPointA().getX()+","+getPointA().getY()+"},{"+getPointB().getX()+","+getPointB().getY()+"},{"+getPointC().getX()+","+getPointC().getY()+"}" );
	}
	*/
	/**
	 * Initialiazing Collections 
	 */

	/*
	private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void draw(){
		for(Point point:points){
			System.out.println("Drawing Triangle {"+point.getX()+","+point.getY()+"}");
		}
	}
	*/
	
	/**
	 * Auto Wiring (byname, bytype, constructor
	 */
	/*
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public void draw(){
		System.out.println("Drawing Triangle {"+getPointA().getX()+","+getPointA().getY()+"},{"+getPointB().getX()+","+getPointB().getY()+"},{"+getPointC().getX()+","+getPointC().getY()+"}" );
	}*/
	
	/**
	 * ApplicationContextAware, BeanNameAware, Bean Definition Inheritance 
	 */
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private ApplicationContext context = null;
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {

		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public void draw(){
		System.out.println("Drawing Triangle {"+getPointA().getX()+","+getPointA().getY()+"},{"+getPointB().getX()+","+getPointB().getY()+"},{"+getPointC().getX()+","+getPointC().getY()+"}" );
	}
	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean Name -"+beanName);
	}
	@Override
	public void setApplicationContext(ApplicationContext cntxt)
			throws BeansException {
		this.context=cntxt;
		
	}
	
	public void printApplnCntxPointInfo(){
		Point cntxP = (Point)context.getBean("cntxtAware");
		System.out.println("Context Aware Point:{"+cntxP.getX()+","+cntxP.getY()+"}");
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Bean is destroyed");		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean is created --- Hello Triangle Bean");
	}
	
	//This method is defined in the 'spring.xml'
	public void myInitMethod(){
		System.out.println("My initMethod() is called");
	}
	
	//This method is defined in the 'spring.xml'
	public void myDestroyMethod(){
		System.out.println("My destroyMethod() is called");
	}
	
	

}
