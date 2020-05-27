
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Change Users</title>
</head>
<body>
<h1>Hello and Welcome</h1>
<h3>Список пользователей в Базе данных</h3>

<form method="post" action="/deleteUser">
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>country</th>
    </tr>
    <c:forEach items="${usersInJDBC}" var="User">
        <tr>
            <th>${User.id}</th>
            <th>${User.name}</th>
            <th>${User.email}</th>
            <th>${User.country}</th>
            <td>
                <a href="/updateUser?id=<c:out value='${User.id}' />">Edit</a>
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
        <input type="submit" name="Delete" value="Delete selected users">
   </div>
</form>
<%--<h5>Таблица</h5>--%>
<%--</br>
</br>--%>
<h3>Добавляем пользователя в Базу данных </h3>
<form method="post" action="/addUser">
    <label for="name">name
        <input id="name" name="name">
    </label>
    <%--</br>--%>
    <label for="email">email
        <input id="email" name="email">
    </label>
   <%-- </br>--%>
    <label for="country">country
        <input id="country" name="country">
    </label>
   <%-- </br>--%>
    <input type="submit" value="inside in JDBC">
</form>
<%--</br>
</br>--%>

</body>
</html>
