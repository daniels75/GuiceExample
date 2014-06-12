package org.daniels.examples.spring.loan;

public class LoanImpl implements Loan {

    @Override
    public int getValue() {
        return 10;
    }

    @Override
    public void transfer() {
       System.out.println("Loan - transfer");
    }

    @Override
    public String getMessage() {
        return "Message from Loan";
    }

}
