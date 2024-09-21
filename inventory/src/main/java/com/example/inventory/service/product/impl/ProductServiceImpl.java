package com.example.inventory.service.product.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.dao.ProductDao;
import com.example.inventory.model.Product;
import com.example.inventory.service.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public List<Product> getProductByQuantity(Long quantity) {
        if(null != quantity) {
            return productDao.getProductByQuantity(quantity);
        }
        //Return custom exception invalid input error
        return new ArrayList<Product>();
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public Integer getTotalActiveProducts() {
        return productDao.getTotalActiveProducts();
    }

}