<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>



<form method="post" action="/login">
    <label for="name">Логин
        <input type="text" id="name" name="name">
    </label>
    <br>
    <label for="password">Пароль
        <input  type="password" id="password" name="password">
    </label>
    <br>
    <label for="remember-me">
        <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня</label>
    <input type="submit" value="Login">
</form>

</body>
</html>
