package com.e_commerce.e_commerce_system.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {
    @NotNull(message = "Order ID is mandatory")
    private Long orderId;

    @NotNull(message = "Amount is mandatory")
    private Double amount;
}

