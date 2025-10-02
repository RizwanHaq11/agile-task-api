# Agile Task Management API (MVP)

Minimal Spring Boot backend implementing:
- JWT auth (signup/login)
- Projects and Tasks CRUD
- Swagger UI (OpenAPI)
- JPA with MySQL

## Requirements
- Java 17+
- Maven
- MySQL (create database `agile_task_db`)

## Run
1. Update `src/main/resources/application.yml` DB credentials.
2. `mvn spring-boot:run`
3. Swagger UI: http://localhost:8080/swagger-ui.html
