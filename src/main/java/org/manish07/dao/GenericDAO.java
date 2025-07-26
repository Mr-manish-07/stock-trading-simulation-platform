package org.manish07.dao;

import java.util.List;

public interface GenericDAO<T, ID> {
    
    void save(T entity);          // Create
    T findById(ID id);            // Read
    void update(T entity);        // Update
    void delete(T entity);        // Delete
    List<T> findAll ();            // Get all
}

