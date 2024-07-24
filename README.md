# Poultry Farm Application

A comprehensive management system for poultry farms, built using Spring Boot and PostgreSQL.


## Getting Started

This project is a starting point for a Spring Boot application to manage poultry farms.

### Prerequisites

Before you begin, ensure you have met the following requirements:
- You have installed the latest version of Java
- You have installed PostgreSQL
- You have installed Maven

### Installing

To install the project, follow these steps:

1. Clone the repository
    ```bash
    git clone https://github.com/yourusername/Poultry-Farm.git
    ```
2. Navigate to the project directory
    ```bash
    cd poultryfarm
    ```
3. Configure the database:
    ```bash
    CREATE DATABASE broiler_farm;
    CREATE USER postgres WITH ENCRYPTED PASSWORD 'halohalo123';
    GRANT ALL PRIVILEGES ON DATABASE broiler_farm TO postgres;

    ```
4. date the database configuration in src/main/resources/application.properties:
    ```bash
    spring.datasource.url=jdbc:postgresql://localhost:5432/broiler_farm
    spring.datasource.username=postgres
    spring.datasource.password=Kutubutara123
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    
    # Server Configuration
    server.port=8080
    logging.level.org.springframework=DEBUG
    logging.file.name=application.log
    ```
    
    
### Running the Project

To run the project on an emulator or physical device, follow these steps:

1. Ensure PostgreSQL is running
2. Build and run the project
    ```bash
    ./mvnw spring-boot:run
    ```

### API Documentation

you can use tester endpoint like postman or CURL

- Register POST /api/users/register
  - Request Body json
    ```bash
{
  "username": "admin",
  "password": "password"
  "role": "ADMIN" // Role should be either 'ADMIN', 'PETUGAS', or 'PETERNAK'
}
    ```
