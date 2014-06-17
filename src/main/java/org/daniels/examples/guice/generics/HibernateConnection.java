package org.daniels.examples.guice.generics;



public interface HibernateConnection<T> {

    public T getSessionStatus();
    
}
