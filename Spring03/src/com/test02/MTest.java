package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
	
//		BirthDto right = factory.getBean("right", BirthDto.class);
//		System.out.println(right);

		BirthDto right = factory.getBean("right", BirthDto.class);
		BirthDto left = factory.getBean("left", BirthDto.class);
		BirthDto me = (BirthDto) factory.getBean("me");
		
		System.out.println(right);
		System.out.println(left);
		System.out.println(me);
		
		// 1. 왼쪽 짝궁의 이름과 생일을 setter를 사용하여 값을 주입하고 출력하라
		// 2. 오른쪽 짝궁의 이름과 생일을 생성자를 사용하여 값을 주입라고 출력하라
		// 3. 내 이름과 생일을 (마음대로) 값을 주입하고 출력하라
		
		((ClassPathXmlApplicationContext) factory).close();
		
	}

}
