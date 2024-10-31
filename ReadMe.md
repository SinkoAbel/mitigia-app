# Mitigia Full Stack App

The applications are running in Dockerized environment.<br/>
Although it is possible to run and develop them in a local environment.

## Backend
### Spring Boot (3.3.5)
- Java JDK 17 (Corretto)
- Lombok
- Starter validation
- MySQL Connector
- JPA

Application runs on: http://localhost:8080

To build the project run `mvn clean install`

## Frontend
### Angular 17
- TailwindCSS is used.

Application runs on: http://localhost:4200

To build project run cmd: `npm run build`

## Database
### MySQL:9
Provided by `docker-compose.yml`<br/>
Runs in http://localhost:3307 to avoid port collisions.

## Docker
Both `clien` and `server` has it's own `Dockerfiles`.<br/>
The root folder has a `docker-compose.yml`.<br/>
To start the containers run command in the root directory: `docker-compose up --build`.<br/>

It is advised to use Docker Desktop app to start and stop the containers.
The starting of the applications is provided above. Stopping the application
is possible with the command `docker-compose down`.
