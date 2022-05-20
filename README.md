## java-crm-customer-service
The project is a api for a crm customer service that allow user to register, retrieve, update and delete information about customers through api endpoints. 
The project is based on Clean Architecture, so the domain rules are independent from any implementations and frameworks, become much more flexible and can be adaptable
to any external implementations. 
The api can be further improve with another functionalities.

The project was implemented with three layers:
- Core Layer: include the domain business rules and the application business rules.
- Api Layer: contains the application entrypoint, the configuration and dependencies of the other layers and the api endpoints.
- Adapters layer: contains the adapters between core layer and external applications, like database connections. 

Technology applied:
- Java 17
- Gradle

- Spring Web
Used to expose API endpoints through a Rest Controller.

- Spring Data Jpa
Used to configure and persist data on SQL database.

- Postgres
Database used to store customer information.

- Lombok
Anotations to reduce the boilerplate code.

- JUnit 5
To perform unit and integration tests.

- Docker
Containerized Postgres database and PgAdmin.

- Postman
Use to make API calls to Application Endpoints.

## Running the application
```
Clone the project, open the folder on IDE and run it.
```


