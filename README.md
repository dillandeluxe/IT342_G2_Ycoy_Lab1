# 🔐 User Authentication System

A full-stack user authentication system with JWT implementation, featuring a Spring Boot backend, React web frontend, and Android mobile application.

---

## 📋 Table of Contents
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Running the Application](#-running-the-application)
- [API Endpoints](#-api-endpoints)
- [Development Status](#-development-status)
- [Team](#-team)

---

## ✨ Features

- **User Registration** - Secure account creation with email validation
- **User Login** - JWT-based authentication with encrypted passwords
- **Protected Dashboard** - Token-protected user interface
- **Logout Functionality** - Secure session termination
- **Password Encryption** - BCrypt password hashing
- **JWT Token Management** - Stateless authentication using JSON Web Tokens
- **Cross-Platform Support** - Web and mobile applications (Android in development)

---

## 🛠️ Tech Stack

### Backend
- **Framework:** Spring Boot 3.5.10
- **Language:** Java 17
- **Database:** MySQL
- **Security:** Spring Security with JWT (JJWT 0.12.6)
- **ORM:** Spring Data JPA with Hibernate
- **Build Tool:** Maven

### Frontend (Web)
- **Framework:** React 19.2.4
- **Routing:** React Router DOM 7.13.0
- **HTTP Client:** Axios 1.13.5
- **Build Tool:** React Scripts 5.0.1

### Mobile (In Development)
- **Platform:** Android
- **Build System:** Gradle
- **Language:** Java/Kotlin

---

## 📁 Project Structure

```
IT342_G2_Ycoy_Lab1/
├── backend/                # Spring Boot REST API
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/Ycoy/UserAuth/
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── JwtUtil.java
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   ├── User.java
│   │   │   │   ├── UserRepository.java
│   │   │   │   └── dto/
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   └── pom.xml
├── web/                    # React web application
│   ├── src/
│   │   ├── App.js
│   │   ├── Login.js
│   │   ├── Register.js
│   │   └── Dashboard.js
│   └── package.json
├── mobile/                 # Android application
│   └── app/
├── docs/                   # Documentation
├── README.md
└── TASK_CHECKLIST.md
```

---

## 📦 Prerequisites

Before running this project, ensure you have the following installed:

- **Java Development Kit (JDK) 17+**
- **Maven 3.6+**
- **Node.js 16+** and **npm 8+**
- **MySQL 8.0+**
- **Git**

---

## 🚀 Installation

### 1. Clone the Repository
```bash
git clone https://github.com/your-org/IT342_G2_Ycoy_Lab1.git
cd IT342_G2_Ycoy_Lab1
```

### 2. Database Setup
Create a MySQL database:
```sql
CREATE DATABASE lab1_db;
```

Update database credentials in `backend/src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/lab1_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Backend Setup
```bash
cd backend
mvnw clean install
```

### 4. Frontend Setup
```bash
cd web
npm install
```

---

## ▶️ Running the Application

### Start Backend Server
```bash
cd backend
mvnw spring-boot:run
```
Backend runs on: **http://localhost:8080**

### Start Frontend Development Server
```bash
cd web
npm start
```
Frontend runs on: **http://localhost:3000**

---

## 🔌 API Endpoints

### Authentication Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/auth/register` | Register new user | No |
| POST | `/api/auth/login` | User login | No |
| POST | `/api/auth/logout` | User logout | Yes |
| GET | `/api/user/me` | Get current user profile | Yes |

### Request/Response Examples

#### Register
**Request:**
```json
POST /api/auth/register
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "password": "SecurePass123"
}
```

#### Login
**Request:**
```json
POST /api/auth/login
{
  "email": "john.doe@example.com",
  "password": "SecurePass123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "email": "john.doe@example.com",
  "firstName": "John",
  "lastName": "Doe"
}
```

---

## 📊 Development Status

**Overall Completion: ~80%**

| Component | Status | Completion |
|-----------|--------|------------|
| Backend Core | ✅ Complete | 90% |
| Frontend Core | ✅ Complete | 90% |
| Documentation | 🚧 In Progress | 10% |
| Testing | ❌ Pending | 0% |
| Mobile App | ❌ Pending | 0% |

### Completed Features
- ✅ User registration with validation
- ✅ User login with JWT token generation
- ✅ Password encryption using BCrypt
- ✅ Protected dashboard with authentication state
- ✅ Logout functionality
- ✅ React frontend with routing

### Pending Tasks
- ❌ User profile endpoint implementation
- ❌ JWT authentication filter middleware
- ❌ Comprehensive unit and integration tests
- ❌ ERD and UML diagrams
- ❌ Android mobile application
- ❌ Email verification feature
- ❌ Password reset functionality

---

## 👥 Team

**Course:** IT342 - Web Systems and Technologies  
**Lab:** Lab 1 - User Authentication System  
**Group:** G2  
**Date:** February 2026

---

## 📄 License

This project is developed for academic purposes as part of IT342 coursework.

---

## 📞 Support

For questions or issues, please refer to the [TASK_CHECKLIST.md](TASK_CHECKLIST.md) for detailed development progress and current tasks.

---

**Last Updated:** February 22, 2026
