package ru.itis.servlets;


import ru.itis.repository.UserRepository;
import ru.itis.repository.UserRepositoryJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@WebServlet("/users")
public class UsersServlets extends HttpServlet {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "erfan443565";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/homework3";

    private UserRepository userRepository;

    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = connection.createStatement();
            userRepository = new UserRepositoryJdbcImpl(connection, statement);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List result;

        try {
            result = userRepository.findAll();
        }catch (Exception e){
            throw new IllegalStateException(e);
        }

        request.setAttribute("usersForJsp", result);
        request.getRequestDispatcher("/jsp/users.jsp").forward(request, response);
    }
}
