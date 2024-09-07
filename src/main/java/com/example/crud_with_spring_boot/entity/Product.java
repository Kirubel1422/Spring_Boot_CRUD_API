package com.example.crud_with_spring_boot.entity;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int stock;

    // Getters
    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getStock(){
        return this.stock;
    }

    // Setters
    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

}
