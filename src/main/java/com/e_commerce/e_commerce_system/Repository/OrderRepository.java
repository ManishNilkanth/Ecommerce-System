package com.e_commerce.e_commerce_system.Repository;

import com.e_commerce.e_commerce_system.Modules.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    public List<Orders> findAllByUserId(Long userId);
}
