// DBConnection.java

import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/pet_adoption_platform";
    private static final String USER = "root";  // Change to your DB username
    private static final String PASSWORD = "";  // Change to your DB password

    // Method to get a database connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database.");
        }
    }
}
