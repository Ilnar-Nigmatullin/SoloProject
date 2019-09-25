<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Добавить нового пользователя</title>
</head>
<body>
<form action="create" method="post">
    <input required type="text" name="login" placeholder="Имя">
    <input required type="text" name="age" placeholder="Возраст">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>