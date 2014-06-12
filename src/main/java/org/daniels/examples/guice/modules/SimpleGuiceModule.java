package org.daniels.examples.guice.modules;

import org.daniels.examples.guice.cart.CreditCart;
import org.daniels.examples.guice.cart.CreditCartFake;
import org.daniels.examples.guice.cart.CreditCartImpl;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class SimpleGuiceModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(CreditCart.class).to(CreditCartImpl.class);
        

        bind(CreditCart.class).annotatedWith(Names.named("Real")).to(CreditCartImpl.class);
        bind(CreditCart.class).annotatedWith(Names.named("Fake")).to(CreditCartFake.class);
    }

}
