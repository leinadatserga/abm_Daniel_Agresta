# E-commerce Project

## General Description
This project is an e-commerce application for selling security and surveillance equipment, such as cameras, DVRs, and installation supplies.

## Project Structure
The project is organized into the following main packages:
- **com.ecommerce.abm_Daniel_Agresta**
  - **controllers**: Contains the REST controllers that handle HTTP requests.
  - **entities**: Contains the entity classes (`Client`, `Product`, `Cart`, `Invoice`).
  - **repositories**: Contains the repository interfaces for interacting with the database.
  - **services**: Contains the business logic.

## Configuration and Dependencies
### Maven
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.1</version>
        <relativePath/>
    </parent>
    <groupId>com.ecommerce</groupId>
    <artifactId>abm_Daniel_Agresta</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>abm</name>
    <description>E-commerce project for Spring Boot</description>
    <properties>
        <java.version>17</java.version>

    dependencies:
 
            <artifactId>spring-boot-starter-data-jpa</artifactId>
       
            <artifactId>spring-boot-starter-web</artifactId>
      
            <artifactId>jackson-databind</artifactId>
       
            <artifactId>mysql-connector-j</artifactId>
     
            <artifactId>lombok</artifactId>
       
            <artifactId>spring-boot-starter-test</artifactId>
    
        plugins:
           
                <artifactId>spring-boot-maven-plugin</artifactId>

Execution Instructions
Clone the repository.
To run the project, you must have MySQL installed on your system, create a database named "commerce", and configure the access according to your specific credentials in the "application.properties" file (src\main\resources\application.properties). Start the server with "main" and you can then test the various requests.


spring.datasource.url=jdbc:mysql://localhost:3306/commerce
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Run the application with mvn spring-boot:run or ./gradlew bootRun.
The API routes follow the format api/v1/*.


# E-commerce Project

## Descripción General
Este proyecto es una aplicación de e-commerce para la venta de equipos de seguridad y vigilancia, como cámaras, DVRs e insumos para la instalación de los mismos.

## Estructura del Proyecto
El proyecto está organizado en los siguientes paquetes principales:
- **com.ecommerce.abm_Daniel_Agresta**
  - **controllers**: Contiene los controladores REST que manejan las solicitudes HTTP.
  - **entities**: Contiene las clases de entidad (`Client`, `Product`, `Cart`, `Invoice`).
  - **repositories**: Contiene las interfaces de repositorio para interactuar con la base de datos.
  - **services**: Contiene la lógica de negocio.

Configuración:
application.properties: Configura la base de datos y otras propiedades necesarias.

spring.datasource.url=jdbc:mysql://localhost:3306/commerce
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
Entidades

Client
@Entity
public class Client {
}

Product
@Entity
public class Product {
}

Cart
@Entity
public class Cart {
}

Invoice
@Entity
public class Invoice {
}

Repositorios
ClientsRepository
public interface ClientsRepository extends JpaRepository<Client, Long> {
}

ProductsRepository
public interface ProductsRepository extends JpaRepository<Product, Long> {
}

CartsRepository
public interface CartsRepository extends JpaRepository<Cart, Long> {
}

InvoicesRepository
public interface InvoicesRepository extends JpaRepository<Invoice, Long> {
}

Controladores
ClientsController
@RestController
@RequestMapping("/api/v1/clients")
public class ClientsController {
}

ProductsController
@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {
}

CartsController
@RestController
@RequestMapping("/api/v1/carts")
public class CartsController {
}

InvoicesController
@RestController
@RequestMapping("/api/v1/invoices")
public class InvoicesController {
}

Servicios

ClientsService
@Service
public class ClientsService {
}

ProductsService
@Service
public class ProductsService {
}

CartsService
@Service
public class CartsService {
}

InvoicesService
@Service
public class InvoicesService {
}

Instrucciones de Ejecución
Clonar el repositorio.
Para ejecutar el proyecto se debe tener mysql en el sistema, crear una base de datos con el nombre "commerce" y configurar el acceso seg├║n las credenciales particulares, se hace en el archivo "application.properties" (src\main\resources\application.properties), se inicia el servidor con "main" y ya se pueden ensayar las distintas peticiones.

spring.datasource.url=jdbc:mysql://localhost:3306/commerce
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
Ejecutar la aplicación con mvn spring-boot:run.
Las rutas de la API tienen el formato api/v1/*.
