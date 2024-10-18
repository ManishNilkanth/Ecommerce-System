package com.e_commerce.e_commerce_system.Repository;

import com.e_commerce.e_commerce_system.Modules.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> { }
