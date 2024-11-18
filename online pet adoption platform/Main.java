// Main.java

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            // Test database connection
            TestConnection.testDBConnection();

            // Create DAO objects
            PetDAO petDAO = new PetDAO();
            InventoryDAO inventoryDAO = new InventoryDAO();

            // Example: Fetching all pets
            List<Pet> pets = petDAO.getAllPets();
            System.out.println("All pets:");
            for (Pet pet : pets) {
                System.out.println(pet);
            }

            // Example: Fetching available pets for adoption
            List<Pet> availablePets = inventoryDAO.getAvailablePets();
            System.out.println("Available pets for adoption:");
            for (Pet pet : availablePets) {
                System.out.println(pet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
