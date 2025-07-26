package org.manish07.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.manish07.dao.OrderDAO;
import org.manish07.model.Order;

import java.util.List;

public class OrderDAOImpl extends GenericDAOImpl<Order, Long>
        implements OrderDAO {
    
    public OrderDAOImpl (SessionFactory sessionFactory) {
        super(sessionFactory, Order.class);
    }
    
    @Override
    public List<Order> findByPortfolio (Long portfolioId) {
        try (Session session = sessionFactory.openSession ()) {
            return session.createQuery ("FROM Order WHERE portfolio.id = :portfolioId", Order.class)
                    .setParameter("portfolioId", portfolioId)
                    .list();
        }
    }
    
    @Override
    public List<Order> findByStock(Long stockId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Order WHERE stock.id = :stockId", Order.class)
                    .setParameter("stockId", stockId)
                    .list();
        }
    }
}

