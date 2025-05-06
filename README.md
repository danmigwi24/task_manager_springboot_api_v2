# Task Manager API

A simple Spring Boot application for managing user tasks with CRUD operations using PostgreSQL.

## Prerequisites

- Java 17 or higher
- Maven
- PostgreSQL

## Database Setup

1. Install PostgreSQL if you haven't already.
2. Create a database named `taskmanager`:

```sql
CREATE DATABASE taskmanager;
```

3. Update the `application.properties` file with your PostgreSQL username and password if needed.

## Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Build the application:

```shell
mvn clean install
```

4. Run the application:

```shell
mvn spring-boot:run
```

The application will start at `http://localhost:8080`

## API Endpoints

### Get All Tasks
```
GET /api/tasks
```

### Get Task by ID
```
GET /api/tasks/{id}
```

### Get Tasks by Status
```
GET /api/tasks/status/{status}
```
Status values: TODO, IN_PROGRESS, COMPLETED

### Search Tasks by Title
```
GET /api/tasks/search?title={title}
```

### Create New Task
```
POST /api/tasks
```
Request body:
```json
{
  "title": "Task Title",
  "description": "Task Description",
  "status": "TODO",
  "dueDate": "2025-05-15T12:00:00"
}
```

### Update Task
```
PUT /api/tasks/{id}
```
Request body:
```json
{
  "title": "Updated Task Title",
  "description": "Updated Task Description",
  "status": "IN_PROGRESS",
  "dueDate": "2025-05-20T12:00:00"
}
```

### Delete Task
```
DELETE /api/tasks/{id}
```

## Testing with Curl

### Create a task
```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Complete project","description":"Finish the Spring Boot project","status":"TODO","dueDate":"2025-05-15T12:00:00"}'
```

### Get all tasks
```bash
curl -X GET http://localhost:8080/api/tasks
```

### Update a task
```bash
curl -X PUT http://localhost:8080/api/tasks/1 \
  -H "Content-Type: application/json" \
  -d '{"title":"Complete project","description":"Finish the Spring Boot project","status":"IN_PROGRESS","dueDate":"2025-05-15T12:00:00"}'
```

### Delete a task
```bash
curl -X DELETE http://localhost:8080/api/tasks/1
```