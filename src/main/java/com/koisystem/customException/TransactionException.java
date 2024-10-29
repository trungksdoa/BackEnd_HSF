package com.koisystem.customException;

public class TransactionException extends org.springframework.transaction.TransactionException {
    public TransactionException(String message) {
        super(message);
    }
}
