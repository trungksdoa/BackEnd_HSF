package com.koisystem.customException;

public class AlreadyExistedException extends RuntimeException {
    public AlreadyExistedException(String message) {
        super(message);
    }
}
