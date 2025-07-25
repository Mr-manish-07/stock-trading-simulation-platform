package org.manish07.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "transactions")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    
    @Column (nullable = false)
    private String transactionType; // BUY or SELL
    
    @Column(nullable = false)
    private int quantity;
    
    @Column(nullable = false)
    private double price;
    
    private double totalAmount;
    
    private LocalDateTime transactionDate;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")
    private Stock stock;
    
    public Transaction() {}
    
    public Transaction(String transactionType, int quantity, double price, double totalAmount,
                       LocalDateTime transactionDate, User user, Portfolio portfolio, Stock stock) {
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = totalAmount;
        this.transactionDate = transactionDate;
        this.user = user;
        this.portfolio = portfolio;
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + transactionId +
                ", type='" + transactionType + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", totalAmount=" + totalAmount +
                ", date=" + transactionDate +
                '}';
    }
    
}

