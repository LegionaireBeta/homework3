<%@ page import="java.util.List" %>
<%@ page import="ru.itis.model.User" %>

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
            <%
                List<User> user = (List<User>) request.getAttribute("usersForJsp");
                for(int i=0; i<user.size(); i++) {
            %>
                <tr>
                    <td><%=user.get(i).getId()%></td>
                    <td><%=user.get(i).getUsernameOfUser()%></td>
                    <td><%=user.get(i).getNameOfUser()%></td>
                    <td><%=user.get(i).getSurnameOfUser()%></td>
                    <td><%=user.get(i).getAgeOfUser()%></td>
                </tr>
            <%}%>
        </table>
    </div>
</body>
</html>
