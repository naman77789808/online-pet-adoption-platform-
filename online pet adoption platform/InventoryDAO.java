// InventoryDAO.java

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {

    private Connection connection;

    public InventoryDAO() {
        connection = DBConnection.getConnection();
    }

    // Method to get all pets that are available for adoption
    public List<Pet> getAvailablePets() throws SQLException {
        List<Pet> pets = new ArrayList<>();
        String query = "SELECT * FROM pets WHERE adoption_status = 'Available'";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Pet pet = new Pet(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("breed"),
                        rs.getInt("age"),
                        rs.getString("description"),
                        rs.getString("image")
                );
                pets.add(pet);
            }
        }
        return pets;
    }
}
