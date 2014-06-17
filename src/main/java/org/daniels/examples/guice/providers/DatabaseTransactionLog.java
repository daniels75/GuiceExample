package org.daniels.examples.guice.providers;

public class DatabaseTransactionLog implements TransactionLog {

    public String message(){
        return "message from DatabaseTransactionLog";
    }
}
