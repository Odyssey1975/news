<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4> Добавить пользователя в БД </h4>
<form method="post" action="/addUser">
    <label for="name">
        <input id="name" name="name" value="name">
    </label></br>
    <label for="password">
        <input id="password" name="password" value="password">
    </label></br>
    <input type="submit" value="Inside user in DB">
</form>
</br>
<a href="/logout">Выход</a>
</body>
</html>



