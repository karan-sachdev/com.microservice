package com.example.order.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "order_date")
    private Date orderDate;

    @ElementCollection
    @Column(name = "product_id")
    private List<Long> productId;

    @ElementCollection
    @Column
    private List<Long> quantity;

    @ElementCollection
    @Column
    private List<Double> price;

    @Column
    private Double amount;
}
