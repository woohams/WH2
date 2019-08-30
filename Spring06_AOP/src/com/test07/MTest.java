package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		
		ApplicationContext factory=new  ClassPathXmlApplicationContext("com/test07/hrhr.xml");
		
		MessageBean mb=factory.getBean("proxy",MessageBean.class);//사실은  messagebean이 아니다
		
		mb.sayHello();
		((ClassPathXmlApplicationContext) factory).close();
	}
	//HELLO 뽀로로 :target
	

}
