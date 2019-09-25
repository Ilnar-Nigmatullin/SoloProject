<%--
  Created by IntelliJ IDEA.
  User: aaq-9
  Date: 29.08.2019
  Time: 1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные пользователя</title>
</head>
<body>

Редактировать пользователя

<form action="update" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <a>Имя</a>
    <input type="text" name="userName" value="${param.userName}" placeholder=${param.userName}> <br>
    <a>Возраст</a>
    <input type="text" name="age" value="${param.age}" placeholder=${param.age}> <br>
    <a>Пароль</a>
    <input type="text" name="password" value="${param.password}" placeholder=${param.password}> <br>
    <a>Логин</a>
    <input type="text" name="login" value="${param.login}" placeholder=${param.login}> <br>
    <a>Роль</a>
    <input type="text" name="role" value="${param.role}" placeholder=${param.role}> <br>
    <input type="hidden" name="_method" value="put"> <br>
    <input type="submit" value="Обновить">
</form>

</body>
</html>