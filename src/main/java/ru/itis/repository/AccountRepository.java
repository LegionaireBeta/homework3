package ru.itis.repository;

import ru.itis.model.User;

import java.sql.SQLException;

public interface AccountRepository {

    void save (User user) throws SQLException;
    String getUserByUsername(User user) throws SQLException;

}

