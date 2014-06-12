package org.daniels.examples.guice.cart;

public class CreditCartImpl implements CreditCart {

    @Override
    public int getValue() {
        return 10;
    }

    @Override
    public void transfer() {
       System.out.println("CreditCart - transfer");
    }

    @Override
    public String getMessage() {
        return "Message from CreditCartImpl";
    }

}
