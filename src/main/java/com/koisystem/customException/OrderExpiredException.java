package com.koisystem.customException;

public class OrderExpiredException extends RuntimeException {
    public OrderExpiredException(String message) {
        super(message);
    }
}
