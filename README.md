# 🚗 Route Scheduling System - Spring Boot Backend

> A REST API for managing route scheduling between drivers and routes, built with Spring Boot and MySQL.

---

## Prerequisites

- Java 17+
- Maven 3.6+
- MySQL Server app
- Postman (for testing)

## Setup Instructions

1. **Clone the repository:**
   ```powershell
   git clone https://github.com/1Menna/Route-Scheduling-System---Spring-Boot-Backend.git
   ```

2. **Navigate to the project directory:**
   ```powershell
   cd backend_springboot_task
   ```

3. **Run the application:**
   ```powershell
   ./mvnw clean spring-boot:run
   ```

The application will start on `http://localhost:8080`

## Database Setup

1. **Start MySQL Workbench app**

2. **Create database:**
   ```sql
   CREATE DATABASE DRBdb;
   ```

3. **Create Tables:**
   ```sql
   USE DRBdb;
   
   CREATE TABLE driver (
       id INT,
       name VARCHAR(20),
       license_type VARCHAR(20),
       availability BOOL,
       assigned_routes JSON
   );
   
   CREATE TABLE route (
       id INT AUTO_INCREMENT PRIMARY KEY,
       start_location VARCHAR(255),
       end_location VARCHAR(255),
       distance DECIMAL(8,3),
       estimated_time DECIMAL(8,3)
    );
   
   CREATE TABLE schedule (
       id INT AUTO_INCREMENT PRIMARY KEY,
       route_id INT,
       driver_id INT,
       driver_name VARCHAR(20)
   );
   ```

4. **Update application.properties with your MySQL credentials:**
   ```properties
   spring.application.name=backend_springboot_task
   spring.datasource.url=jdbc:mysql://localhost:3306/DRBdb
   spring.datasource.username=root
   spring.datasource.password=YourPassword
   ```

## API Endpoints

| Method | Endpoint | Description | Example Input | Query Parameters |
|--------|---------|-------------|---------------|------------------|
| POST   | /drivers | Add a new driver | { "id": 122, "name": "John Doe", "licenseType": "B", "availability": true } | - |
| GET    | /drivers | Get all drivers | - | - |
| GET    | /drivers/{id} | Get all assigned route IDs for a specific driver | - | - |
| POST   | /routes | Add a new route | { "startLocation": "Cairo", "endLocation": "Alexandria", "distance": 220.5, "estimatedTime": 3.5 } | - |
| GET    | /routes | Get all routes with pagination | - | `page=0` (default), `size=5` (default) |
| GET    | /schedule | Recalculate and return driver-route assignments | - | - |


## Features Implemented

- ✅ Add and manage drivers with availability status
- ✅ Create and retrieve routes with distance/time details
- ✅👌**BONUS** Paginated route retrieval with configurable page size
- ✅ Automatic driver-route assignment scheduling
- ✅👌**BONUS** JSON array support for tracking assigned routes for each driver
- ✅ Database persistence with MySQL
- ✅ Schedule recalculation that resets driver availability

### Pagination Examples for /routes endpoint:
- Get first page (default): `GET /routes`
- Get first page with 10 items: `GET /routes?size=10`
- Get second page with 5 items: `GET /routes?page=1&size=5`
- Get third page with custom size: `GET /routes?page=2&size=3`

## Assumptions Made

1. *Driver IDs*: Manually assigned (not auto-generated)
2. *Route IDs*: Auto-generated using database identity
3. *Schedule Logic*: Each driver can handle only one active route
4. *Availability Reset*: /schedule endpoint resets all drivers to available before reassigning
5. *Assignment Strategy*: First-come, first-served basis for available drivers
6. *Database*: MySQL chosen for JSON column support and reliability
7. *Route Assignment*: Unassigned routes remain unscheduled if no drivers available
8. *Pagination*: Routes endpoint returns paginated results with default page size of 5