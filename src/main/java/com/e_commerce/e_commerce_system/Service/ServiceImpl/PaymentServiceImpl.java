package com.e_commerce.e_commerce_system.Service.ServiceImpl;

import com.e_commerce.e_commerce_system.DTOs.PaymentDTO;
import com.e_commerce.e_commerce_system.ExceptionHandler.OrderNotFoundException;
import com.e_commerce.e_commerce_system.Modules.OrderStatus;
import com.e_commerce.e_commerce_system.Modules.Orders;
import com.e_commerce.e_commerce_system.Modules.Payment;
import com.e_commerce.e_commerce_system.Modules.PaymentStatus;
import com.e_commerce.e_commerce_system.Repository.OrderRepository;
import com.e_commerce.e_commerce_system.Repository.PaymentRepository;
import com.e_commerce.e_commerce_system.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    private final OrderRepository orderRepository;
    @Override
    public void processPayment(PaymentDTO paymentDTO) {
        Orders order = orderRepository.findById(paymentDTO.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException("Order not found with given orderId"));

        Payment payment = new Payment();
        payment.setPaymentDate(LocalDateTime.now());
        payment.setAmount(paymentDTO.getAmount());
        payment.setStatus(PaymentStatus.COMPLETED);
        payment.setOrder(order);

        order.setPayment(payment);
        order.setStatus(OrderStatus.COMPLETED);

        paymentRepository.save(payment);
        orderRepository.save(order);
    }
}
