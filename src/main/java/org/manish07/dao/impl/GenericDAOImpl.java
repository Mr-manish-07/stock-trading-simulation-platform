package org.manish07.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.manish07.dao.GenericDAO;

import java.util.List;

public abstract class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {
    
    protected SessionFactory sessionFactory;
    private Class<T> entityClass;
    
    public GenericDAOImpl(SessionFactory sessionFactory, Class<T> entityClass) {
        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
    }
    
    @Override
    public void save(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist (entity);
            tx.commit();
        }
    }
    
    @Override
    public T findById(ID id) {
        try (Session session = sessionFactory.openSession ()) {
            return session.find (entityClass, id);
        }
    }
    
    @Override
    public void update(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction ();
            session.merge (entity);
            tx.commit();
        }
    }
    
    @Override
    public void delete(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove (entity);
            tx.commit();
        }
    }
    
    @Override
    public List<T> findAll () {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM " + entityClass.getName(), entityClass).list();
        }
    }
}

