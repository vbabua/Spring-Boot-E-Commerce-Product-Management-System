# Spring-Boot-E-Commerce-Product-Management-System

This repository contains a Spring Boot application designed to manage products for an e-commerce platform. This application serves as a backbone for e-commerce platforms by providing a straightforward way to manage and categorize products. Built using the power and efficiency of Spring Boot coupled with the robustness of PostgreSQL, it ensures data integrity and seamless operations even as your e-commerce venture scales.

In today's digital marketplace, a systematic approach to product management is indispensable. This system is tailored to:

Efficiently Handle Product Data: With structured entities for products and their respective categories, adding and updating product information is a breeze.
Categorization for Better Retrieval: Products are not just standalone entities; they belong to categories. By efficiently categorizing products, this system allows for streamlined retrieval, aiding in better product displays and recommendations on the front end.
Docker Integration for Scalability: With Docker configurations at the ready, deploying and scaling the application, whether during peak sales or regular days, remains consistent and hassle-free.
Ease of Testing: Adopting a test-driven approach, the system is equipped with unit tests ensuring reliability and robustness with every new feature addition or change.

The application is built using the following technologies:

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
[MIT License](https://github.com/vbabua/Spring-Boot-E-Commerce-Product-Management-System/blob/main/LICENSE)




