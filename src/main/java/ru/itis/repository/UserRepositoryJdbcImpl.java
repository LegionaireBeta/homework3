package ru.itis.repository;

import ru.itis.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryJdbcImpl implements UserRepository {

    private Connection connection;
    private Statement statement;

    private static final String SQL_SELECT_ALL_FROM_DRIVER = "SELECT id, first_name, last_name, username, age FROM homework3";

    public UserRepositoryJdbcImpl(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
    }

    @Override
    public List findAll() {

        try {
            Statement statement1 = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_DRIVER);
            List<User> result = new ArrayList<>();

            while (resultSet.next()){
                User user = User.builder()
                        .id(resultSet.getLong("id"))
                        .nameOfUser(resultSet.getString("first_name"))
                        .surnameOfUser(resultSet.getString("last_name"))
                        .usernameOfUser(resultSet.getString("username"))
                        .ageOfUser(resultSet.getInt("age"))
                        .build();

                result.add(user);

            }
            return result;
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }
}
