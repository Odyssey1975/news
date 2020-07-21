
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>update</title>
    <style>table th, table td {padding: 5px;}</style>
</head>
<br>


<table border="1">
<tr>
    <th>ID</th>
    <th>SERIES</th>
    <th>MODEL</th>
    <th>COLOR</th>
</tr>
</br>
<tr>
    <th>${car.id}</th>
    <th>${car.series}</th>
    <th>${car.model}</th>
    <th>${car.color}</th>
</tr>


</br>
</br>

    </table >
<h5>Input new parametrs</h5>
<h4>update User in dataBase</h4>
<form method="post" action="/updateUser?id=<c:out value='${car.id}' />">
    <label for="series">
        <input id="series" name="series" value="series">
    </label></br>
    <label for="model">
        <input id="model" name="model" value="model">
    </label></br>

    <label for="color">
        <input id="color" name="color" value="color">
    </label></br>

    <input type="submit" value="update in DB">
</form>

</body>
</html>

