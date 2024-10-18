package com.e_commerce.e_commerce_system.Repository;

import com.e_commerce.e_commerce_system.Modules.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { }

