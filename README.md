# Inclusion Cloud - Technical Test

This is a sample project implementing an application using Java Spring Boot with a hexagonal architecture and domain-driven use cases.
The application allows for the management of clients and financial products for a banking institution.

## System Requirements

- Java 21
- Maven
- Spring Boot 3.2.4
- H2 Database
- Lombok (optional)

## Project Structure

The project follows a hexagonal structure to separate the different layers of the application:

- `domain`: Contains the use cases and domain entities.
- `application`: Contains the application logic and implementation of use cases.
- `infrastructure`: Contains implementations of repository interfaces and any other external infrastructure.

## Project Setup

To run the application, simply follow these steps:

1. Clone the repository from [GitHub](https://github.com/AZapata27/quind-prueba-tecnica.git).
2. Open the project in your favorite IDE.
3. Make sure you have Java 21 installed.
4. Run `mvn clean install` to build the project.
5. Run the main class `Application.java`.

## Using the API

The REST API provides endpoints for managing clients and financial products. Here are the main available endpoints:

- **Clients**:
    - `POST /api/v1/clients`: Create a new client.
    - `PUT /api/v1/clients/{id}`: Update an existing client.
    - `DELETE /api/v1/clients/{id}`: Delete an existing client.

- **Products**:
    - `POST /api/v1/products`: Create a new product.
    - `PUT /api/v1/products/{id}`: Update an existing product.
    - `DELETE /api/v1/products/{id}`: Cancel an existing product.
  
- - **Transactions**:
    - `POST /api/v1/transaction`: Create a new transaction base on product and client.

## Additional Documentation

For more details on how to use the API and data models, refer to the automatically generated documentation in Swagger UI. 
You can access it at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) once the application is running.
