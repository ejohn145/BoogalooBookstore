package BoogalooBookstore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get request parameters for username and password
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        MySQLConnectionHandler connHandler = new MySQLConnectionHandler();
        Connection conn = connHandler.connection;
        PreparedStatement prepStatement = null;

        try {
            prepStatement = conn.prepareStatement(
                    "INSERT INTO `asdfaser_users`(`username`, `email`, `password`) VALUES (?, ?, ?)");
            prepStatement.setString(1, username);
            prepStatement.setString(2, email);
            prepStatement.setString(3, password); //Todo Hash and salt ???
            prepStatement.execute();
        } catch (SQLException exc) {
            System.out.println("SQLException: " + exc.getMessage());
        } catch (Exception exc) {
            System.out.println("Exception: " + exc.getMessage());
            System.out.println(exc);
        } finally {
            //closing resources
            if (prepStatement != null) {
                try {
                    prepStatement.close();
                } catch (SQLException ignored) {
                }//ignore
                prepStatement = null;
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignored) {
                }//ignore
                conn = null;
            }
        }

        //invalidate old session
        HttpSession oldSession = request.getSession(false);
        if (oldSession != null) {
            oldSession.invalidate();
        }

        //generate a new session
        HttpSession newSession = request.getSession(true);

        //session expires after 5 minutes
        newSession.setMaxInactiveInterval(5 * 60);

        //create a cookie for the session and set max age to 30 minutes
        Cookie message = new Cookie("message", "Welcome");
        message.setMaxAge(30 * 60);
        response.addCookie(message);
        response.sendRedirect("/LoginSuccess.jsp");
    }
}