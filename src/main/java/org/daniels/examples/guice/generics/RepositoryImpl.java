package org.daniels.examples.guice.generics;

public class RepositoryImpl<T> implements Repository<T> {

    private T item;

    @Override
    public void save(T item) {
    }

    @Override
    public T get() {
        return item;
    }
}