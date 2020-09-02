<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Страница пользователя</title>
    <style> table th, table td {
        padding: 5px;
    } </style>
</head>
<br>
<table border="1">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>PASSWORD</td>
    </tr>
    </br>
    <tr>
        <th>${userInJDBC.id}</th>
        <th>${userInJDBC.name}</th>
        <th>${userInJDBC.password}</th>
    </tr>
</table>
</br>
<a href="admin/AllUsers">Список всех поользователей</a>
<a href="/logout">Выход</a>

</br>
</br>


</body>
</html>

