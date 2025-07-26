package org.manish07.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.manish07.dao.TransactionDAO;
import org.manish07.model.Transaction;

import java.util.List;

public class TransactionDAOImpl extends GenericDAOImpl<Transaction, Long>
        implements TransactionDAO {
    
    public TransactionDAOImpl (SessionFactory sessionFactory) {
        super(sessionFactory, Transaction.class);
    }
    
    @Override
    public List<Transaction> findByUser (Long userId) {
        try (Session session = sessionFactory.openSession ()) {
            return session.createQuery("FROM Transaction WHERE user.id = :userId", Transaction.class)
                    .setParameter("userId", userId)
                    .list();
        }
    }
    
    @Override
    public List<Transaction> findByPortfolio(Long portfolioId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Transaction WHERE portfolio.id = :portfolioId", Transaction.class)
                    .setParameter("portfolioId", portfolioId)
                    .list();
        }
    }
}

