# Spring-Boot-E-Commerce-Product-Management-System

This repository contains a Spring Boot application designed to manage products for an e-commerce platform. The application is built using the following technologies:

- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- Docker
  
## Features
Manage products and their associated categories.
Retrieve all products and their details.
Retrieve products by category.
Add or update product details.
Get a list of all categories.
Easily run the application and database using Docker Compose.

## Prerequisites
- Java16 or higher
- Docker and Docker-Compose installed on your machine

## Running the Application
1. Clone the Repository
   ```bash
   git clone https://github.com/vbabua/Spring-Boot-E-Commerce-Product-Management-System.git
   ```

2. Navigate to the project directory
   ```bash
   cd Spring-Boot-E-Commerce-Product-Management-System
   ```
   
3. Build and Start the Services using Docker
   ```bash
   docker-compose up --build
   ```

4. The application will be accessible at 'http://localhost:8080'

## API Endpoints
- Retrieve All Products: GET /products
- Retrieve All Categories: GET /categories
- Retrieve Products by Category: GET /product/{category}
- Add a New Product: POST /product
- Update Product: PUT /product

## Testing
The application includes unit tests for various components. Tests utilize JUnit 5, Spring Boot Test, and Mockito. 
To run the tests:
```bash
./gradlew test
```

## Configuration
Database configurations, hibernate settings, and other application properties can be found in the application.properties file.

## License
[MIT License](https://choosealicense.com/licenses/mit/)




