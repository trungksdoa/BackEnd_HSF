package com.koisystem.customException;

public class InsufficientStockException extends RuntimeException{
    public InsufficientStockException(String message) {
        super(message, null, false, false);
    }
}
