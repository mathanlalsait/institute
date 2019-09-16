package com.candid.sma.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BatchLoggingAspect {

	@Before("execution(public * com.candid.sma.controller.BatchController.createBatch(..))")
	public void addBeforeLogging(JoinPoint jp) throws Throwable {
		System.out.println("Log Before: " + jp.getThis().toString());
	}
}
