package org.manish07.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    
    @Column(nullable = false)
    private String name;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    private double balance;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Portfolio> portfolios = new HashSet<>();
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EmailVerification emailVerification;
    
    public User() {}
    
    public User(String name, String email, String password, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    
    
    public Long getUserId () {
        return userId;
    }
    
    public void setUserId (Long userId) {
        this.userId = userId;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    
    public String getPassword () {
        return password;
    }
    
    public void setPassword (String password) {
        this.password = password;
    }
    
    public double getBalance () {
        return balance;
    }
    
    public void setBalance (double balance) {
        this.balance = balance;
    }
    
    public Set<Portfolio> getPortfolios () {
        return portfolios;
    }
    
    public void setPortfolios (Set<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }
    
    public EmailVerification getEmailVerification () {
        return emailVerification;
    }
    
    public void setEmailVerification (EmailVerification emailVerification) {
        this.emailVerification = emailVerification;
    }
    
    public void addPortfolio (Portfolio portfolio) {
        portfolios.add(portfolio);
        portfolio.setUser(this);
    }
    
    public void removePortfolio(Portfolio portfolio) {
        portfolios.remove(portfolio);
        portfolio.setUser(null);
    }
    
    public void updateBalance(double amount) {
        this.balance += amount;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }
    
}

