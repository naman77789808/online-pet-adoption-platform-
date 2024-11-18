# Online Pet Adoption Platform

## Project Description
The **Online Pet Adoption Platform** is a web-based application designed to connect potential pet adopters with shelters and rescue organizations to facilitate the adoption of pets. The platform provides a user-friendly interface where users can browse available pets, learn about their backgrounds, and apply for adoption directly through the website. It also allows shelters and rescue organizations to list their animals, providing detailed profiles, medical information, and adoption status updates.

## Key Features
- **User Registration & Authentication**: Users can sign up, log in, and manage their profiles. This allows adopters to track their adoption applications and shelters to manage pet listings.
- **Pet Listings**: Shelters can create detailed pet profiles that include images, descriptions, age, breed, medical history, and adoption status.
- **Search & Filter**: Potential adopters can search for pets based on various criteria such as breed, age, size, and location.
- **Pet Details**: Users can view detailed information about each pet, including photos, health records, and adoption requirements.
- **Adoption Application**: Interested adopters can submit adoption applications, including personal information and answers to questions about their home environment.
- **Admin Dashboard**: Admin users can manage shelters, monitor adoption applications, approve/reject applications, and ensure that pets are successfully rehomed.
- **Shelter Management**: Shelters can manage their pet listings, update adoption status, and communicate with adopters.

## Technologies Used
- **Frontend**: React.js for building a dynamic, responsive user interface.
- **Backend**: Node.js with Express for handling API requests and server-side logic.
- **Database**: MongoDB for storing user profiles, pet listings, and adoption applications.
- **Authentication**: JWT (JSON Web Tokens) for secure user authentication.
- **Cloud Storage**: AWS S3 for storing pet images.
- **Deployment**: The platform is hosted on AWS or similar cloud service providers to ensure scalability and reliability.

## Database Schema
users table<br>
pets table<br>
Adoption Applications Table<br>
Shelters Table<br>
Admin Logs Table<br>




```sql
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role ENUM('adopter', 'admin') NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    address_street VARCHAR(255),
    address_city VARCHAR(255),
    address_state VARCHAR(255),
    address_zip_code VARCHAR(20),
    address_country VARCHAR(255),
    phone_number VARCHAR(20),
    adoption_history TEXT, -- JSON or comma-separated pet IDs
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE pets (
    pet_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    species VARCHAR(100) NOT NULL,
    breed VARCHAR(100),
    age INT,
    size ENUM('Small', 'Medium', 'Large'),
    color VARCHAR(100),
    medical_history TEXT, -- JSON or comma-separated list
    adoption_status ENUM('Available', 'Pending', 'Adopted') DEFAULT 'Available',
    adopted_by INT, -- FK to users (NULL if available for adoption)
    adopted_at TIMESTAMP NULL,
    shelter_id INT, -- FK to shelters table
    image_url VARCHAR(255),
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (adopted_by) REFERENCES users(user_id),
    FOREIGN KEY (shelter_id) REFERENCES shelters(shelter_id)
);
CREATE TABLE adoption_applications (
    application_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT, -- FK to users table
    pet_id INT, -- FK to pets table
    application_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending',
    home_environment TEXT, -- Description of the adopter's home
    experience_with_pets TEXT, -- Adopter's experience
    other_pets BOOLEAN, -- Whether the adopter has other pets
    children BOOLEAN, -- Whether the adopter has children
    work_schedule TEXT, -- Adopter's work schedule
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (pet_id) REFERENCES pets(pet_id)
);
CREATE TABLE shelters (
    shelter_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address_street VARCHAR(255),
    address_city VARCHAR(255),
    address_state VARCHAR(255),
    address_zip_code VARCHAR(20),
    address_country VARCHAR(255),
    phone_number VARCHAR(20),
    email VARCHAR(255),
    website VARCHAR(255),
    contact_name VARCHAR(255),
    contact_email VARCHAR(255),
    contact_phone VARCHAR(20),
    pet_count INT DEFAULT 0, -- Number of pets currently available
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE admin_logs (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    admin_id INT, -- FK to users table (admins only)
    action_type ENUM('Create', 'Update', 'Delete', 'Approve', 'Reject') NOT NULL,
    action_details TEXT, -- Description of the action (e.g., "Updated pet description")
    affected_pet_id INT, -- FK to pets table (nullable)
    affected_user_id INT, -- FK to users table (nullable)
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (admin_id) REFERENCES users(user_id),
    FOREIGN KEY (affected_pet_id) REFERENCES pets(pet_id),
    FOREIGN KEY (affected_user_id) REFERENCES users(user_id)
);

 
