<%@ page import="java.util.List" %>
<%@ page import="ru.itis.model.User" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: VAHABI
  Date: 31/10/2023
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <div>
        <table>
            <tr>
                <th>ID</th>
                <th>USERNAME</th>
                <th>NAME</th>
                <th>SURNAME</th>
                <th>AGE</th>
            </tr>
            <c:forEach items="${usersForJsp}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.nameOfUser}</td>
                    <td>${user.surnameOfUser}</td>
                    <td>${user.usernameOfUser}</td>
                    <td>${user.ageOfUser}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
