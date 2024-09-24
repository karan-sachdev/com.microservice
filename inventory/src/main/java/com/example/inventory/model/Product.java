package com.example.inventory.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private Date date;
    
    @Column
    private boolean deleted = false;

    @JsonManagedReference
    @OneToOne(mappedBy = "product")
    Quantity quantity;

}
