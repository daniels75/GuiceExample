package org.daniels.examples.guice.cart;

public class CreditCartPayPal implements CreditCart {

    @Override
    public int getValue() {
        return 83;
    }

    @Override
    public void transfer() {
       System.out.println("PayPal - CreditCart - transfer");
    }

    @Override
    public String getMessage() {
        return "PayPal: Message from CreditCartImpl";
    }

}
