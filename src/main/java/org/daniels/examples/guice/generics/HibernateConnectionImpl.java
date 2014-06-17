package org.daniels.examples.guice.generics;

public class HibernateConnectionImpl implements HibernateConnection<Integer> {

    public Integer getSessionStatus() {
        return 10;
    }

}
