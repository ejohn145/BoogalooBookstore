package BoogalooBookstore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //todo refactor into it's own class
        MySQLConnectionHandler connHandler = new MySQLConnectionHandler();
        Connection conn = connHandler.connection;

        //get request params for username and psasword, initialize salt and passwordHash
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        byte[] passwordHash = new byte[32];
        byte[] salt = new byte[32];

        try (PreparedStatement statement = conn.prepareStatement("SELECT `password`, `salt`" +
                "FROM `asdfaser_users` WHERE `username` = ?")) {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            rs.next();
            passwordHash = MySQLConnectionHandler.stringToByte(rs.getString("password"));
            salt = MySQLConnectionHandler.stringToByte(rs.getString("salt"));
        } catch (SQLException exc) {
            exc.printStackTrace();
        }

        byte[] generatedHash = new byte[32];
        try {
            generatedHash = MySQLConnectionHandler.getHashWithSalt(password, "SHA-256", salt);
        } catch (NoSuchAlgorithmException exc) {
            exc.printStackTrace();
        }

        //Check generatedHash against passwordHash. If good, then invalidate previous session
        // if there is one and create a new session and cookie. Afterwards, redirect to LoginSuccess
        // If rejected, then return to index page and prompt again
        if (Arrays.equals(generatedHash, passwordHash)) {
            //get old session and invalidate
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            //create a new session
            HttpSession newSession = request.getSession(true);

            //set new session to expire after 15 minutes
            newSession.setMaxInactiveInterval(15 * 60);

            //Create cookie
            Cookie message = new Cookie("message", "Welcome");
            response.addCookie(message);
            response.sendRedirect(request.getContextPath() + "/LoginSuccess.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher(request.getContextPath() + "/index.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color = red>Either username or password is wrong. Please try again.</font>");
            rd.include(request, response);

        }
    }
}
