# API Test Application

This is a Spring Boot application that provides an API for storing and sending JSON objects to an external API.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Running the application
Swagger UI would be available at: http://localhost:7070/swagger-ui/index.html

### example of the request body
```json
[
  {
    "id": "1",
    "name": "John Doe",
    "age": 30,
    "isActive": true,
    "tags": ["developer", "java"],
    "metadata": {
      "department": "engineering",
      "location": "NY"
    }
  },
  {
    "id": "2",
    "name": "Jane Smith",
    "age": 25,
    "isActive": false,
    "tags": ["designer", "ux"],
    "metadata": {
      "department": "design",
      "location": "SF"
    }
  }
]
```