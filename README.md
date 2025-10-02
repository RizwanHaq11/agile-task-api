# 🚀 Agile Task API

A **RESTful API** built with **Spring Boot** for managing tasks in an Agile workflow. The API provides endpoints to create, retrieve, update, and delete tasks — perfect for integration with front-end apps or as a backend service in agile project management systems.

<p align="center">
  <img width="464" height="212" alt="Agile Task API" src="https://github.com/user-attachments/assets/d1a8d629-ef94-4cf2-b274-4535200db61f" />
</p>

![GitHub repo size](https://img.shields.io/github/repo-size/RizwanHaq11/agile-task-api)  
![GitHub last commit](https://img.shields.io/github/last-commit/RizwanHaq11/agile-task-api)  
![GitHub issues](https://img.shields.io/github/issues/RizwanHaq11/agile-task-api)  
![GitHub license](https://img.shields.io/github/license/RizwanHaq11/agile-task-api)  
![Java](https://img.shields.io/badge/Java-17-blue)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7-green)  
![H2 Database](https://img.shields.io/badge/H2-Database-orange)

---

## ✨ Features

- 📌 Create, read, update, and delete tasks  
- 📂 Categorize tasks by **status** (`TO_DO`, `IN_PROGRESS`, `DONE`)  
- ⚡ RESTful API design following industry standards  
- 🛠 Built with **Java 17** and **Spring Boot**  
- 🗄 In-memory **H2 database** support for testing & development  

---

## 🛠 Technologies Used

- **Java 17**  
- **Spring Boot** (Spring Web, Spring Data JPA)  
- **H2 Database** (in-memory)  
- **Maven** (dependency management & build tool)  

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher  
- Maven 3.8+  
- Git  

### Installation

1. Clone the repository:

```bash
git clone https://github.com/RizwanHaq11/agile-task-api.git
cd agile-task-api
```
2. Build the project:

```bash
mvn clean install
```

3. Run the application:

```bash
mvn spring-boot:run
```

4. Access the API at:

   ```bash
   http://localhost:8080
   ```


---

## 📡 API Endpoints

### Task Endpoints

| Method | Endpoint          | Description           |
| ------ | ----------------- | -------------------- |
| GET    | `/api/tasks`      | Retrieve all tasks    |
| GET    | `/api/tasks/{id}` | Retrieve task by ID   |
| POST   | `/api/tasks`      | Create a new task     |
| PUT    | `/api/tasks/{id}` | Update task by ID     |
| DELETE | `/api/tasks/{id}` | Delete task by ID     |

### Example Request: Create a Task

```http
POST /api/tasks
Content-Type: application/json

{
  "title": "Implement login",
  "description": "Develop user login functionality",
  "status": "TO_DO"
}
```

# Example Response
```bash
{
  "id": 1,
  "title": "Implement login",
  "description": "Develop user login functionality",
  "status": "TO_DO"
}
```

# 🗄 Database

The app uses H2 Database for development.

## 📂 Project Structure

src/
 └── main/
     ├── java/com/example/agiletaskapi
     │   ├── controller   # REST controllers
     │   ├── model        # Entity classes
     │   ├── repository   # Spring Data JPA repositories
     │   └── service      # Business logic layer
     └── resources/
         ├── application.properties
         └── data.sql     # Sample data


# 📞 Contact

Maintainer: Rizwan Haq
GitHub: RizwanHaq11
