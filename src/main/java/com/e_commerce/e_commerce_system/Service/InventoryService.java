package com.e_commerce.e_commerce_system.Service;

import com.e_commerce.e_commerce_system.DTOs.ProductDTO;

import java.util.List;
import java.util.Map;

public interface InventoryService {

    public void restockItems(Map<Long, Integer> restocks);

    public void processOrders(Map<Long, Integer> orders);

    ProductDTO addProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();
}
