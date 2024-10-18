package com.e_commerce.e_commerce_system.Service.ServiceImpl;

import com.e_commerce.e_commerce_system.DTOs.OrderDTO;
import com.e_commerce.e_commerce_system.ExceptionHandler.ProductNotFoundException;
import com.e_commerce.e_commerce_system.ExceptionHandler.UserNotFoundException;
import com.e_commerce.e_commerce_system.Modules.Orders;
import com.e_commerce.e_commerce_system.Modules.OrderStatus;
import com.e_commerce.e_commerce_system.Modules.Product;
import com.e_commerce.e_commerce_system.Modules.User;
import com.e_commerce.e_commerce_system.Repository.OrderRepository;
import com.e_commerce.e_commerce_system.Repository.ProductRepository;
import com.e_commerce.e_commerce_system.Repository.UserRepository;
import com.e_commerce.e_commerce_system.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;


    private final UserRepository userRepository;

    public OrderDTO createOrder(OrderDTO orderDTO){
        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        List<Product> products = productRepository.findAllById(orderDTO.getProductIds());

        if (products.isEmpty()) {
            throw new ProductNotFoundException("Products not found");
        }

        Orders orders = Orders.builder()
                .user(user)
                .products(products)
                .status(OrderStatus.PENDING)
                .build();

        Orders savedOrders = orderRepository.save(orders);
        return OrderDTO.builder()
                .userId(savedOrders.getUser().getId())
                .productIds(orderDTO.getProductIds())
                .status(savedOrders.getStatus())
                .build();
    }



}


