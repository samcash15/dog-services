# Dog-Services | Dog Breed API

This Java Spring application was part of my IDEXX interview project. It's designed to manage dog breed information via RESTful endpoints, showcasing my skills in creating a Java Spring application, implementing REST endpoints, and using the Java Persistence API.

## Features

- POST `/breeds`: Users can add a new dog breed to the database.
- GET `/breeds/{breed}`: Enables users to retrieve information about a specific dog breed.
- GET `/breeds`: Returns a List of Breeds to the user to know which breeds are already in the database.
- PUT `/breeds/{breed}`: The user can update breed information in the database.
- DELETE `/breeds/{breed}`: The user can delete a breed from the database. 

## Motivation

The goal of this project is to highlight my ability to:
- Create a new Java Spring application from scratch.
- Implement RESTful services and follow best practices for REST API Design.
- Utilize Java Persistence API for database interactions.
- Utilize Spring Security for basic authentication for my REST API.
- Initially, this application used an AWS RDS database to demonstrate my AWS skills, but it now features an H2 in-memory database for simplicity and ease of use.

## Skills Highlighted

- Java
- Spring Framework
- Database Creation and Management
- Swagger Integration for API documentation
- RESTful API Design & Development
- Spring Security

## Getting Started

To get this application running on your local machine, follow these steps:

1. **Prerequisites**
   - Please make sure you have Java 17 installed on your machine.
   - Any IDE that supports Java (like IntelliJ IDEA, Eclipse, etc.)

2. **Setting Up**
   - Clone the repository to your local machine.
   - Import the project into your IDE as a Maven project.
   - Locate the `data.sql` file in the project, which contains initial data for the database.

3. **Running the Application**
   - Run the application from your IDE.
   - Access the H2 Database console at: [http://localhost:8080/dog/h2-console/](http://localhost:8080/dog/h2-console/).
   - Credentials for the H2 Database are stored in the `application.yml` file.
   - You can access the Swagger Documentation and test out the endpoints here: [http://localhost:8080/dog/swagger-ui.html#/](http://localhost:8080/dog/swagger-ui.html#/)
   - The API key is stored in the `application.yml` file. You'll need to Authorize before you use any endpoints. This is in the top right corner of Swagger.
  
## Usage
   1. Navigate to the Swagger Documentation listed above.
   2. To get started with any of the endpoints, check out the swagger documentation
