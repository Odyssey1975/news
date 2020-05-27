
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>update User</title>
</head>
<body>
<h5>Старые параметры</h5>
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
        </tr>
    </c:forEach>
</table>

<%--</br>
</br>--%>
<h5>Ввод новых параметров</h5>
<h4>Обновляем данные пользователя в Базе данных </h4>
<form method="post" action="/updateUser">


    <label for="name">name
        <input id="name" name="name">
    </label>
  <%--  </br>--%>
    <label for="email">email
        <input id="email" name="email">
    </label>
    <%--</br>--%>
    <label for="country">country
        <input id="country" name="country">
    </label>
   <%-- </br>--%>
    <input type="submit" value="update in JDBC">
</form>

</body>
</html>
