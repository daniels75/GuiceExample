package org.daniels.examples.spring.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.guice.main.GuiceCartMainImpl;
import org.daniels.examples.guice.modules.SpringModule;
import org.daniels.examples.guice.modules.SpringModuleWorks;
import org.daniels.examples.spring.loan.Loan;
import org.daniels.examples.spring.loan.LoanImpl;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
// pleas look at SpringModuleWorksMain example
public class SpringModuleInjectMain {

	private final transient Log logger = LogFactory.getLog(SpringModuleInjectMain.class);


    Loan loan;

    @Inject
    public SpringModuleInjectMain(final LoanImpl loan) {
        this.loan = loan;
    }

    // this also works fine!
//    @Inject
//    public SpringModuleInjectMain(@Named("loan") final LoanImpl loan) {
//        this.loan = loan;
//    }

    // but you CANNOT use following code!!!
    // WHY? because it LoanImpl is registered
    // but you can use 2) solution and the use following code and it will work
//    @Inject
//    public SpringModuleInjectMain(final Loan loan) {
//        this.loan = loan;
//    }
    
	public static void main(String[] args) {
		
		Injector injector = Guice.createInjector(new SpringModule());
		
		// 2) another way - via interface - you can change a constructor to final Loan loan;
		// like public SpringModuleInjectMain(final LoanImpl loan) {
		// and the call Injector injector = Guice.createInjector(new SpringModuleWorks());
		
		SpringModuleInjectMain main = injector.getInstance(SpringModuleInjectMain.class);
		
		main.callLoanMessage();
	}

	private void callLoanMessage(){
		logger.info(loan.getMessage());
	}

	

}

