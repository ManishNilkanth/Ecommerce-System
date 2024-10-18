package com.e_commerce.e_commerce_system.ExceptionHandler;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}