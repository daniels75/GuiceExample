package org.daniels.examples.guice.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.guice.cart.CreditCart;
import org.daniels.examples.guice.modules.SimpleGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class CartMainImpl implements CartMain {

    private final transient Log log = LogFactory.getLog(CartMainImpl.class);

    CreditCart creditCart;

    @Inject
    public CartMainImpl(@Named("Fake") final CreditCart creditCart) {
        this.creditCart = creditCart;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SimpleGuiceModule());

        CartMainImpl cartMainImpl = injector.getInstance(CartMainImpl.class);

        cartMainImpl.testBind();
        cartMainImpl.getMessageFromCredit();
        
    }

    public void testBind() {
        log.info("testBind");
    }
    
    public void getMessageFromCredit(){
        log.info(creditCart.getMessage());
    }
}
