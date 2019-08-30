package com.test04;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Myaspect {
	
	
	@Before("execution(public * *(..))")
	public void before() {
		
	}
	@After("execution(public * *(..))")
	public void after() {
		System.out.println("집에 가기");
		
		
	}
}
