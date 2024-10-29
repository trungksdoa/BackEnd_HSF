package com.koisystem.customException;

public class ClientErrorException extends RuntimeException{
    public ClientErrorException(String message) {
        super(message);
    }
}
