package com.test02;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/test02/beans.xml");
		
		Address hong = (Address) beans.getBean("hong");	// beans.xml에서 아무 값도 안넣어주면 (value) 기본생성자에 값이 출력된다 !!
		Address lee = (Address) beans.getBean("lee");
		Address kim = (Address) beans.getBean("kim");
		
		System.out.println(hong);
		System.out.println(lee);
		System.out.println(kim);
		
		JobAddress jHong = beans.getBean("jHong", JobAddress.class);	// 안에 원하는 형태를 넣어주면 입력한 형태로 자동으로 변환하여 나오기도 함! 앞에서 바꾸든 안에서 바꾸든 편한대로 형변환 하여 사용하자 !
		JobAddress jLee = beans.getBean("jLee", JobAddress.class);	// beans.xml에서 constructor-arg의 ref로 해당 bean의 id를 참조하여 값이 대입된다 ! (그냥 value로 값을 넣는 방법과 ref로 참조해와서 값을 넣는 방법 두가지가 있다)
		JobAddress jKim = (JobAddress) beans.getBean("jKim");
				
		System.out.println();
		System.out.println(jHong);
		System.out.println(jLee);
		System.out.println(jKim);
		
		((ClassPathXmlApplicationContext)beans).close();
	}
}



