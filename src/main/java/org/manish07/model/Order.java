package org.manish07.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Inheritance(strategy = InheritanceType.JOINED) // Separate tables for subclasses
public abstract class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long orderId;
    
    @Column(nullable = false)
    protected int quantity;
    
    @Column(nullable = false)
    protected double price;
    
    protected LocalDateTime orderDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id")
    protected Portfolio portfolio;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")
    protected Stock stock;
    
    // Abstract method
    public abstract double calculateAmount();
    
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
    
    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
    
    
}


