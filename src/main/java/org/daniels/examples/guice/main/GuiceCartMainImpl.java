package org.daniels.examples.guice.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.guice.cart.CreditCart;
import org.daniels.examples.guice.modules.SimpleGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class GuiceCartMainImpl implements GuiceCartMain {

    private final transient Log logger = LogFactory.getLog(GuiceCartMainImpl.class);

    CreditCart creditCart;

    @Inject
    public GuiceCartMainImpl(@Named("Fake") final CreditCart creditCart) {
        this.creditCart = creditCart;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SimpleGuiceModule());

        GuiceCartMainImpl cartMainImpl = injector.getInstance(GuiceCartMainImpl.class);

        cartMainImpl.testBind();
        cartMainImpl.getMessageFromCredit();
        
    }

    public void testBind() {
    	logger.info("testBind");
    }
    
    public void getMessageFromCredit(){
    	logger.info(creditCart.getMessage());
    }
}
