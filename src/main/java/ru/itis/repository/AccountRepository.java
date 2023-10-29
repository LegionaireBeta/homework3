package ru.itis.repository;

import ru.itis.model.User;

import java.sql.SQLException;

public interface AccountRepository {

    void save (User user) throws SQLException;
    boolean getUserByUsername(String username, String password, User user) throws SQLException;

}

