package org.manish07.exception;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException (String message) {
        super (message);
    }
}
