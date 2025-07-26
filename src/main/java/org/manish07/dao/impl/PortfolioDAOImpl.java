package org.manish07.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.manish07.dao.PortfolioDAO;
import org.manish07.model.Portfolio;

import java.util.List;

public class PortfolioDAOImpl extends GenericDAOImpl<Portfolio, Long>
        implements PortfolioDAO {
    
    public PortfolioDAOImpl (SessionFactory sessionFactory) {
        super(sessionFactory, Portfolio.class);
    }
    
    @Override
    public List<Portfolio> findByUserId (Long userId) {
        try (Session session = sessionFactory.openSession ()) {
            return session.createQuery("FROM Portfolio WHERE user.id = :userId", Portfolio.class)
                    .setParameter("userId", userId)
                    .list();
        }
    }
}

