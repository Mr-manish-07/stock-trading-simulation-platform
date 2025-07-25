package org.manish07.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "portfolios")
public class Portfolio {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long portfolioId;
    
    @Column(nullable = false)
    private String portfolioName;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> orders = new HashSet<> ();
    
    private double totalValue;
    
    public Portfolio() {}
    
    public Portfolio(String portfolioName) {
        this.portfolioName = portfolioName;
    }
    
    
    public Long getPortfolioId () {
        return portfolioId;
    }
    
    public void setPortfolioId (Long portfolioId) {
        this.portfolioId = portfolioId;
    }
    
    public String getPortfolioName () {
        return portfolioName;
    }
    
    public void setPortfolioName (String portfolioName) {
        this.portfolioName = portfolioName;
    }
    
    public User getUser () {
        return user;
    }
    
    public void setUser (User user) {
        this.user = user;
    }
    
    public Set<Order> getOrders () {
        return orders;
    }
    
    public void setOrders (Set<Order> orders) {
        this.orders = orders;
    }
    
    public double getTotalValue () {
        return totalValue;
    }
    
    public void setTotalValue (double totalValue) {
        this.totalValue = totalValue;
    }
    
    public void addOrder (Order order) {
        orders.add(order);
        order.setPortfolio(this);
    }
    
    public void removeOrder(Order order) {
        orders.remove(order);
        order.setPortfolio(null);
    }
    
    
    
    @Override
    public String toString() {
        return "Portfolio{" +
                "id=" + portfolioId +
                ", name='" + portfolioName + '\'' +
                ", totalValue=" + totalValue +
                '}';
    }
    
}




