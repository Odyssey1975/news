
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>crud</title>

</head>
<body>

<form method="post" action="/deleteCar">
    <table>
        <tr>
            <th>ID</th>
            <th>COLOR</th>
            <th>MODEL</th>
        </tr>
        <c:forEach items="${carsInJDBC}" var="Car">
            <tr>
                <th>${Car.id}</th>
                <th>${Car.color}</th>
                <th>${Car.model}</th>
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
<h5>it`s clever man</h5>
</br>
</br>
<h4>add Car in dataBase</h4>
<form method="post" action="/addcar">
    <label for="series">
        <input id="series" name="series" value="series">
    </label></br>
    <label for="model">
        <input id="model" name="model" value="model">
    </label></br>
    <input type="submit" value="inside car in DB">
</form>
</br>
</br>

</body>
</html>

