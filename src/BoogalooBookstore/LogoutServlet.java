package BoogalooBookstore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //invalidate the session if it exists, redirect to index
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
