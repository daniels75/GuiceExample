package org.daniels.examples.guice.modules;

import static com.google.inject.spring.SpringIntegration.fromSpring;

import org.daniels.examples.spring.loan.Loan;
import org.daniels.examples.spring.loan.LoanImpl;
import org.daniels.examples.spring.main.SimpleImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.spring.SpringIntegration;

public class SpringModule extends AbstractModule {
    @Override
    protected void configure() {
    	
//		final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//		RootBeanDefinition simpleImpl = new RootBeanDefinition(SimpleImpl.class);
//		RootBeanDefinition loanImpl = new RootBeanDefinition(LoanImpl.class);
//		beanFactory.registerBeanDefinition("simpleImpl", simpleImpl);
//		beanFactory.registerBeanDefinition("loan", loanImpl);

		ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SpringIntegration.bindAll(binder(), applicationContext1);
		// or 
		//SpringIntegration.bindAll(binder(), beanFactory);


    }
    
    

}


