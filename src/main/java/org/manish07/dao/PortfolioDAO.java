package org.manish07.dao;

import org.manish07.model.Portfolio;

import java.util.List;

public interface PortfolioDAO extends GenericDAO<Portfolio, Long> {
    List<Portfolio> findByUserId (Long userId);
}

