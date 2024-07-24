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
    spring.datasource.password=halohalo123
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    
    # Server Configuration
    server.port=8080
    logging.level.org.springframework=DEBUG
    logging.file.name=application.log
    ```
### Project Structure
    ```bash
        .mvn
        src
          └── main
              └── java/com/example/poultryfarm
                  ├── config
                  │   ├── JwtRequestFilter.java
                  │   ├── RestTemplateConfig.java
                  │   ├── SecurityConfig.java
                  │   └── SwaggerConfig.java
                  ├── controller
                  │   ├── AuthController.java
                  │   ├── FarmController.java
                  │   ├── HealthReportController.java
                  │   ├── InventoryController.java
                  │   ├── LowStockNotificationController.java
                  │   ├── PerformanceReportController.java
                  │   ├── ScheduleController.java
                  │   ├── TaskController.java
                  │   ├── TaskNotificationController.java
                  │   └── UserController.java
                  ├── dto
                  │   ├── HealthReportDTO.java
                  │   ├── LowStockNotificationRequest.java
                  │   ├── ScheduleRequest.java
                  │   ├── TaskDto.java
                  │   └── TaskNotificationDto.java
                  ├── model
                  │   ├── AuthenticationRequest.java
                  │   ├── AuthenticationResponse.java
                  │   ├── Farm.java
                  │   ├── HealthReport.java
                  │   ├── Inventory.java
                  │   ├── InventoryRequest.java
                  │   ├── LowStockNotification.java
                  │   ├── PerformanceReport.java
                  │   ├── Role.java
                  │   ├── Schedule.java
                  │   ├── Task.java
                  │   ├── TaskNotification.java
                  │   └── User.java
                  ├── repository
                  │   ├── FarmRepository.java
                  │   ├── HealthReportRepository.java
                  │   ├── InventoryRepository.java
                  │   ├── LowStockNotificationRepository.java
                  │   ├── PerformanceReportRepository.java
                  │   ├── ScheduleRepository.java
                  │   ├── TaskNotificationRepository.java
                  │   ├── TaskRepository.java
                  │   └── UserRepository.java
                  ├── service
                  │   ├── FarmService.java
                  │   ├── HealthReportService.java
                  │   ├── InventoryService.java
                  │   ├── LowStockNotificationService.java
                  │   ├── PerformanceReportService.java
                  │   ├── ScheduleService.java
                  │   ├── TaskNotificationService.java
                  │   ├── TaskService.java
                  │   └── UserService.java
                  ├── util
                  │   └── JwtUtil.java
                  └── PoultryfarmApplication.java
          └── resources
        test
          └── java/com/example/poultryfarm
        .gitignore
        application.log
        application.log.2024-07-22.0.gz
        application.log.2024-07-23.0.gz
        mvnw
        mvnw.cmd
        pom.xml
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
1. Register
- Register POST /api/users/register
  - Request Body json
    ```bash
    {
      "username": "admin",
      "password": "password"
      "role": "ADMIN" // Role should be either 'ADMIN', 'PETUGAS', or 'PETERNAK'
    }
    ```
- Update User PUT /api/users/{id}
  - Request Body json
    ```bash
    {
      "username": "your_new_username",
      "password": "your_new_password",
      "role": "ADMIN"
    }


- Get all user /api/users
- Get User by id /api/users/{id}
- Delete User /api/users/{id}

2. Login
- Login POST /api/auth/login
  - Request Body json
    ```bash
    {
      "username": "your_username",
      "password": "your_password"
    }

    ```
    - Response
    ```bash
    {
      "jwt": "your_jwt_token"
    }

    ```
3. Add Farm
- Add Farm POST /api/farms
  - Request Body json
    ```bash
    {
      "name": "Farm Name",
      "location": "Farm Location",
      "ownerId": 1 // ID of the owner (user)
    }

    ```
- Get All Farms /api/farms
   
4. Add Health Report

-URL: /api/health-reports
  - Request Body json
    ```bash
    {
      "farmId": 1,
      "reportDate": "2024-07-23",
      "description": "Health report description"
    }

    ```
  
- Get All Health Reports

    - URL: /api/health-reports
 
5. Add Inventory

- URL: /api/inventories
  - Request Body json
    ```bash
    {
      "farmId": 1,
      "itemName": "Item Name",
      "quantity": 100,
      "itemType": "pakan" // or "obat"
    }

    ```

  
- Get All Inventories

    - URL: /api/inventories
 
6. Add Low Stock Notification

 - URL: /api/low-stock-notifications
  - Request Body json
    ```bash
    {
      "inventoryId": 1,
      "notificationDate": "2024-07-23",
      "message": "Low stock message"
    }

    ```

  
- Get All Low Stock Notifications

  - URL: /api/low-stock-notifications

7. Add Performance Report

 - URL: /api/performance-reports
  - Request Body json
    ```bash
    {
      "farmId": 1,
      "reportDate": "2024-07-23",
      "details": "Performance details"
    }

    ```

  
- Get All Performance Reports

 - URL: /api/performance-reports

8. Add Schedule

 - URL: /api/schedules
  - Request Body json
    ```bash
    {
      "farmId": 1,
      "activity": "Task Name",
      "date": "2024-07-23"
    }

    ```
- Get All Schedules

 - URL: /api/schedules
   
9. Add Task

 - URL: /api/tasks
  - Request Body json
    ```bash
    {
      "farmId": 1,
      "taskDescription": "Task Description",
      "dueDate": "2024-07-23",
      "status": "pending" // Status could be 'pending', 'in_progress', or 'completed'
    }

    ```
- Get All Tasks

 - URL: /api/tasks

10. Add Task Notification

 - URL: /api/task-notifications
  - Request Body json
    ```bash
    {
      "taskId": 1,
      "notificationDate": "2024-07-23",
      "message": "Notification message"
    }

    ```
-Get All Task Notifications

 - URL: /api/task-notifications

    
