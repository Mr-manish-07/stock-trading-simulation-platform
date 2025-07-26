package org.manish07.dao;

import org.manish07.model.Order;

import java.util.List;

public interface OrderDAO extends GenericDAO<Order, Long> {
    List<Order> findByPortfolio (Long portfolioId);
    List<Order> findByStock(Long stockId);
}

