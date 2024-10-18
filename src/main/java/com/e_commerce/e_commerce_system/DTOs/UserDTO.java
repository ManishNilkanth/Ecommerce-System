package com.e_commerce.e_commerce_system.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {


    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @Email
    @NotNull
    private String email;
}
