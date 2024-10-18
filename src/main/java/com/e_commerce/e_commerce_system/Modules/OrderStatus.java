package com.e_commerce.e_commerce_system.Modules;

public enum OrderStatus {
    PENDING,
    COMPLETED,
    FAILED,
    CANCELED,
    SHIPPED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
