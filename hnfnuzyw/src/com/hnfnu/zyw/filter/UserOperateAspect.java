package com.hnfnu.zyw.filter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component("userOperateAspect")
@Aspect
public class UserOperateAspect {
	
	@After("execution(* com.hnfnu.zyw.service..*.*(..))")
	public void logTest(JoinPoint jp){
		String[] fullClassName = jp.getTarget().getClass().getName().split("\\.");
		String className = fullClassName[fullClassName.length-1];
		className = className.substring(0, className.indexOf("ServiceImpl"));
		if(className.contains("Vo")) {
			className = className.substring(0, className.length()-3);
		}
		if(className.contains("Join")) {
			String[] a = className.split("[A-Z]");
			for(String b : a) {
				System.out.println(b);
			}
		}
		String methodName = jp.getSignature().getName();
		System.out.println(className);
		System.out.println(methodName);
		//System.out.println(jp.getTarget().getClass());
		//System.out.println(jp.getSignature().getName());
	}
}