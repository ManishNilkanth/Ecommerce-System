package com.e_commerce.e_commerce_system.ExceptionHandler;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message)
    {
        super(message);
    }
}
