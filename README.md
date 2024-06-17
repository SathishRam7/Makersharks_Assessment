# Makersharks_Assessment

This project is a Spring Boot application that provides endpoints for user registration and user details fetching.

## Endpoints

### 1. Register User

- **URL:** /api/user/register
- **Method:** POST
- **Request Body:**
json
  {
    "username": "john",
    "email": "john@example.com",
    "password": "password123"
  }
   - **Responses:**
   - User registered successfully

  ### 2. Fetch User 

 **URL:** /api/user/fetch
 - **Method:** GET
 - **Query Parameter:**
   - username (required): The username of the user you want to fetch details for.
 - **Responses:**
    - **Body:**
    json
      {
     "id": 1,
     "username": "sathish",
     "email": "ram@gmail.com",
     "password": "ram"
      }
