package com.capgemini.app.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
	
	
	public Integer add(int num1, int num2) {
		Logger logger = Logger.getLogger( Calculator.class.getName() );
		int result=num1+num2;
		logger.info("result is"+result);
		return result;
		
		
	}

}
