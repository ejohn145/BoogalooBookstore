package BoogalooBookstore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckoutServlet", urlPatterns = "/Checkout")
public class CheckoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.print("<h1>Hello! This is the Checkout page. It's still under development and the button probably doesn't work.</h1>");

        out.print("<form action\"Checkout\" method=\"post\">" +
                "<h3> Checkout </h3>" +
                "Credit Card: " + "<input type=\"text\" name=\"creditCard\"><br>" +
                "CSV: (3 numbers on back of card: " + "<input type=\"text\" name=\"CSV\"><br>" +
                "<h3>Delivery Address: </h3>"    +
                "\t Street Address: " + "<input type=\"text\" name=\"streetAddress\"><br>" +
                "\t City: " + "<input type=\"text\" name=\"cityAddress\"><br>" +
                "\t State: " + "<input type=\"text\" name=\"stateAddress\"><br>" +
                "\t ZIP: " + "<input type=\"text\" name=\"zipAddress\"><br>" +
                "<input type=\"submit\" value=\"Process Payment\">" +
                "</form>"
        ); //end  print CHECKOUTFORM

        //putting logout button on page
        out.print("<br><br>" +
                "<form action=\"LogoutServlet\" method=\"post\">\n" +
                "    <input type=\"submit\" value=\"Logout\">\n" +
                "</form>"); //end print LOGOUT BUTTON
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
