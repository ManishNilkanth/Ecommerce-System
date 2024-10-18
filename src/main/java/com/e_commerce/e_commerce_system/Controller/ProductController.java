package com.e_commerce.e_commerce_system.Controller;

import com.e_commerce.e_commerce_system.DTOs.ProductDTO;
import com.e_commerce.e_commerce_system.Service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final InventoryService inventoryService;

    @Operation(summary = "add new product")
    @PostMapping("/create")
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        try {
            ProductDTO productDTO1 = inventoryService.addProduct(productDTO);
            return new ResponseEntity<>(productDTO1,HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Operation(summary = "process orders,using map of productId and product quantity")
    @PostMapping("/process-orders")
    public ResponseEntity<String> processOrders(@Valid @RequestBody Map<Long, Integer> orders) {
        try {
            inventoryService.processOrders(orders);
            return ResponseEntity.ok("Orders processed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "Restock the items or products after shell and if products are less then 10")
    @PostMapping("/restock")
    public ResponseEntity<String> restockItems(@Valid @RequestBody Map<Long, Integer> restocks) {
        try {
            inventoryService.restockItems(restocks);
            return ResponseEntity.ok("Restocking completed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "get list of all products")
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts()
    {
        try {
             List<ProductDTO> productDTOs = inventoryService.getAllProducts();
            return new ResponseEntity<>(productDTOs,HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
