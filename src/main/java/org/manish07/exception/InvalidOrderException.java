package org.manish07.exception;

public class InvalidOrderException extends RuntimeException {
    public InvalidOrderException (String message) {
        super (message);
    }
}
