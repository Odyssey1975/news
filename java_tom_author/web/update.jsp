<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>login</th>
        <th>password</th>
        <th>country</th>
    </tr>
    <c:forEach items="${usersInJDBC}" var="User">
        <tr>
            <th>${User.id}</th>
            <th>${User.login}</th>
            <th>${User.password}</th>
            <th>${User.country}</th>
        </tr>
    </c:forEach>
</table>

<h5>Input new parametrs</h5>
<h4>update User in dataBase</h4>
<form method="post" action="/updateUser">
    <label for="login">login
        <input id="login" login="login">
    </label>
    <label for="password">password
        <input id="password" login="password">
    </label>
    <label for="country">country
        <input id="country" login="country">
    </label>
    <input type="submit" value="update in JDBC">
</form>

</body>
</html>
--%>
