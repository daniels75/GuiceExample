package org.daniels.examples.spring.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.guice.modules.SpringModule;
import org.daniels.examples.spring.loan.Loan;
import org.daniels.examples.spring.loan.LoanImpl;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.google.inject.spring.SpringIntegration;

public class SpringModuleMain {

	private final transient Log logger = LogFactory
			.getLog(SpringModuleMain.class);

	public SpringModuleMain() {

	}

	public static void main(String[] args) {
		SpringModuleMain guiceMain = new SpringModuleMain();
		guiceMain.loadSimpleImpleViaInjection();
		
		//guiceMain.loadLoan();
		

	}

	
	private void loadSimpleImpleViaInjection(){
		Injector injector = Guice.createInjector(new SpringModule());

		Key<SimpleImpl> simpleImplKey = Key.get(SimpleImpl.class, Names.named("simpleImpl"));

		Key<LoanImpl> loanKey = Key.get(LoanImpl.class, Names.named("loan"));
		
		logger.info("not null: " + injector.getInstance(simpleImplKey) != null );
		logger.info("equals: " + (injector.getInstance(simpleImplKey) == injector.getInstance(simpleImplKey)));
		logger.info(">>> SimpleImpl Message: " + injector.getInstance(simpleImplKey).getMessage());
		logger.info(">>> Loan Message: " + injector.getInstance(loanKey).getMessage());
		
		
		
//		Loan loanImpl = injector.getInstance(LoanImpl.class);
//		SimpleImpl simpleImpl = injector.getInstance(SimpleImpl.class);
//		logger.info(">>> Message: " + simpleImpl.getMessage());
//		logger.info(">>> Message from Loan: " + loanImpl.getMessage());
		
	}
	
	private void loadSimpleImpl(){
		final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		RootBeanDefinition singleton = new RootBeanDefinition(SimpleImpl.class);
		beanFactory.registerBeanDefinition("simpleImpl", singleton);

		Injector injector = Guice.createInjector(new AbstractModule() {
			protected void configure() {
				SpringIntegration.bindAll(binder(), beanFactory);
			}
		});

		Key<SimpleImpl> singletonKey = Key.get(SimpleImpl.class,
				Names.named("simpleImpl"));

		logger.info("not null: " + injector.getInstance(singletonKey) != null );
		logger.info("equals: " + (injector.getInstance(singletonKey) == injector.getInstance(singletonKey)));
		logger.info("Message: " + injector.getInstance(singletonKey).getMessage());
	}

	
	private void loadLoan() {
		Injector injector = Guice.createInjector(new SpringModule());
		Loan loan = injector.getInstance(Loan.class);

		logger.info(loan.getMessage());
	}


}

