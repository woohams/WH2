package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext user = new ClassPathXmlApplicationContext("com/test03/user.xml");
		
		UserService service = user.getBean("service", UserServiceImpl.class);
		UserDto dto = user.getBean("dto", UserDto.class);
		System.out.println(dto.getName());
		System.out.println(dto.getMyDate());
		
		service.addUser(dto);

		// 1. user.xml에서 UserDto 객체를 만들자
		
		// 2. MTest에서 service.addUser() argument로 1번에서 만든 객체를 넣어주자
		
		((ClassPathXmlApplicationContext) user).close();
	}

}
