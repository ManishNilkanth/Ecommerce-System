package com.e_commerce.e_commerce_system.Controller;

import com.e_commerce.e_commerce_system.DTOs.PaymentDTO;
import com.e_commerce.e_commerce_system.Service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @Operation(summary = "Process payment by OrderId and amount")
    @PostMapping
    public ResponseEntity<String> processPayment(@Valid @RequestBody PaymentDTO paymentDTO)
    {
        try {
            paymentService.processPayment(paymentDTO);
            return ResponseEntity.ok("Payment processed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
