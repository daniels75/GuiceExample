package org.daniels.examples.guice.modules;

import org.daniels.examples.guice.cart.CreditCart;
import org.daniels.examples.guice.cart.CreditCartImpl;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class SimpleGuiceModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(CreditCart.class).to(CreditCartImpl.class);
        

        // bind(HibernateUtil.class).annotatedWith(Names.named("RealImpl")).to(HibernateUtilImpl.class);
        //bind(HibernateUtil.class).annotatedWith(Names.named("FakeImpl")).to(HibernateUtilFake.class);
    }

}
