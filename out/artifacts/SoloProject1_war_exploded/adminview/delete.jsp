<%--
  Created by IntelliJ IDEA.
  User: aaq-9
  Date: 24.08.2019
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete models</title>
</head>
<body>
Вы действительно хотите удалить пользователя ${param.id}?

<form action="delete" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Удалить">
</form>
</body>
</html>
