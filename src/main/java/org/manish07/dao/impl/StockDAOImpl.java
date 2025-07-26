package org.manish07.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.manish07.dao.StockDAO;
import org.manish07.model.Stock;

import java.util.List;

public class StockDAOImpl extends GenericDAOImpl<Stock, Long>
        implements StockDAO {
    
    public StockDAOImpl (SessionFactory sessionFactory) {
        super(sessionFactory, Stock.class);
    }
    
    @Override
    public Stock findBySymbol(String symbol) {
        try (Session session = sessionFactory.openSession ()) {
            return session.createQuery("FROM Stock WHERE symbol = :symbol", Stock.class)
                    .setParameter("symbol", symbol)
                    .uniqueResult();
        }
    }
    
    @Override
    public List<Stock> findTopGainers (int limit) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Stock ORDER BY price DESC", Stock.class)
                    .setMaxResults(limit)
                    .list();
        }
    }
    
    @Override
    public List<Stock> findTopLosers(int limit) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Stock ORDER BY price ASC", Stock.class)
                    .setMaxResults(limit)
                    .list();
        }
    }
}

