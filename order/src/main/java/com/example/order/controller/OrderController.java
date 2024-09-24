package com.example.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/orders/")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private final String INVENTORY_URL = "http://inventory";

    @GetMapping("/hello")
    public String ping(HttpServletRequest request) {
        return "Hello " + request.getRemoteAddr();
    }

    @GetMapping("/inv/hello")
    public String sayInventoryHello() {
        String URL = INVENTORY_URL + "/products/hello";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        return responseEntity.getBody();
    }

    @GetMapping("/all-products")
    public List getProductList() {
        String URL = INVENTORY_URL + "/products/all-products/";
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(URL, List.class);
        return responseEntity.getBody();
    }

}
