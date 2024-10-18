package com.e_commerce.e_commerce_system.Service;

import com.e_commerce.e_commerce_system.DTOs.PaymentDTO;

public interface PaymentService {

    void processPayment(PaymentDTO paymentDTO);
}
