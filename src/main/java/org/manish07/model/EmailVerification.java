package org.manish07.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "email_verifications")
public class EmailVerification {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String otp;
    
    @Column(nullable = false)
    private LocalDateTime expiryTime;
    
    private boolean verified;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    public EmailVerification() {}
    
    public EmailVerification(String otp, LocalDateTime expiryTime, boolean verified, User user) {
        this.otp = otp;
        this.expiryTime = expiryTime;
        this.verified = verified;
        this.user = user;
    }
    
    public boolean isOtpExpired() {
        return LocalDateTime.now().isAfter(expiryTime);
    }
    
    public boolean verifyOtp(String inputOtp) {
        if (!isOtpExpired() && this.otp.equals(inputOtp)) {
            this.verified = true;
            return true;
        }
        return false;
    }
    
    
}

