// PetDAO.java

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {

    private Connection connection;

    public PetDAO() {
        connection = DBConnection.getConnection();
    }

    // Method to add a new pet to the database
    public void addPet(Pet pet) throws SQLException {
        String query = "INSERT INTO pets (name, breed, age, description, image) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, pet.getName());
            stmt.setString(2, pet.getBreed());
            stmt.setInt(3, pet.getAge());
            stmt.setString(4, pet.getDescription());
            stmt.setString(5, pet.getImage());
            stmt.executeUpdate();
        }
    }

    // Method to get all pets from the database
    public List<Pet> getAllPets() throws SQLException {
        List<Pet> pets = new ArrayList<>();
        String query = "SELECT * FROM pets";
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

    // Method to get a specific pet by ID
    public Pet getPetById(int id) throws SQLException {
        String query = "SELECT * FROM pets WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pet(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("breed"),
                            rs.getInt("age"),
                            rs.getString("description"),
                            rs.getString("image")
                    );
                }
            }
        }
        return null;
    }
}
