package org.manish07.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table (name = "sell_orders")
public class SellOrder extends Order {
    
    @Column (nullable = false)
    private double tax;
    
    // Default constructor (required by Hibernate)
    public SellOrder() {}
    
    // Parameterized constructor
    public SellOrder (int quantity, double price, LocalDateTime orderDate, Portfolio portfolio, Stock stock, double tax) {
        this.quantity = quantity;
        this.price = price;
        this.orderDate = orderDate;
        this.portfolio = portfolio;
        this.stock = stock;
        this.tax = tax;
    }
    
    @Override
    public double calculateAmount() {
        return (quantity * price) - tax;
    }
    
    // Getters and Setters
    public double getTax() {
        return tax;
    }
    
    public void setTax(double tax) {
        this.tax = tax;
    }
    
    @Override
    public String toString() {
        return "SellOrder{" +
                "orderId=" + orderId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", tax=" + tax +
                '}';
    }
}
