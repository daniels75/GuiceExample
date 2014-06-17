package org.daniels.examples.guice.generics;

public interface Repository<T> {
    void save(T item);

    public T get();
}