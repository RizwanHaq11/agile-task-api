
---

# Agile Task API

A RESTful API built with **Spring Boot** for managing tasks in an Agile workflow. The API provides endpoints for creating, retrieving, updating, and deleting tasks, making it suitable for integration with front-end applications or as a backend service in agile project management systems.

<p align="center">
  <img width="464" height="212" alt="e74dca17-fd73-461c-94de-e5829a6cf0ab" src="https://github.com/user-attachments/assets/d1a8d629-ef94-4cf2-b274-4535200db61f" />
</p>



---

## Features

* Create, read, update, and delete tasks
* Task categorization by **status** (e.g., `To Do`, `In Progress`, `Done`)
* RESTful API design following industry standards
* Built with **Java 17** and **Spring Boot**
* In-memory **H2 database** support for testing and development

---

## Technologies Used

* **Java 17**
* **Spring Boot** (Spring Web, Spring Data JPA)
* **H2 Database** (in-memory for development)
* **Maven** (dependency management and build tool)

---

## Getting Started

### Prerequisites

* Java 17 or higher
* Maven 3.8+
* Git

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/RizwanHaq11/agile-task-api.git
   cd agile-task-api
   ```

2. Build the project with Maven:

   ```bash
   mvn clean install
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

4. The API will be available at:

   ```
   http://localhost:8080
   ```

---

## API Endpoints

### Task Endpoints

| Method | Endpoint          | Description           |
| ------ | ----------------- | --------------------- |
| GET    | `/api/tasks`      | Retrieve all tasks    |
| GET    | `/api/tasks/{id}` | Retrieve a task by ID |
| POST   | `/api/tasks`      | Create a new task     |
| PUT    | `/api/tasks/{id}` | Update a task by ID   |
| DELETE | `/api/tasks/{id}` | Delete a task by ID   |

### Example Request (Create a Task)

```http
POST /api/tasks
Content-Type: application/json

{
  "title": "Implement login",
  "description": "Develop user login functionality",
  "status": "TO_DO"
}
```

### Example Response

```json
{
  "id": 1,
  "title": "Implement login",
  "description": "Develop user login functionality",
  "status": "TO_DO"
}
```

---

## Database

The application uses **H2 Database** for development.
Access the H2 console at:

```
http://localhost:8080/h2-console
```

* **JDBC URL:** `jdbc:h2:mem:testdb`
* **Username:** `sa`
* **Password:** *(leave blank)*

---

## Project Structure

```
src/
 └── main/
     ├── java/com/example/agiletaskapi
     │   ├── controller   # REST controllers
     │   ├── model        # Entity classes
     │   ├── repository   # Spring Data JPA repositories
     │   └── service      # Business logic layer
     └── resources/
         ├── application.properties
         └── data.sql     # Sample data (if provided)
```

---

## Contributing

Contributions are welcome!
Please fork the repository and submit a pull request with detailed information about your changes.

---

## License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## Contact

Maintainer: **Rizwan Haq**
GitHub: [RizwanHaq11](https://github.com/RizwanHaq11)

---

