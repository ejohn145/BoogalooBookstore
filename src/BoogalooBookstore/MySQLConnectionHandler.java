package BoogalooBookstore;


import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionHandler {

    Connection connection;

    MySQLConnectionHandler() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/boogaloo_bookstore?useSSL=false",
                    "BoogalooBookstore_admin",
                    "BoogalooBookstore_admin");

        } catch (Exception exc) {
            System.out.println("MySQLConnectionHandler: " + exc.getMessage());
        }
    }

}
