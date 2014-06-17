package org.daniels.examples.guice.providers;

import com.google.inject.Provider;

public class DatabaseTransactionLogProvider implements Provider<TransactionLog> {

    public DatabaseTransactionLogProvider() {
    }

    public TransactionLog get() {
        DatabaseTransactionLog transactionLog = new DatabaseTransactionLog();
        return transactionLog;
    }
}