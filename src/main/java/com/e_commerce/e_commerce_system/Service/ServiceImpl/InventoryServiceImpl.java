package com.e_commerce.e_commerce_system.Service.ServiceImpl;

import com.e_commerce.e_commerce_system.DTOs.ProductDTO;
import com.e_commerce.e_commerce_system.ExceptionHandler.InsufficientStockException;
import com.e_commerce.e_commerce_system.ExceptionHandler.ProductNotFoundException;
import com.e_commerce.e_commerce_system.Modules.Product;
import com.e_commerce.e_commerce_system.Repository.ProductRepository;
import com.e_commerce.e_commerce_system.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final ProductRepository productRepository;

    public void processOrders(Map<Long, Integer> orders){
        for (Map.Entry<Long, Integer> entry : orders.entrySet()) {
            Long productId = entry.getKey();
            Integer quantityOrdered = entry.getValue();

            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ProductNotFoundException("Product not found"));

            if (product.getStockQuantity() < quantityOrdered) {
                throw new InsufficientStockException("Insufficient stock for product: " + product.getName());
            }

            product.setStockQuantity(product.getStockQuantity() - quantityOrdered);

            // Check if stock drops below threshold
            if (product.getStockQuantity() < 10) {
                System.out.println("Alert: Restock needed for product: " + product.getName());
            }

            productRepository.save(product);
        }
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .stockQuantity(productDTO.getStockQuantity())
                .build();

        Product savedProduct = productRepository.save(product);

        return ProductDTO.builder()
                .id(savedProduct.getId())
                .stockQuantity(savedProduct.getStockQuantity())
                .name(savedProduct.getName())
                .price(savedProduct.getPrice())
                .build();
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getStockQuantity()))
                .collect(Collectors.toList());
    }


    public void restockItems(Map<Long, Integer> restocks) {
        for (Map.Entry<Long, Integer> entry : restocks.entrySet()) {
            Long productId = entry.getKey();
            Integer restockQuantity = entry.getValue();

            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ProductNotFoundException("Product not found"));

            product.setStockQuantity(product.getStockQuantity() + restockQuantity);
            productRepository.save(product);
        }
    }
}
