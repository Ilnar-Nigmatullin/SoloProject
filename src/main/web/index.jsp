<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Здравствуйте!</title>
</head>
<body>
<a>Если вы хотите начать работу с базой данных пользователей -</a> <br>
<a>нажмите кнопку ниже:</a>
<br>
<br>
<form action="login" method="post">
    <input required type="text" name="login" placeholder="Логин">
    <input required type="text" name="password" placeholder="Пароль">
    <input type="submit" value="Войти">
</form>
</body>
</html>