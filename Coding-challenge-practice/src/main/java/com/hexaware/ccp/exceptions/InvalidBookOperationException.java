package com.hexaware.ccp.exceptions;

public class InvalidBookOperationException extends RuntimeException {
    public InvalidBookOperationException(String message) {
        super(message);
    }
}