package com.koisystem.customException;

public class PolicyViolationException extends RuntimeException {
    public PolicyViolationException(String message) {
        super(message);
    }
}