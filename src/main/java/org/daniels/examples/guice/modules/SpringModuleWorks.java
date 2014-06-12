package org.daniels.examples.guice.modules;

import static com.google.inject.spring.SpringIntegration.fromSpring;

import org.daniels.examples.spring.loan.Loan;
import org.daniels.examples.spring.loan.LoanImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.inject.AbstractModule;
import com.google.inject.spring.SpringIntegration;

public class SpringModuleWorks extends AbstractModule {
    @Override
    protected void configure() {

    	ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        bind(BeanFactory.class).toInstance(applicationContext1);
        
        bind(Loan.class).toProvider(SpringIntegration.fromSpring(Loan.class, "loan"));

        
        // solution 2
    	// spring
//		final DefaultListableBeanFactory applicationContext = new DefaultListableBeanFactory();
//		RootBeanDefinition loan = new RootBeanDefinition(LoanImpl.class);
//		applicationContext.registerBeanDefinition("loan", loan);
//		// bind spring -> guice
//		bind(BeanFactory.class).toInstance(applicationContext);
//		bind(Loan.class).toProvider(fromSpring(Loan.class, "loan"));
		
    }
    
    
    public void solutions(){
    	// soluciton 1
    	ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");
	    bind(BeanFactory.class).toInstance(applicationContext1);
	    bind(Loan.class).toProvider(SpringIntegration.fromSpring(Loan.class, "loan"));
    	
    	
    	// solution 2
    	// spring
		final DefaultListableBeanFactory applicationContext = new DefaultListableBeanFactory();
		RootBeanDefinition loan = new RootBeanDefinition(LoanImpl.class);
		applicationContext.registerBeanDefinition("loan", loan);
		// bind spring -> guice
		bind(BeanFactory.class).toInstance(applicationContext);
		bind(Loan.class).toProvider(fromSpring(Loan.class, "loan"));
		
    }
}


