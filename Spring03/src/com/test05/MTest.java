package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/test05/beans.xml");
		
		Developer user1 = (Developer) beans.getBean("user1");
		Engineer user2 = beans.getBean("user2", Engineer.class);
		
		System.out.println(user1);
		System.out.println(user2);
		
		((ClassPathXmlApplicationContext) beans).close();
	}
	
}
