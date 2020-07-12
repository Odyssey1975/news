
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>update</title>
</head>
<br>

<tr>
    <th>Series</th>
    <th>Model</th>
    <th>Color</th>
</tr>
</br>
<tr>
    <th>${Car.series}</th>
    <th>${Car.model}</th>
    <th>${Car.color}</th>
</tr>


</br>
</br>
<h5>Input new parametrs</h5>
<h4>update User in dataBase</h4>
<form method="post" action="/updateUser?id=<c:out value='${Car.id}' />">
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

