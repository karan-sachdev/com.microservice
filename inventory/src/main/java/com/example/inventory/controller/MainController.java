package com.example.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.model.Product;
import com.example.inventory.service.product.ProductService;

@RestController
@RequestMapping("/products")
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all-products/")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @PostMapping("/save/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @GetMapping("/count")
    public Integer countActiveProducts() {
        return productService.getTotalActiveProducts();
    }
}