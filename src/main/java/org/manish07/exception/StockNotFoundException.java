package org.manish07.exception;

public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException (String message) {
        super (message);
    }
}
