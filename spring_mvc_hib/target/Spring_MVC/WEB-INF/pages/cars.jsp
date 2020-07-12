
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<body>
<table>
    <tr>
        <td>Series</td>
        <td>Model</td>
        <td>Color</td>

    </tr>
    <c:forEach items="${carFromServer}" var="Car">
        <tr>
            <th>${Car.series}</th>
            <th>${Car.model}</th>
            <th>${Car.color}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
