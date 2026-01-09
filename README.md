Built a layered spring boot application following the controller service repository architecture.

Developed Employee and Department modules with complete CRUD REST APIs for create, read, update, and delete operations using proper HTTP methods.

Established relational mapping between Employee and Department using JPA or Hibernate annotations resulting in correct SQL table relationships and foreign key constraints.

Used spring data JPA to handle database operations and automatically generate SQL queries reducing the need to write manual SQL queries.

Implemented dependency injection through constructor injection to connect controllers and services.
The application follows a layered architecture where each layer has limited access.
The controller layer can access only the service layer and never directly interacts with the database.
The service layer contains the logic and communicates only with the repository layer.
The repository layer is responsible for database access and interacts with the database using JPA.
These layers are connected using dependency injection for loose coupling.

Added Jakarta Bean Validation at the model level and request validation using @Valid to ensure only valid data is stored.

Tested all REST APIs using Postman (for request payloads, response status codes, and JSON responses for different conditions).
