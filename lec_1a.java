
// Features of Spring Framework

// ---------------------------------------------------------------------------------------

// 1. Inversion of Control (IoC)
// - IoC (Inversion of Control) in Spring refers to the design principle where the control of object
//   creation and dependency management is given to the Spring Container.

// ---------------------------------------------------------------------------------------

// 2. Spring Container
// - The Spring Container is the core of the Spring Framework.

// - It is responsible for:
// 1. Creating objects (called beans)
// 2. Managing the lifecycle of those beans
// 3. Injecting dependencies (Dependency Injection)
// 4. Configuring beans using annotations or XML

// ---------------------------------------------------------------------------------------

// 3. What is Dependency Injection?
// - Dependency Injection (DI) is a design pattern where an object receives its dependencies
//   from an external source rather than creating them itself.

// - In Spring, DI is the way Spring implements IoC (Inversion of Control).

// ---------------------------------------------------------------------------------------

// 4. What is Aspect-Oriented Programming (AOP)?
// - Aspect-Oriented Programming (AOP) is a programming paradigm that allows you to separate
//   cross-cutting concerns from your main business logic.

// - Cross-Cutting Concerns are functionalities that are used across multiple modules of an 
//   application, such as:

// A. Logging
// B. Security
// C. Transactions
// D. Performance monitoring
// E. Caching

// ---------------------------------------------------------------------------------------

// 5. Spring MVC
// - Spring MVC is a web framework built on the Spring Framework.

// - It follows the Model-View-Controller design pattern to develop flexible, maintainable, and
//   testable web applications.

// ---------------------------------------------------------------------------------------

// 6. What is a Transaction?
// - A transaction is a sequence of operations performed as a single unit of work.
// - It must follow the ACID properties:

// | Property            | Meaning                                      |
// | ------------------- | -------------------------------------------- |
// | **A** – Atomicity   | All operations succeed or none do            |
// | **C** – Consistency | The system remains in a valid state          |
// | **I** – Isolation   | Transactions don’t interfere with each other |
// | **D** – Durability  | Once committed, data is saved permanently    |

// ---------------------------------------------------------------------------------------

// 7. Spring Security
// - Spring Security is a powerful and customizable framework for authentication, authorization,
//   and protection against common security threats in Java applications.

// - It is the standard security framework used in Spring Boot / Spring MVC applications.

// ---------------------------------------------------------------------------------------

// 8. Spring Boot
// - Spring Boot is a framework built on top of Spring that makes it easy to create stand-alone,
//   production-ready Spring applications with minimal configuration.

// - Spring Boot simplifies the setup, development, and deployment of Spring applications by
//   eliminating boilerplate configuration.

// ---------------------------------------------------------------------------------------

// Setup for a Spring Boot Application
// 1. Install JDK
// 2. IDE (e.g., IntelliJ, Eclipse, VS Code)

// 3. Install Maven For dependency management
// - download Binary zip archive version. 
// - then file ko unzip karke 'bin' folder ka path copy kar lena hai.

// - then 'system properties' mey ja kar environment variable mey ja kar 'system variable' ke andar
//   ja kar 'path' pe click karenge and new pe click kar ke paths ko add kar denge.

// - then version check karne ke liye 'mvn -v' likhenge in command line.

// ---------------------------------------------------------------------------------------

// Creating Spring Boot Project Using Spring Initializr (Recommended for Beginners)
// - Spring Initializr is a free web-based tool provided by Spring to generate projects quickly.

// Steps:-
// 1. Go to https://start.spring.io
// 2. Fill in the details:

// 3. Click Add Dependencies and choose:
// - Spring Web (for building REST APIs)
// - Spring Boot DevTools (for auto-reloading)
// - Spring Data JPA and H2 Database (for database apps)
// - Lombok (Java annotation library which helps to reduce boilerplate code.)

// 4. Click Generate and It will download a .zip file.
// 5. Extract the zip and open the project in your IDE (IntelliJ, Eclipse, VS Code, etc.)

// Note:- if your JDK version is 23 then use Java version 23 or less in Spring Initializr.

// ---------------------------------------------------------------------------------------

// Use 'mvn clean install' command when:-

// - You made changes to your code and want a fresh build
// - You're building a project for the first time
// - You want to test, compile, and generate a .jar/.war
// - You want the package available for other local Maven projects

// ---------------------------------------------------------------------------------------

// After Running 'mvn clean install'
// - Maven will create a target/ folder like:

// target/
// ├── demo-0.0.1-SNAPSHOT.jar
// ├── classes/
// ├── test-classes/
// ├── generated-sources/

// ---------------------------------------------------------------------------------------

// DTO
// - DTO in Spring Boot stands for Data Transfer Object.

// - It’s basically a simple Java class whose only job is to carry data from one place to 
//   another — usually between different layers of your app (like Controller ↔ Service ↔ Database)
//   or between your app and the outside world (like APIs).

// ---------------------------------------------------------------------------------------

// Mapper
// - A mapper is just something that changes one type of object into another usually
//   Entity ↔ DTO.

// - Think of it like Google Translate for Java objects:
// 1. Entity → DTO: Take database object, turn it into API-friendly object.
// 2. DTO → Entity: Take API input, turn it into something the database can store.

// ---------------------------------------------------------------------------------------

// Entity
// - An Entity is just a Java class that represents a table in your database.
// - Entity class define karne ke liye @Entity Annotation ka use karenge.

// 1. Each object of that class = a row in the table.
// 2. Each field in the class = a column in the table.

// ---------------------------------------------------------------------------------------

// Controller
// - A Controller is a Java class that handles incoming requests from the browser or API client
//   and decides what to send back as a response.

// - @RestController → Tells Spring this class will handle web requests.

// ---------------------------------------------------------------------------------------

// Service
// - Business logic hum service mey likhte hai.
// - @Service Annotation will be used.

// ---------------------------------------------------------------------------------------

// Repository
// - Repository is a Java interface that talks to the database.
// - Repository mey hum database se entity ko connect karte hai.

// - JpaRepository interface → @Repository Annotation is optional (Spring adds it for you).
// - Manual DB class? → You must add @Repository Annotation.

// ---------------------------------------------------------------------------------------