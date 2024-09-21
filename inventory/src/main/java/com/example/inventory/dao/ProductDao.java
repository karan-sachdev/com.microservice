package com.example.inventory.dao;

import java.util.List;

import com.example.inventory.model.Product;

public interface ProductDao {

    List<Product> getAllProducts();
    Product findProductById(long id);
    Product saveProduct(Product product);
    List<Product> getProductByQuantity(Long quantity);
    void deleteProduct(Product product);
    void deleteProductById(long id);
    Integer getTotalActiveProducts();
}
