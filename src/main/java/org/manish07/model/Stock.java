package org.manish07.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "stocks")
public class Stock {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long stockId;
    
    @Column(nullable = false, unique = true)
    private String symbol;
    
    @Column(nullable = false)
    private String companyName;
    
    @Column(nullable = false)
    private double price;
    
    private LocalDateTime lastUpdated;
    
    @ManyToMany(mappedBy = "stocks", fetch = FetchType.LAZY)
    private Set<Order> orders = new HashSet<> ();
    
    public Stock() {}
    
    public Stock(String symbol, String companyName, double price) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.price = price;
        this.lastUpdated = LocalDateTime.now();
    }
    
    public void updatePrice(double newPrice) {
        this.price = newPrice;
        this.lastUpdated = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "Stock{" +
                "id=" + stockId +
                ", symbol='" + symbol + '\'' +
                ", companyName='" + companyName + '\'' +
                ", price=" + price +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
    
}

