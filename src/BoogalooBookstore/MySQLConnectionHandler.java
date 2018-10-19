package BoogalooBookstore;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionHandler {
    //method to generate salt based on what is inputted for security
    //used in RegisterServlet
    static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[32];
        random.nextBytes(bytes);
        return bytes;
    }

    //used in RegisterServlet
    static String byteToString(byte[] input) {
        return Base64.encodeBase64String(input);
    }

    static byte[] getHashWithSalt(String input, String technique, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(technique);
        digest.reset();
        digest.update(salt);
        byte[] hashedBytes = digest.digest(stringToByte(input));
        return hashedBytes;
    }

    static byte[] stringToByte(String input) {
        if (Base64.isBase64(input)) {
            return Base64.decodeBase64(input);
        } else {
            return Base64.encodeBase64(input.getBytes());
        }
    }

    //Constructor for a connection with the BoogalooBookstore Database
    public Connection connection;

    public MySQLConnectionHandler() {
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
