package org.daniels.examples.guice.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.guice.cart.CreditCart;
import org.daniels.examples.guice.modules.SimpleGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class CartMainImpl implements CartMain {
    
    private final transient Log log = LogFactory.getLog(CartMainImpl.class);
    
    CreditCart creditCart;
    
    @Inject
    public CartMainImpl(final CreditCart creditCart){
        this.creditCart = creditCart;
    }
    
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SimpleGuiceModule());
        
        CartMainImpl main = injector.getInstance(CartMainImpl.class);
        
        main.testBind();
    }
    
    public void testBind(){
        log.info("testBind");
        

    }
}
