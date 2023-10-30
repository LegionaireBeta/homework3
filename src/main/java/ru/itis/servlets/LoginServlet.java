package ru.itis.servlets;

import ru.itis.model.User;
import ru.itis.repository.AccountRepository;
import ru.itis.repository.AccountRepositoryJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "erfan443565";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/homework3";

    AccountRepository accountRepository;

    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            accountRepository = new AccountRepositoryJdbcImpl(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/html/login.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountUsername = request.getParameter("username");
        String accountPassword = request.getParameter("password");

        User user = User.builder()
                .usernameOfUser(accountUsername)
                .passwordOfUser(accountPassword)
                .build();

        try {
            if(accountRepository.login(accountUsername, accountPassword, user)){
                response.sendRedirect("/afterlogin");
            }else {
                response.sendRedirect("/login");
            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }


    }

}

