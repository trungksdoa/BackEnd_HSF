package com.koisystem.customException;

public class EmptyException extends RuntimeException {
    public EmptyException(String message) {
        super(message);
    }
}
