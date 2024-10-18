package com.e_commerce.e_commerce_system.Modules;

public enum PaymentStatus {
    PENDING,
    COMPLETED,
    FAILED,
    CANCELED,
    REFUNDED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
