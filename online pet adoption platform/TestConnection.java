import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void testDBConnection() {
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Database connection established successfully!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database.");
            e.printStackTrace();
        }
    }
}
