package org.daniels.examples.guice.generics;

import com.google.inject.Provider;


public class HibernateConnectionProvider implements Provider<HibernateConnection<Integer>>{

    public HibernateConnection<Integer> get() {
        HibernateConnection<Integer> connection = new HibernateConnectionImpl();
        return connection;
    }

}
