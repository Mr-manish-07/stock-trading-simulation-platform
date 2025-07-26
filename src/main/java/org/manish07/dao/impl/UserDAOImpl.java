package org.manish07.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.manish07.dao.UserDAO;
import org.manish07.model.User;

public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {
    public UserDAOImpl (SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }
    
    @Override
    public User findByEmail(String email) {
        try (Session session = sessionFactory.openSession ()) {
            return session.createQuery("FROM User WHERE email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }
    
    @Override
    public boolean emailExists(String email) {
        return findByEmail(email) != null;
    }
}

