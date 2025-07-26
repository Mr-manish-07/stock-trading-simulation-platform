package org.manish07.dao;

import org.manish07.model.Stock;

import java.util.List;

public interface StockDAO extends GenericDAO<Stock, Long> {
    Stock findBySymbol(String symbol);
    List<Stock> findTopGainers (int limit);
    List<Stock> findTopLosers(int limit);
}

