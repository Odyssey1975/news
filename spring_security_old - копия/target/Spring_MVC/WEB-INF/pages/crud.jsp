<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Удалить пользователя</title>
<style> table th, table td {padding: 5px; } </style>
</head>
<body>

<form method="post" action="/admin/deleteUser">
    <table border="1">
        <tr>
            <td>ID</td>
            <td>NAME</td>
            <td>PASSWORD</td>

        </tr>
        <c:forEach items="${userInJDBC}" var="User">
            <tr>
                <th>${User.id}</th>
                <th>${User.name}</th>
                <th>${User.password}</th>
                <td>
                    <a href="/admin/updateUser?id=<c:out value='${User.id}' />">Edit</a>
                </td>
                <!---------Check box Delete----------->
                <td id="deleteUser">
                    <input type="checkbox" name="Delete" value=${User.id}>
                </td>
            </tr>
        </c:forEach>
    </table>
    <!------------ button Clear Cart--------------->
    <div class="button-update">
        <input type="submit" name="Doit" value="Удалить пользователя">
    </div>
</form>

<a href="/logout">Выход</a>
</body>
</html>