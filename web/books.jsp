<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="BoogalooBookstore.MySQLConnectionHandler" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: Flidro
  Date: 9/25/2018
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
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
<%
    MySQLConnectionHandler connHandler = new MySQLConnectionHandler();
    Connection conn = connHandler.connection;
    //Print out cart
    try (PreparedStatement cartStatement = conn.prepareStatement("SELECT * " +
                    "FROM `asdlkgjhadgba_cart`")) {
        ResultSet rs = cartStatement.executeQuery();


            //format the table header
            out.print(
                    "<br><br>" +
                            "Your Cart" +
                            "<table>" +
                            "<tr>" +
                            "<th>ISBN-13</th>" +
                            "<th>Number In Cart</th>" +
                            "<th>Unit Price</th>" +
                            "</tr>"
            );

            while (rs.next()) {
                out.print(

                        "<tr>" +
                                "<td>" + rs.getString(3) + "</td>" +    //ISBN
                                "<td>" + rs.getString(4) + "</td>" +    //Number in Cart
                                "<td>" + rs.getString(5) + "</td>" +    //Unit Price
                                "</tr>"
                );
            }
            out.print("</table>"); //close cart table

    } catch (SQLException exc) {
        exc.printStackTrace();
    }
%>
<form action="Checkout" method="post">
    <input type="submit" value="Checkout">
</form>
<br><br><br>
<form action="LogoutServlet" method="post">
    <input type="submit" value="Logout">
</form>


</body>
</html>
