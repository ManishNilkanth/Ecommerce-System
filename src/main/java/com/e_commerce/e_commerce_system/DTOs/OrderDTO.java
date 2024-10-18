package com.e_commerce.e_commerce_system.DTOs;

import com.e_commerce.e_commerce_system.Modules.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private Long id;

    private Long userId;

    @NotNull
    private List<Long> productIds;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
