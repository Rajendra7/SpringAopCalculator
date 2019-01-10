package com.capgemini.app;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.capgemini.app.service.Calculator;

/**
 * 
 * @author rajendra
 *
 */

public class App 
{
    public static void main( String[] args )
    {
    	//Logger logger = Logger.getLogger( App.class.getName() );
        ApplicationContext context =new ClassPathXmlApplicationContext("context.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.add(100, 200);
        
    }
}
