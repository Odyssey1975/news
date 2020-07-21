
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Crud</title>
    <style>table th, table td {padding: 5px;}</style>

</head>
<body>

<form method="post" action="/deleteCar">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>SERIES</th>
            <th>MODEL</th>
            <th>COLOR</th>
        </tr>
        <c:forEach items="${carsInJDBC}" var="Car">
            <tr>
                <th>${Car.id}</th>
                <th>${Car.series}</th>
                <th>${Car.model}</th>
                <th>${Car.color}</th>
                <td>
                    <a href="/updateUser?id=<c:out value='${Car.id}' />">Edit</a>
                </td>
                <!---------Check box Delete----------->
                <td id="deleteUser">
                    <input type="checkbox" name="Delete" value=${Car.id}>
                </td>
            </tr>
        </c:forEach>
    </table>
    <!------------ button Clear Cart--------------->
    <div class="button-update">
        <input type="submit" name="Delete" value="Delete selected cars">
    </div>
</form>
<h5>COOL</h5>
</br>
</br>
<h4>Add Car in DataBase</h4>
<form method="post" action="/addCar">
    <label for="series">
        <input id="series" name="series" value="series">
    </label></br>
    <label for="model">
        <input id="model" name="model" value="model">
    </label></br>
    <label for="color">
        <input id="color" name="color" value="color">
    </label></br>
    <input type="submit" value="inside car in DB">
</form>
</br>
</br>

</body>
</html>

