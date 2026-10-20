# Student Management Backend

## Project Description

A REST API-based Student Management System developed using Spring Boot, Spring Security, JWT Authentication, Spring Data JPA, Hibernate, and MySQL.

## Technologies Used

- Java 21
- Spring Boot
- Spring Web
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman
- Git

## Features

- User registration
- User login with JWT token generation
- Secure student APIs
- Add a student
- View all students
- View a student by ID
- Update student details
- Delete a student
- MySQL database integration

## Database Configuration

1. Install and start MySQL.
2. Create the database:

   CREATE DATABASE student_management;

3. Configure the MySQL username and password in `src/main/resources/application.properties`.
4. Hibernate automatically creates and updates entity tables.

## Run the Project

On Windows, open a terminal in the project root and execute:

    .\mvnw.cmd clean compile
    .\mvnw.cmd spring-boot:run

The application runs at:

    http://localhost:8080

## API Endpoints

| Method | Endpoint           | Purpose               |
| ------ | ------------------ | --------------------- |
| POST   | /api/auth/register | Register a user       |
| POST   | /api/auth/login    | Login and receive JWT |
| POST   | /api/students      | Add a student         |
| GET    | /api/students      | View all students     |
| GET    | /api/students/{id} | View student by ID    |
| PUT    | /api/students/{id} | Update a student      |
| DELETE | /api/students/{id} | Delete a student      |

Student APIs require a valid JWT Bearer token.

## API Testing

The APIs are tested using Postman.
