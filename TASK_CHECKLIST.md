# TASK CHECKLIST - IT342_G5_Lab1
**Lab 1: User Authentication System**
**Date: February 9, 2026**

---

## ✅ DONE

### 1️⃣ Backend Infrastructure
- ✅ **Project Setup** - Spring Boot project created with Maven (Commit: e866fef)
- ✅ **Database Configuration** - MySQL connection configured in application.properties (Commit: 4631cb7)
- ✅ **Dependencies Added** - JPA, Security, MySQL connector, Lombok (Commit: 4631cb7)
- ✅ **User Entity** - User.java with proper annotations and fields (Commit: 4631cb7)
- ✅ **User Repository** - UserRepository.java with findByEmail method (Commit: 4631cb7)
- ✅ **Security Configuration** - BCrypt password encoder configured (Commit: 4631cb7)
- ✅ **POST /api/auth/register** - Registration endpoint with email validation (Commit: 4631cb7)
- ✅ **POST /api/auth/login** - Login endpoint with password verification (Commit: 4631cb7)
- ✅ **Password Encryption** - BCrypt implementation working (Commit: 4631cb7)

### 2️⃣ Frontend Infrastructure
- ✅ **React Project Setup** - ReactJS project with required dependencies (Commit: fc8318a)
- ✅ **Router Configuration** - React Router DOM configured (Commit: fc8318a)
- ✅ **Register Page** - Complete registration form with API integration (Commit: fc8318a)
- ✅ **Login Page** - Login form with authentication flow (Commit: fc8318a)
- ✅ **Dashboard Page** - Protected dashboard with welcome message (Commit: fc8318a)
- ✅ **Logout Functionality** - Token removal and redirect to login (Commit: fc8318a)
- ✅ **Authentication State Management** - Token-based auth state in App.js (Commit: fc8318a)

### 3️⃣ Project Structure
- ✅ **Repository Structure** - Proper folder organization (/web, /backend, /mobile, /docs) (Commit: 4631cb7)
- ✅ **README.md** - Basic project documentation (Commit: 8138383)

---

## 🚧 IN-PROGRESS

### 1️⃣ Backend Enhancements
- 🔄 **GET /api/user/me** - Protected endpoint for user profile data
- 🔄 **JWT Token Implementation** - Enhanced login response with JWT tokens

### 4️⃣ Documentation
- 🔄 **Task Checklist Update** - Current file being updated with commit hashes

---

## ❌ TODO

### 1️⃣ Backend Completion
- ❌ **UserController.java** - Separate controller for user-related endpoints
- ❌ **JWT Authentication Filter** - Proper JWT validation middleware
- ❌ **Enhanced Login Response** - Return user data and token on successful login

### 2️⃣ Frontend Enhancements
- ❌ **Profile Display** - Show user information in Dashboard
- ❌ **API Integration** - Connect login to receive and store JWT tokens
- ❌ **Token Validation** - Implement proper token validation on frontend

### 3️⃣ Documentation Requirements
- ❌ **ERD (Entity Relationship Diagram)** - Database schema visualization
- ❌ **UML Diagrams** - System architecture and class diagrams
- ❌ **FRS Document Update** - Update Functional Requirements Specification
- ❌ **UI Screenshots** - Capture screenshots of:
  - Register page
  - Login page  
  - Dashboard/Profile page
  - Logout functionality

### 4️⃣ Testing & Deployment
- ❌ **Backend Testing** - Unit tests for authentication endpoints
- ❌ **Integration Testing** - Test frontend-backend communication
- ❌ **Database Testing** - Verify MySQL connection and data persistence

---

## 📊 PROGRESS SUMMARY

**Overall Completion: ~75%**

| Component | Status | Completion |
|-----------|--------|------------|
| Backend Core | ✅ Done | 85% |
| Frontend Core | ✅ Done | 90% |
| Documentation | ❌ Todo | 10% |
| Testing | ❌ Todo | 0% |

---

## 🎯 NEXT PRIORITIES

1. **Immediate (Session 1 Completion):**
   - Implement GET /api/user/me endpoint
   - Add JWT token generation to login
   - Update frontend to handle tokens
   - Create documentation (ERD, UML, screenshots)

2. **Short-term:**
   - Comprehensive testing
   - Security enhancements
   - Error handling improvements

3. **Long-term:**
   - Mobile application development
   - Advanced features (password reset, email verification)
   - Deployment configuration

---

**Last Updated:** February 9, 2026
**Repository:** IT342_G5_<Lastname>_Lab1
**Current Branch:** main (fc8318a)
