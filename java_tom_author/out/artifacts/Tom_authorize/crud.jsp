
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>crud</title>
    <h4>Hello, It's Admin page</h4>

</head>
<body>

<form method="post" action="/deleteUsers">
    <table>
        <tr>
            <th>id</th>
            <th>login</th>
            <th>password</th>
            <th>country</th>
            <th>role</th>
        </tr>
        <c:forEach items="${usersInJDBC}" var="User">
            <tr>
                <th>${User.id}</th>
                <th>${User.login}</th>
                <th>${User.password}</th>
                <th>${User.country}</th>
                 <th>${User.role}</th>


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
<%--<h5>Cool</h5>
</br>
</br>--%>
<h4>add User in dataBase</h4>
<form method="post" action="/admin">
    <label for="login">login
        <input id="login" name="login" value="">
    </label>
    <label for="password">password
        <input id="password" name="password" value=""  >
    </label>
    <label for="country">country
        <input id="country" name="country" value="">
    </label>
    <select name="role" size="" >
        <option selected value="user">user</option>
        <option selected value="admin">admin</option>
    </select></br>
    <input type="submit" value="inside in JDBC">
</form>



</body>
</html>
<%--</body>
</html>--%>
