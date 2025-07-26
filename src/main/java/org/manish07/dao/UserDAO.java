package org.manish07.dao;

import org.manish07.model.User;

public interface UserDAO extends GenericDAO<User, Long> {
    User findByEmail(String email);
    boolean emailExists(String email);
}

