# Dog-Services | Dog Breed API

This Java Spring application was part of my IDEXX interview project. It's designed to manage dog breed information via RESTful endpoints, showcasing my skills in creating a Java Spring application, implementing REST endpoints, and using the Java Persistence API.

## Features

- `/addBreed`: Allows users to add a new dog breed to the database.
- `/getBreed/{breed}`: Enables users to retrieve information about a specific dog breed.
- `/getAllBreeds`: Returns a List of Breeds to the user to know which breeds are already in the database.

## Motivation

The goal of this project is to highlight my ability to:
- Quickly develop a Java Spring application (done in a week).
- Implement RESTful services.
- Utilize Java Persistence API for database interactions.
- Initially, this application used an AWS RDS database to demonstrate my AWS skills, but it now features an H2 in-memory database for simplicity and ease of use.

## Skills Highlighted

- Java
- Spring Framework
- Database Management
- Swagger Integration for API documentation
- RESTful API Development

## Getting Started

To get this application running on your local machine, follow these steps:

1. **Prerequisites**
   - Ensure you have Java 11 installed on your machine.
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
  
## Usage
   1. Navigate to the Swagger Documentation listed above.
   2. To get started with the `/addBreed`, check out the Swagger Documentation, for example, request and response JSONs.
   3. This is the same for the `/getBreed{breed}`. This endpoint will only return breeds that are stored in the database. The Swagger Documentation has example request and response JSON.
   4. This is the same for the `/getAllBreeds`.

