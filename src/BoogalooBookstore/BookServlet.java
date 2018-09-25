package BoogalooBookstore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "BookServlet", urlPatterns = "/Books")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MySQLConnectionHandler connHandler = new MySQLConnectionHandler();
        Connection conn = connHandler.connection;
        PrintWriter out = response.getWriter();

        try (PreparedStatement statement = conn.prepareStatement("SELECT * " +
                "FROM `adbadfb_books`")) {
            ResultSet rs = statement.executeQuery();
            out.print(
                    "<table>" +
                            "<tr>" +
                            "<th>ISBN-13</th>" +
                            "<th>Book Name</th>" +
                            "<th>Author</th>" +
                            "<th>Units On Hand</th>" +
                            "<th>Unit Price</th>" +
                            "<th>Buy</th>" +
                            "</tr>"
            );

            while (rs.next()) {


                out.print(

                        "<tr>" +
                                "<td>" + rs.getString(2) + "</td>" +
                                "<td>" + rs.getString(3) + "</td>" +
                                "<td>" + rs.getString(4) + "</td>" +
                                "<td>" + rs.getString(7) + "</td>" +
                                "<td>$ " + rs.getString(8) + "</td>" +
                                "<td>placeholder buy button</td>" +
                                "</tr>"

                );

            }
            out.print("</table>");


            RequestDispatcher rd = getServletContext().getRequestDispatcher("/LoginSuccess.jsp");
            rd.include(request, response);
        } catch (SQLException exc) {
            exc.printStackTrace();
        }


    }
}


