package BoogalooBookstore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //todo refactor into it's own class
        MySQLConnectionHandler connHandler = new MySQLConnectionHandler();
        Connection conn = connHandler.connection;

        //get request params for username and psasword
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (PreparedStatement statement = conn.prepareStatement("SELECT `username`, `email`, `password`, `user_id`, `first_name`, `last_name`, `delivery_address`, `delivery_city`, `delivery_state`, `delivery_zip`" +
                "FROM `asdfaser_users` WHERE `username` = ?")) {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
//            rs.next();

            if (rs.next()) {
                if (password.equals(rs.getString(3)) && username.equals(rs.getString(1))) {
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
                    response.sendRedirect("/LoginSuccess.jsp");
                } else {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<font> Either username or password is wrong. Please try again.</font>");
                    rd.include(request, response);

                }
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                PrintWriter out = response.getWriter();
                out.println("<font>Either username or password is wrong. Please try again.</font>");
                rd.include(request, response);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
