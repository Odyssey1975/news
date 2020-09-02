<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Обновление</title>
    <style> table th, table td {padding: 5px; } </style>
</head>

<table border="1">
<tr>
    <td>ID</td>
    <td>NAME</td>
    <td>PASSWORD</td>
</tr>
</br>
<tr>
    <th>${User.id}</th>
    <th>${User.name}</th>
    <th>${User.password}</th>
</tr>
    </table >

<%--</br>
</br>--%>
<h5>Обновляем пользователя в БД:Введите новые значения полей </h5>

<form method="post" action="/admin/updateUser?id=<c:out value='${User.id}' />">
    <label for="name">
        <input id="name" name="name" value="name">
    </label>
   <%-- </br>--%>
    <label for="password">
        <input id="password" name="password" value="password">
    </label>
    <%--</br>--%>

    <input type="submit" value="Update in DB">
</form>
<a href="/user">Cтраница пользователя</a>
<a href="/logout">Выход</a>
</body>
</html>
