package com.test01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAdvice {

	@Pointcut("execution(public * com.test01.Person.sayName(..))")
	public void myClass() {
		
	}
	
	@Before("myClass()")
	public void beforeSaying(JoinPoint join) {
		System.out.println("당신의 이름은 무엇 입니까?");
	}
	
	@After("myClass()")
	public void afterSaying(JoinPoint join) {
		System.out.println("이름이 멋지시네요");
	}
	
	@AfterReturning("myClass()")
	public void afterReturnSaying(JoinPoint join) {
		System.out.println("직업이 무엇입니까?");
	}
	
}
