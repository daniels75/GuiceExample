package org.daniels.examples.guice.main;

import static org.daniels.examples.constants.Constants.JDBC;
import static org.daniels.examples.constants.Constants.TIMEOUT;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.constants.Constants;
import org.daniels.examples.guice.cart.CreditCart;
import org.daniels.examples.guice.cart.PayPal;
import org.daniels.examples.guice.modules.SimpleGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class GuiceUntargettedBindingsExampleMain implements GuiceCartMain {

    private final transient Log logger = LogFactory.getLog(GuiceUntargettedBindingsExampleMain.class);

    String jdbcStr;
    Integer timeout;

    @Inject
    public GuiceUntargettedBindingsExampleMain(@Named(JDBC) final String jdbcStr,
                                    @Named(TIMEOUT) final Integer timeout) {
        this.jdbcStr = jdbcStr;
        this.timeout = timeout;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SimpleGuiceModule());

        GuiceUntargettedBindingsExampleMain main = injector.getInstance(GuiceUntargettedBindingsExampleMain.class);

        main.showBindings();

    }

    private void showBindings() {
        logger.info("jdbcStr: " + jdbcStr);
        logger.info("timeout: " + timeout);
    }
}
