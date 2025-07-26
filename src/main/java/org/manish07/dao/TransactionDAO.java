package org.manish07.dao;

import org.manish07.model.Transaction;

import java.util.List;

public interface TransactionDAO extends GenericDAO<Transaction, Long> {
    List<Transaction> findByUser (Long userId);
    List<Transaction> findByPortfolio (Long portfolioId);
}

