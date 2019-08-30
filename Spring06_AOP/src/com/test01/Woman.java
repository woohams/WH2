package com.test01;

public class Woman {
	
	void classwork() {
		System.out.println("출석카드 찍기");	//ccc(공통 관심 사항)
		
		try {
			System.out.println("컴퓨터 켜서 쇼핑하기"); //컴퓨터 켜기:cc(핵심 관심 사항)
		} catch (Exception e) {
			System.out.println("쉬는 날");
		}finally {
			
			System.out.println("집에가기 ");
		}
		
	}
	
	

}
