package com.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test06/applicationContext.xml");
		
		Developer user3 = (Developer) factory.getBean("user3");
		Engineer user4 = factory.getBean("user4", Engineer.class);
		
		System.out.println(user3);
		System.out.println(user4);
		
		((ClassPathXmlApplicationContext) factory).close();
	}

}
