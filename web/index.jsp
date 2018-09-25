<%--
  Created by IntelliJ IDEA.
  User: Flidro
  Date: 9/7/2018
  Time: 2:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Boogaloo Bookstore - Login Page</title>
    <h1>Boogaloo Bookstore</h1>
    <h3> Please Login</h3>
</head>

<body>

<form action="RegisterServlet" method="post">
    <h4>Register:</h4>
    Username: <input type="text" name="username"> <br/>
    Email: <input type="text" name="email"> <br/>
    Password: <input type="password" name="password"> <br/>
    <input type="submit" value="Login">
</form>

<form action="LoginServlet" method="post">
    <h3>Sign in:</h3>
    Username: <input type="text" name="username"> <br/>
    Password <input type="password" name="password"> <br/>
    <input type="submit" value="Login">
</form>


</body>
</html>
