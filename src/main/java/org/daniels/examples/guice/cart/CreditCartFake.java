package org.daniels.examples.guice.cart;

public class CreditCartFake implements CreditCart {

    @Override
    public int getValue() {
        return 83;
    }

    @Override
    public void transfer() {
       System.out.println("Fake - CreditCart - transfer");
    }

    @Override
    public String getMessage() {
        return "Fake: Message from CreditCartImpl";
    }

}
