package org.manish07.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.manish07.dao.EmailVerificationDAO;
import org.manish07.model.EmailVerification;

public class EmailVerificationDAOImpl extends GenericDAOImpl<EmailVerification, Long>
        implements EmailVerificationDAO {
    
    public EmailVerificationDAOImpl (SessionFactory sessionFactory) {
        super (sessionFactory, EmailVerification.class);
    }
    
    @Override
    public EmailVerification findByUserId(Long userId) {
        try (Session session = sessionFactory.openSession ()) {
            return session.createQuery("FROM EmailVerification WHERE user.id = :userId", EmailVerification.class)
                    .setParameter("userId", userId)
                    .uniqueResult();
        }
    }
    
    @Override
    public boolean isOtpValid(Long userId, String otp) {
        try (Session session = sessionFactory.openSession()) {
            Long count = session.createQuery(
                            "SELECT COUNT(ev) FROM EmailVerification ev WHERE ev.user.id = :userId AND ev.otp = :otp", Long.class)
                    .setParameter("userId", userId)
                    .setParameter("otp", otp)
                    .uniqueResult();
            return count != null && count > 0;
        }
    }
}

