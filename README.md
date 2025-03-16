# Spring Boot Microservices eCommerce Project

## Overview
This is a Spring Boot Microservices-based eCommerce Project with the following services:

- **API Gateway**: Central entry point for routing requests.
- **Order Service**: Manages order placement.
- **Product Service**: Manages products and stock.
- **Eureka Server**: Service discovery for microservices.
- **WebFlux (Non-Blocking Inter-Service Communication)**: Used for communication between services.
- **JWT Authentication**: Secures API endpoints.

## Architecture
```
+------------------+
|  API Gateway     |
+--------+---------+
         |
-------------------------------------
|                                   |
+------------+                     +------------+
| Order      |   <-- WebFlux -->    | Product    |
| Service    |                     | Service    |
+------------+                     +------------+
        \                        /
         \                      /
         +-----------------------+
         |  Eureka Server         |
         +-----------------------+
```

## Tech Stack

- **Spring Boot (Microservices)**
- **Spring WebFlux (Non-blocking communication)**
- **Spring Cloud Gateway (API Gateway)**
- **Spring Cloud Eureka (Service Discovery)**
- **Spring Security & JWT (Authentication & Authorization)**
- **MongoDB (Order Service Database)**
- **MySQL (Product Service Database)**
- **Docker (Containerization)**
- **Postman (API Testing)**

## Setup Instructions

### Prerequisites

- Java 21
- Maven
- Docker (optional)
- MongoDB & MySQL Databases

### Clone the Repository
```sh
git clone https://github.com/chamika-damith/springboot-ecommerce-backend-microservices.git
cd springboot-ecommerce-backend-microservices
```

### Start Services

#### Start Eureka Server
```sh
cd eureka-server
mvn spring-boot:run
```

#### Start Product Service
```sh
cd product-service
mvn spring-boot:run
```

#### Start Order Service
```sh
cd order-service
mvn spring-boot:run
```

#### Start API Gateway
```sh
cd api-gateway
mvn spring-boot:run
```

## JWT Authentication

### Generate JWT Token
To authenticate, send a POST request to `/auth/login` with:
```json
{
  "username": "user",
  "password": "password"
}
```
#### Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5c..."
}
```
Use this token in the `Authorization` header for protected endpoints.

### Secure API Endpoints with JWT
Example configuration in Spring Security:
```java
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/auth/").permitAll()
            .anyRequest().authenticated()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
            .build();
    }
}
```

## Inter-Service Communication (WebFlux)

### Order Service Calls Product Service to Decrease Stock

## Run with Docker
```sh
docker-compose up --build
```

## License
This project is open-source and available under the **MIT License**.

