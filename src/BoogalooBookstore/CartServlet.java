package BoogalooBookstore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

@WebServlet(name = "CartServlet", urlPatterns = "/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MySQLConnectionHandler connHandler = new MySQLConnectionHandler();
        Connection conn = connHandler.connection;
        PreparedStatement prepStatement = null;
        //get request params for book fields


        Enumeration paramNames = request.getParameterNames();


        try {
            prepStatement = conn.prepareStatement(
                    "INSERT INTO `asdlkgjhadgba_cart`" +
                            "(`ISBN-13`, `number_in_cart`, `unit_price`)" +
                            "VALUES (?, ?, ?)");
            int i = 1;
            while (paramNames.hasMoreElements()) {

                String paramName = (String) paramNames.nextElement();
                String paramValue = request.getHeader(paramName);
                prepStatement.setString(i, paramValue);
                i += 1;
                if (i == 3) {
                    //janky way to reset i back to 1 after we've inputted the three variables. It's dumb I know -Eric
                    i = 1;
                }
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }

        //Send back to book, should show cart below books table once the cart is not empty
        response.sendRedirect(request.getContextPath() + "/books.jsp");
    }
}
