# Bean-Tastic-API

API for the BeanTastic Game.

## Technologies Used

- Git and GitHub: Source control
- GitHub Actions: CI/CD pipeline
- Spring boot: End points, link to database
- Lombok: Annotations to generate getters, setters and constructors
- Jakarta: Relational DB mapper

## How it is structured

- The <em>controllers</em> folder contains three RestController for each of the core classes (Items, BeanClass and Enemy). They each contain an endpoint which returns a list of objects of their respective types.
- The <em>dao</em> folder contains the three repositories (JPARepository) for each of the core classes.
- The <em>models</em> folder contains two sub folders.
    - Within the <em>dto</em> folder the three class types returned by the controllers can be found.
    - Within the <em>entities</em> folder the classes corresponding to the tables in the database can be found.
- The <em>utils</em> folder contains a DTOConverter.java file which contains static methods to transform the classes into their DTO versions.

## How to run

- Ensure the <em>application.properties</em> file located in the <em>resources</em> folder is configured (through the secrets) to correctly point to your database.
- The application can then be started by running the <em>ApiApplication.java</em> file

## Secrets Set-Up

- AWS_RDS_ENDPOINT
- AWS_REGION
- AWS_ROLE
- DB_PASSWORD
- DB_PORT
- DB_USERNAME