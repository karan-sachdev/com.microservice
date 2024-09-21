package com.example.inventory.service.product;

import java.util.List;

import com.example.inventory.model.Product;

public interface ProductService {
    List<Product> getProducts();
    List<Product> getProductByQuantity(Long quantity);
    void saveProduct(Product product);
    Integer getTotalActiveProducts();
}