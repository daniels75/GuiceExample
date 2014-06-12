package org.daniels.examples.spring.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.guice.modules.SpringModule;
import org.daniels.examples.guice.modules.SpringModuleWorks;
import org.daniels.examples.spring.loan.Loan;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class SpringModuleWorksMain {

	private final transient Log log = LogFactory.getLog(SpringModuleWorksMain.class);

	Loan loan;

	@Inject
	public SpringModuleWorksMain(final Loan loan) {
		this.loan = loan;
	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new SpringModuleWorks());

		SpringModuleWorksMain mainLoanBck = injector.getInstance(SpringModuleWorksMain.class);

		mainLoanBck.getMessageFromLoan();

	}

	public void getMessageFromLoan() {
		log.info(loan.getMessage());
	}
}
