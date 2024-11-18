# Online Pet Adoption Platform

The **Online Pet Adoption Platform** is a web-based Java application designed to connect potential pet adopters with shelters and rescue organizations. The platform enables users to browse available pets, learn about their backgrounds, and apply for adoption directly through the website. Shelters can list their animals, providing detailed profiles, medical information, and adoption status updates.

## Key Features

- **User Registration & Authentication**: Allows users to sign up, log in, and manage their profiles.
- **Pet Listings**: Shelters can create detailed pet profiles with images, descriptions, age, breed, and adoption status.
- **Search & Filter**: Users can search for pets based on breed, age, size, and location.
- **Pet Details**: View detailed pet profiles including health records, adoption requirements, and images.
- **Adoption Application**: Interested adopters can submit adoption applications with personal information and home environment details.
- **Admin Dashboard**: Admin users can manage shelters, monitor adoption applications, and approve/reject applications.
- **Shelter Management**: Shelters can manage their listings, update adoption statuses, and communicate with adopters.

## Technologies Used

- **Backend**: Java (JDBC for MySQL database interaction)
- **Database**: MySQL (for storing user profiles, pet listings, and adoption applications)
- **Logging**: SLF4J and Logback for logging
- **Build Tool**: Maven (for project management and dependencies)

## Setup Instructions

### Prerequisites

1. **Java**: Ensure you have **Java 8** or higher installed. You can check your version with the following command:
   ```bash
   java -version
