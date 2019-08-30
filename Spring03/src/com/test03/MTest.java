package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		Developer you = beans.getBean("you", Developer.class);
		Engineer kang = (Engineer) beans.getBean("kang");
		
		System.out.println(you);
		System.out.println(kang);
		
		((ClassPathXmlApplicationContext) beans).close();
	}

}
