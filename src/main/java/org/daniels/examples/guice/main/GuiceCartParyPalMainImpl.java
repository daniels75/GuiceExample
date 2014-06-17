package org.daniels.examples.guice.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.guice.cart.CreditCart;
import org.daniels.examples.guice.cart.PayPal;
import org.daniels.examples.guice.modules.SimpleGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class GuiceCartParyPalMainImpl implements GuiceCartMain {

    private final transient Log logger = LogFactory.getLog(GuiceCartParyPalMainImpl.class);

    CreditCart creditCart;

    @Inject
    public GuiceCartParyPalMainImpl(@PayPal final CreditCart creditCart) {
        this.creditCart = creditCart;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SimpleGuiceModule());

        GuiceCartParyPalMainImpl cartMainImpl = injector.getInstance(GuiceCartParyPalMainImpl.class);

        cartMainImpl.getMessageFromCredit();
        
    }


    public void getMessageFromCredit(){
    	logger.info(creditCart.getMessage());
    }
}
