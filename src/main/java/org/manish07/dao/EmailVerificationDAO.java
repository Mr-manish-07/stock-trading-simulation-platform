package org.manish07.dao;

import org.manish07.model.EmailVerification;

public interface EmailVerificationDAO extends GenericDAO<EmailVerification, Long> {
    EmailVerification findByUserId(Long userId);
    boolean isOtpValid(Long userId, String otp);
}

