# cms

1. Clone the Repository

$ git clone https://github.com/your-repo/car-management-system.git
$ cd car-management-system

2. Set Up the Database

Create a database named cms in your MySQL server.

Update the application.properties file with your database credentials:

spring.datasource.url=jdbc:postgresql://localhost:3306/cms
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. Build and Run the Project

Use Maven to build the project:

$ mvn clean install

Run the Spring Boot application:

$ mvn spring-boot:run

The API will be accessible at: http://localhost:8084

#API Endpoints 

GET /cars: Retrieve all available cars. Returns 404 if no cars exist.
GET /cars/{id}: Retrieve details of a specific car by its ID. Returns 404 if the car doesn't exist.
POST /cars: Add a new car to the system. Returns 201 if successful or 500 if an error occurs.
DELETE /cars/{carId}: Delete a specific car by its ID. Returns 204 if successful or 500 in case of an error.
PUT /cars/{carId}: Update details of an existing car by its ID. Returns 200 with the updated car or 500 in case of an error.

#Deployed Link
https://car-deployment.onrender.com
