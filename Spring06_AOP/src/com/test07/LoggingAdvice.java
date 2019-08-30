package com.test07;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		String methodName=invocation.getMethod().getName();
		StopWatch sw=new StopWatch();
		sw.start(methodName);
		
		System.out.println("[LOG]METHOD:"+ methodName+"is calling");
		Object obj=invocation.proceed();//target
		sw.stop();
		
		System.out.println("[LOG]METHOD:"+methodName+"was Called");
		System.out.println("[LOG]처리시간:"+sw.getTotalTimeMillis()/1000+"초");
		
		
		
		return obj;
	}
	
	

}
