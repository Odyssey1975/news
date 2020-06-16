<%--
  Author: Pavel Ravvich.
  Date: 14.10.17.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

</head>
<body>

    <div class="form">

        <h1>Вход в систему</h1><br>
        <form method="post" action="">

            <input type="text"  placeholder="login" name="login"><br>
            <input type="password"  placeholder="password" name="password"><br><br>
            <input class="button" type="submit" name="reg" value="Enter">
            <input class="button" type="submit" name="reg" value="Registration">

        </form>
    </div>
</body>
</html>
