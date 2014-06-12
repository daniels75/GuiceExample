package org.daniels.examples.spring.main;

import org.daniels.examples.spring.loan.Loan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		final Loan loan = (Loan)applicationContext.getBean("loan");
		
		System.out.println("Message from Spring injection: " + loan.getMessage());
	}

}
