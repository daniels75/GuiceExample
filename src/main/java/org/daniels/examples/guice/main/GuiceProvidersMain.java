package org.daniels.examples.guice.main;

import static org.daniels.examples.constants.Constants.JDBC;
import static org.daniels.examples.constants.Constants.TIMEOUT;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.constants.Constants;
import org.daniels.examples.guice.cart.CreditCart;
import org.daniels.examples.guice.cart.PayPal;
import org.daniels.examples.guice.modules.SimpleGuiceModule;
import org.daniels.examples.guice.providers.TransactionFooLog;
import org.daniels.examples.guice.providers.TransactionLog;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class GuiceProvidersMain implements GuiceCartMain {

    private final transient Log logger = LogFactory.getLog(GuiceProvidersMain.class);

    TransactionLog transactionLog;
    TransactionFooLog transactionFooLog;

    @Inject
    public GuiceProvidersMain(final TransactionLog transactionLog, final TransactionFooLog transactionFooLog) {
        this.transactionLog = transactionLog;
        this.transactionFooLog = transactionFooLog;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SimpleGuiceModule());

        GuiceProvidersMain main = injector.getInstance(GuiceProvidersMain.class);

        main.testInjection();

    }

    private void testInjection() {
        logger.info(transactionLog.message());
        logger.info(transactionFooLog.message());
    }
}
