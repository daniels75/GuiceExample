package org.daniels.examples.guice.generics;

public class StringOutput<T> {
    public String converter(T t) {
        return t.toString();
    }
}