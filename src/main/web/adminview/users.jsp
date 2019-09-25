<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%--Библиотека JSTL--%>

<%--
  Created by IntelliJ IDEA.
  User: aaq-9
  Date: 28.08.2019
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>AllUsers</title>
</head>
<body>
<table border="3">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Password</td>
        <td>Age</td>
        <td>Login</td>
        <td>Role</td>

        <c:forEach items="${users}" var="user">
    <tr>
        <td>${user.getId()}</td>
        <td>${user.getUserName()}</td>
        <td>${user.getPassword()}</td>
        <td>${user.getAge()}</td>
        <td>${user.getLogin()}</td>
        <td>${user.getRole()}</td>
        <td>
            <form action="update" method="get">
                <input type="hidden" name="id" value="${user.getId()}">
                <input type="hidden" name="name" value="${user.getUserName()}">
                <input type="hidden" name="age" value="${user.getAge()}">
                <input type="hidden" name="login" value="${user.getLogin()}">
                <input type="submit" value="Изменить" style="float: left">
            </form>
            <form action="delete" method="get">
                <input type="hidden" name="id" value="${user.getId()}">
                <input type="submit" value="Удалить" style="float: left">
            </form>
        </td>
    </tr>
    </c:forEach>
    <form action="create" method="get">
        <input type="submit" value="Добавить пользователя" style="float: left">
    </form>
<%--    <a href="/userview/home.jsp">Юзер</a>--%>
    <form action="/userview/home" method="get">
       <input type="submit" value="Страница Юзера" style="margin-left: 50px">
    </form>
    <form action="logout" method="post">
        <input type="submit" value="Выйти">
    </form>
</table>
</body>
</html>
