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

        try (PreparedStatement bookStatement = conn.prepareStatement("SELECT * " +
                "FROM `adbadfb_books`")) {
            ResultSet rs = bookStatement.executeQuery();
            //format the table header
            out.print(
                    "<table>" +
                            "<tr>" +
                            "<th>ISBN-13</th>" +
                            "<th>Book Name</th>" +
                            "<th>Author</th>" +
                            "<th>Units On Hand</th>" +
                            "<th>Unit Price</th>" +
                            "<th>Buy</th>" +
                            "</tr>" +
                            "<form action=\"CartServlet\" method=\"post\">"
            );

            while (rs.next()) {

//https://www.html5tutorial.info/html5-number.php
                out.print(

                                "<tr>" +
                                "<td>" + rs.getString(2) + "</td>" +    //ISBN
                                "<td>" + rs.getString(3) + "</td>" +    //Book Name
                                "<td>" + rs.getString(4) + "</td>" +    //Author
                                "<td>" + rs.getString(7) + "</td>" +    //Units on Hand
                                "<td>$ " + rs.getString(8) + "</td>" +  //Unit Price
                                //Buy Section, number input box
                                "<td><label for=\"inputNumOfBooks\"> Number of Books to Purchase: " +
                                "</label><input id=\"inputNumOfBooks_" + rs.getString(2) + "type=\"number\" value=\"0\"/>" +
                                "</td>" +
                                "</tr>"
                );

            } //end while
            out.print("</table>" +
                    "<br><br>" +
                    "<input type=\"submit\" value=\"Add to cart\">" +
                    "</form>"); //close book table

        } catch (SQLException exc) {
            exc.printStackTrace();
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/books.jsp");
        rd.include(request, response);
    }
}


