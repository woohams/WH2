package com.test08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/test08/beans.xml");
		
		SamsongTV TV1 = (SamsongTV) beans.getBean("TV1");
		TV1.powerOn();
		TV1.powerOff();
		TV1.volumUp();
		TV1.volumDown();
		
		LzTV TV2 = beans.getBean("TV2", LzTV.class);
		TV2.powerOn();
		TV2.powerOff();
		TV2.volumUp();
		TV2.volumDown();
		
		((ClassPathXmlApplicationContext)beans).close();
	}
	

}
