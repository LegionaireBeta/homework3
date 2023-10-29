package ru.itis.repository;

import ru.itis.model.User;

import java.sql.*;

public class AccountRepositoryJdbcImpl implements AccountRepository{

    private final Connection connection;

    private static final String SQL_INSERT = "INSERT INTO homework3(first_name, last_name, username, age, password_hash) VALUES ";


    public AccountRepositoryJdbcImpl(Connection connection){this.connection = connection;}

    @Override
    public void save(User user) throws SQLException {

        String sql = SQL_INSERT + "(?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getNameOfUser());
        preparedStatement.setString(2, user.getSurnameOfUser());
        preparedStatement.setString(3, user.getUsernameOfUser());
        preparedStatement.setInt(4, user.getAgeOfUser());
        preparedStatement.setString(5, user.getPasswordOfUser());

        preparedStatement.executeUpdate();
        System.out.println("Done");
    }

    public boolean getUserByUsername(String username, String password, User user) throws SQLException {
        String sql = "SELECT * FROM homework3 WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsernameOfUser());
        ResultSet resultSet = preparedStatement.executeQuery();
        String s = "";
        while (resultSet.next()){
            s = resultSet.getString("username") + " " + resultSet.getString("password_hash");
        }
        if(s.equals(username+ " " + password)){
            return true;
        }else {
            return false;
        }

    }

}
