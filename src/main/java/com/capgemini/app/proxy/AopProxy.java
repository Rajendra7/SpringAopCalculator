package com.capgemini.app.proxy;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopProxy {
	Logger logger = Logger.getLogger(AopProxy.class.getName());

	@Before("execution(* com.capgemini.app.service.Calculator.*(..))")
	public void log1() {
		logger.info("Before -Logging the method");
	}

	@After("execution(* com.capgemini.app.service.Calculator.*(..))")
	public void log2() {
		logger.info("After -Logging the method");
	}

	@Around("execution(* com.capgemini.app.service.Calculator.*(..))")
	public void log3(ProceedingJoinPoint pjp) throws Throwable {

		logger.info("Before -Logging the method");
		logger.info("Function name is: " + pjp.getSignature());
		logger.info("parameters are :");
		Object[] params = pjp.getArgs();
		Object retVal = null;
		for (int i = 0; i < params.length; i++) {
			logger.info("Parameter value at index " + i + " is" + params[i]);
			if ((Integer) params[i] != 0 && (Integer) params[i + 1] != 0) {
				retVal = pjp.proceed();
			} else {
				logger.info("Invalid Input !!!");
			}
		}

		logger.info("After -Logging the method");

	}

	@AfterReturning(pointcut = "execution(* com.capgemini.app.service.Calculator.add(..))", returning = "retVal")
	public void log4(Integer retVal) {
		logger.info("" + retVal);
	}

}
