<%@ page import="BoogalooBookstore.MySQLConnectionHandler" %><%--
  Created by IntelliJ IDEA.
  User: EricJ
  Date: 9/21/2018
  Time: 4:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<%
    String message = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("message")) message = cookie.getValue();
            if (cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
    }

%>


<h3>Login Success</h3>
<h4><%=message%>
</h4>
<h4>Session Id = <%=sessionID %>
</h4>
<br><br>

<form action="Books" method="post">
    <input type="submit" value="Go To Books">
</form>
<form action="LogoutServlet" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>
