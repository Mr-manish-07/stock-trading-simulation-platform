package org.manish07.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table (name = "buy_orders")
public class BuyOrder extends Order {
    
    @Column (nullable = false)
    private double brokerageFee;
    
    // Default constructor (required by Hibernate)
    public BuyOrder() {}
    
    // Parameterized constructor
    public BuyOrder (int quantity, double price, LocalDateTime orderDate, Portfolio portfolio, Stock stock, double brokerageFee) {
        this.quantity = quantity;
        this.price = price;
        this.orderDate = orderDate;
        this.portfolio = portfolio;
        this.stock = stock;
        this.brokerageFee = brokerageFee;
    }
    
    @Override
    public double calculateAmount() {
        return (quantity * price) + brokerageFee;
    }
    
    // Getters and Setters
    public double getBrokerageFee() {
        return brokerageFee;
    }
    
    public void setBrokerageFee(double brokerageFee) {
        this.brokerageFee = brokerageFee;
    }
    
    @Override
    public String toString() {
        return "BuyOrder{" +
                "orderId=" + orderId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", brokerageFee=" + brokerageFee +
                '}';
    }
}

