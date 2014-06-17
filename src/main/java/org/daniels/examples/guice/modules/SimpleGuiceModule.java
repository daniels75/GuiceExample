package org.daniels.examples.guice.modules;

import static org.daniels.examples.constants.Constants.JDBC;
import static org.daniels.examples.constants.Constants.TIMEOUT;

import org.daniels.examples.guice.bindings.AnotherConcreteClass;
import org.daniels.examples.guice.bindings.AnotherConcreteFooClass;
import org.daniels.examples.guice.bindings.MyConcreteClass;
import org.daniels.examples.guice.bindings.MyConcreteFooClass;
import org.daniels.examples.guice.cart.CreditCart;
import org.daniels.examples.guice.cart.CreditCartFake;
import org.daniels.examples.guice.cart.CreditCartImpl;
import org.daniels.examples.guice.cart.CreditCartPayPal;
import org.daniels.examples.guice.cart.PayPal;
import org.daniels.examples.guice.providers.DatabaseTransactionLogProvider;
import org.daniels.examples.guice.providers.TransactionFooLog;
import org.daniels.examples.guice.providers.TransactionLog;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class SimpleGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CreditCart.class).to(CreditCartImpl.class);

        bind(CreditCart.class).annotatedWith(Names.named("Real")).to(CreditCartImpl.class);
        bind(CreditCart.class).annotatedWith(Names.named("Fake")).to(CreditCartFake.class);
        bind(CreditCart.class).annotatedWith(PayPal.class).to(CreditCartPayPal.class);

        bind(String.class).annotatedWith(Names.named(JDBC)).toInstance("jdbc:mysql://localhost/pizza");
        bind(Integer.class).annotatedWith(Names.named(TIMEOUT)).toInstance(10);

        // providers
        bind(TransactionLog.class).toProvider(DatabaseTransactionLogProvider.class);
        
        // bindings
        bind(MyConcreteClass.class);
        bind(AnotherConcreteClass.class).in(Singleton.class);
        
        bind(MyConcreteFooClass.class).annotatedWith(Names.named("MyFoo")).to(MyConcreteFooClass.class);
        bind(AnotherConcreteFooClass.class).annotatedWith(Names.named("AnotherFoo")).to(AnotherConcreteFooClass.class).in(Singleton.class);

    }

    @Provides
    TransactionFooLog provideTransactionFooLog() {
        return new TransactionFooLog() {
            @Override
            public String message() {
                return "Message from TransactionFooLog";
            }

        };
    }

}
