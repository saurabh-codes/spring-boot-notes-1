
// Spring Boot
// - Spring Boot is a framework built on top of the Spring Framework. 
// - Spring Boot is used to develop enterprise-level application.

// - Its main goal is to simplify the setup, configuration, and development of Spring-based
//   applications by providing:

// 1. Auto Configuration:- 
// - Automatically configures Spring application based on the dependencies you add
//  (no need for a lot of XML or Java configuration).

// ---------------------------------------------------------------------------------------

// 2. Embedded Servers:- 
// - Comes with built-in Tomcat, Jetty, or Undertow, so you don't need to deploy WAR files
//   to an external server.

// ---------------------------------------------------------------------------------------

// 3. Starter Dependencies:-
// - Provides curated dependency sets (like spring-boot-starter-web, spring-boot-starter-data-jpa)
//   to reduce boilerplate configuration.

// ---------------------------------------------------------------------------------------

// 4. Production Ready:-
// - Includes built-in features like health checks, metrics, and monitoring with spring-boot-actuator.

// ---------------------------------------------------------------------------------------

// 5. Spring Initializr:- 
// - Provides a tool to quickly bootstrap your project at start.spring.io.

// ---------------------------------------------------------------------------------------

// Example Project Structure (Spring Boot Web App)

// src/
//  └── main/
//      ├── java/
//      │   └── com/example/demo/
//      │       ├── DemoApplication.java   // main class
//      │       ├── controller/
//      │       ├── service/
//      │       └── repository/
//      └── resources/
//          ├── application.properties     // config file
//          └── static/                    // frontend assets (HTML, CSS, JS)

// ---------------------------------------------------------------------------------------

//  Sample Code:- in Main Class file

// @SpringBootApplication
// public class DemoApplication {
//     public static void main(String[] args) {
//         SpringApplication.run(DemoApplication.class, args);
//     }
// }

// ---------------------------------------------------------------------------------------

// Controller Example:-

// @RestController
// public class HelloController {
//     @GetMapping("/hello")
//     public String sayHello() {
//         return "Hello, Spring Boot!";
//     }
// }

// ---------------------------------------------------------------------------------------

// Features of Spring Framework

// 1. Inversion of Control (IoC)
// - The IoC container manages the lifecycle and configuration of application objects (beans), making
//   it easier to manage dependencies and object creation.

// Note:- IoC object ko create karta hai and uske lifecycle ko manage karta hai and object ko
//        hum 'bean' bolte hai spring framework mey. jo ki spring container handle karta hai.

// - The terms Spring Container and IoC (Inversion of Control) are closely related in the Spring
//   Framework, but they are not the same thing.

// Note:- IoC is responsible for creating and managing beans.

// ---------------------------------------------------------------------------------------

// IoC (Inversion of Control):-
// - Concept/Principle, not a component.

// - It means the control of object creation and dependency management is inverted from the 
//   programmer to the framework (Spring).

// - Instead of writing code to create objects and wire dependencies, you tell Spring what you
//   need, and Spring injects dependencies automatically.

// - Implemented by: Spring Container.

// - Think of IoC as the idea or design pattern.

// ---------------------------------------------------------------------------------------

// Spring Container:-
// - Actual implementation of IoC in Spring.

// - It's the core of the Spring Framework that manages the lifecycle, configuration, and 
//   dependencies of beans (objects).

// - Reads configuration from:
// 1. applicationContext.xml (XML)
// 2. Java annotations (@Component, @Autowired, etc.)
// 3. Java-based configuration (@Configuration, @Bean)

// - Types of containers:
// 1. BeanFactory (basic container)

// 2. ApplicationContext (advanced container with more features like internationalization, event
//    propagation, etc.)

// - Think of Spring Container as the tool or engine that executes the IoC principle.

// ---------------------------------------------------------------------------------------

// | Feature         | IoC (Inversion of Control)           | Spring Container                             |
// | --------------- | ------------------------------------ | -------------------------------------------- |
// | Type            | Concept/Design Principle             | Concrete implementation in Spring            |
// | Role            | Delegates control to framework       | Manages beans and dependencies               |
// | Responsible for | Guiding how dependencies are handled | Actually creating and injecting dependencies |
// | Example         | Don't create objects manually        | Use `ApplicationContext.getBean()`           |
// | Part of Spring? | Yes (core principle)                 | Yes (core framework component)               |

// ---------------------------------------------------------------------------------------

// Note:- If IoC is the recipe, then the Spring Container is the chef who follows the recipe
//        and does all the work for you.

// Benefits:- Loose Coupling, Testability, Reuseability, Modular Design.

// - Modular Design is a design approach where a complex system is broken down into 
//   smaller, independent, and interchangeable parts called modules.

// ---------------------------------------------------------------------------------------

// - We can define the beans and their dependencies in a configuration file (using annotations,
//   XML, or JavaConfig), and the IoC container handles the instantiation of these beans.

// Note:- instantiation means represent as or by an instance.

// ---------------------------------------------------------------------------------------

// 2. Dependency Injection
// - DI is a way to inject the dependencies rather then having to create or manage them
//   explicitly.

// - it is achieved through spring Ioc container which is responsible for creating and 
//   managing objects known as beans.

// Note:- DI part hai IoC ka, Ioc ke through hi hum DI achieve kar sakte hai.

// Note:- In Java, an instance variable is a variable declared within a class but outside of
//        any method, constructor, or block. It is also known as a non-static field.

// Note:- DI is responsible for injecting the created beans into other beans where they
//        are needed.

// ---------------------------------------------------------------------------------------

// Example:- Without Spring or IoC

// class Engine {
//     public void start() {
//         System.out.println("Engine started");
//     }
// }

// class Car{
//     private Engine engine;
// //  Note:- Car has a dependency: an instance of the Engine class.

//     public Car(){
//         this.engine = new Engine()
// //      Note:- A new Engine object is created inside the Car.
// //      Note:- This means Car is responsible for creating its own dependency (Engine).
//     }

//     public void start(){
//         engine.start();
// //      Note:- This method tells the car to start.

// //      Note:- It internally calls engine.start() — which means it delegates the starting
// //             action to its Engine.
//     }
// }

// ---------------------------------------------------------------------------------------

// Example:- Better Way Using IoC (Constructor Injection Example)

// class Engine {
//     public void start() {
//         System.out.println("Engine started");
//     }
// }

// class Car {
//     private Engine engine;

//  // Note:- The engine is injected by the framework, not controlled by the car class.
//     public Car(Engine engine) {
//         this.engine = engine;  // Engine is injected from outside
//     }

//     public void start() {
//         engine.start();
//     }
// }

// Note:- Now, Car does not create the Engine itself. The engine is injected, which follows 
//        the IoC principle.

// ---------------------------------------------------------------------------------------

// Types of Dependency Injection in Spring

// A. Constructor Injection
// - Dependencies are passed through the class constructor.

// Example:-

// @Component
// class Engine {
//     public void start() {
//         System.out.println("Engine started");
//     }
// }

// @Component
// class Car {
//     private Engine engine;

//     @Autowired  // Tells Spring to inject Engine into constructor
//     public Car(Engine engine) {
//         this.engine = engine;
//     }

//     public void startCar() {
//         engine.start();
//     }
// }

// ---------------------------------------------------------------------------------------

// Advantages:-
// - Good for immutability.
// - Mandatory dependencies are enforced at object creation time.
// - Easier to write unit tests.

// ---------------------------------------------------------------------------------------

// B. Setter Injection
// - Dependencies are passed through public setter methods.

// Example:-

// @Component
// class Car {
//     private Engine engine;

//     @Autowired
//     public void setEngine(Engine engine) {
//         this.engine = engine;
//     }

//     public void startCar() {
//         engine.start();
//     }
// }

// ---------------------------------------------------------------------------------------

// Advantages:-
// - Good for optional dependencies.
// - More flexible if object initialization is complex.

// ---------------------------------------------------------------------------------------

// C. Field Injection
// - Spring injects the dependency directly into the field (no constructor or setter needed).

// Example:-

// @Component
// class Car {

//     @Autowired
//     private Engine engine;

//     public void startCar() {
//         engine.start();
//     }
// }

// ---------------------------------------------------------------------------------------

// Caution:-
// - Easiest to write but less testable.

// - Not recommended for complex or production-grade applications due to:
// 1. Lack of immutability.
// 2. Harder to mock during testing.

// ---------------------------------------------------------------------------------------

// 3. Aspect-Oriented Programming (AOP)
// - Aspect-Oriented Programming is a programming paradigm that allows you to isolate cross-cutting
//   concerns from your main business logic.

// Note:- paradigm means a typical example or pattern of something.

// - Cross-cutting concern:- Code that spreads across multiple classes and modules but is not
//   the core business logic. 

// Examples:- Logging, Security, Transactions, Caching, etc.

// - Instead of scattering this logic across multiple classes (leading to code duplication and
//   tight coupling), AOP enables you to define it in one place and apply it transparently 
//   wherever needed.

// ---------------------------------------------------------------------------------------

// 4. Spring MVC
// - Spring MVC is a Java-based framework used to build web applications using the Model-View-
//   Controller design pattern.

// - It separates the application into three layers:
// A. Model:– Business logic and data.
// B. View:– What the user sees (UI).
// C. Controller:– Handles user input and updates the model and view.

// ---------------------------------------------------------------------------------------

// 5. Transaction Management
// - Transaction Management in Spring Framework is one of its most powerful features, allowing
//   you to manage database transactions declaratively or programmatically — ensuring data
//   integrity and consistency in enterprise-level applications.

// Note:- "Declaratively" means in a way that makes a statement, announces something, or
//        explains something.

// Note:- Data integrity refers to the accuracy, consistency, and reliability of data 
//        throughout its lifecycle. 

// ---------------------------------------------------------------------------------------

// 6. Spring Security
// - Spring Security is a powerful and highly customizable security framework for Java applications.
// - It helps you add features like:

// A. Authentication:– Who are you? (e.g., login)
// B. Authorization:– What are you allowed to do? (e.g., access control)
// C. Protection against common attacks (like CSRF, XSS, and session fixation)

// ---------------------------------------------------------------------------------------

// 7. Spring Boot
// - Spring Boot is a framework built on top of the Spring Framework that makes it easy and fast to
//   build standalone, production-ready Java applications — especially web applications and REST APIs.

// - In short: Spring Boot = Spring made easy and automatic.

// ---------------------------------------------------------------------------------------

// Why Use Spring Boot?

// | Feature                        | Benefit                                    |
// | ------------------------------ | ------------------------------------------ |
// | No XML Configuration           | Uses Java annotations instead              |
// | Auto Configuration             | Spring Boot configures many things for you |
// | Embedded Web Servers           | Run your app without needing Tomcat setup  |
// | Built-in Testing Support       | Easier to write and run tests              |
// | Easy Dependency Management     | Uses Spring Boot Starter POMs              |
// | Create JARs with everything    | One-click run: `java -jar app.jar`         |

// ---------------------------------------------------------------------------------------

// Spring vs Spring Boot

// | Feature                 | Spring Framework                  | Spring Boot                              |
// | ----------------------- | --------------------------------- | ---------------------------------------- |
// | Configuration           | Manual, XML or Java-based         | Auto-configuration (minimal setup)       |
// | Startup Time            | Slower (due to manual setup)      | Faster (auto-configured)                 |
// | Embedded Server Support | No (you need to deploy on Tomcat) | Yes (Tomcat/Jetty embedded)              |
// | Dependencies            | You add one-by-one                | Uses **starter** dependencies            |
// | XML Configuration       | Often required                    | Not required (uses annotations)          |
// | Project Structure       | You define it manually            | Spring Initializr gives ready-to-run app |
// | Focus                   | Flexibility and customization     | Simplicity and productivity              |
// | Application Startup     | Needs external server (WAR file)  | Runs as standalone JAR (`java -jar`)     |
// | Testing Support         | Manual setup                      | Auto-includes JUnit, Mockito, etc.       |

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

// Project Metadata
// - In Spring Initializr, metadata is the basic information used to generate the structure, package
//   names, and settings of your Spring Boot project.

// - Metadata Fields Explained (One by One)

// | Field Name       | What It Means                           | Example                        |
// | ---------------- | --------------------------------------- | ------------------------------ |
// | **Project**      | Build tool to use                       | Maven or Gradle                |
// | **Language**     | Programming language                    | Java (default)                 |
// | **Spring Boot**  | Spring Boot version                     | `3.2.5` (latest stable)        |
// | **Group**        | Base package structure                  | `com.example`                  |
// | **Artifact**     | Project name & final `.jar` file name   | `demo`                         |
// | **Name**         | Display name of the project             | `demo`                         |
// | **Description**  | Short text about what your project does | `Demo project for Spring Boot` |
// | **Package Name** | Full Java package name (auto-generated) | `com.example.demo`             |
// | **Packaging**    | Output format                           | JAR (default) or WAR           |
// | **Java Version** | Version of Java your code is written in | 17 or 21                       |

// ---------------------------------------------------------------------------------------

// Example from Spring Initializr:-

// | Field        | Value                                          |
// | ------------ | ---------------------------------------------- |
// | Group        | `com.saurabh`                                  |
// | Artifact     | `student-api`                                  |
// | Name         | `student-api`                                  |
// | Description  | `A Spring Boot project for student management` |
// | Package Name | `com.saurabh.studentapi`                       |
// | Packaging    | `Jar`                                          |
// | Java         | `17`                                           |

// ---------------------------------------------------------------------------------------

// This metadata generates a project with this main class:

// package com.saurabh.studentapi;

// @SpringBootApplication
// public class StudentApiApplication {
//     public static void main(String[] args) {
//         SpringApplication.run(StudentApiApplication.class, args);
//     }
// }

// ---------------------------------------------------------------------------------------

// What Metadata Controls:

// | Metadata Field       | It affects...                           |
// | -------------------- | --------------------------------------- |
// | `Group` + `Artifact` | Java package name                       |
// | `Name`               | Application display name                |
// | `Artifact`           | Final JAR name (`artifact-name.jar`)    |
// | `Description`        | Comments in generated files             |
// | `Package Name`       | Location of main and controller classes |

// ---------------------------------------------------------------------------------------

// Use Standard Naming

// | For...   | Use...                                                   |
// | -------- | -------------------------------------------------------- |
// | Group    | Your domain or organization name (e.g., `com.company`)   |
// | Artifact | App or module name (e.g., `user-service`, `student-app`) |
// | Package  | Automatically generated — should match group + artifact  |

// ---------------------------------------------------------------------------------------

// Now, saare installed dependencies 'pom.xml' file mey milenge.

// ---------------------------------------------------------------------------------------

// Typical Spring Boot Project Structure

// my-springboot-app/
// ├── src/
// │   ├── main/
// │   │   ├── java/
// │   │   │   └── com/example/demo/
// │   │   │       ├── DemoApplication.java        <-- main class
// │   │   │       ├── controller/                 <-- controllers (web APIs)
// │   │   │       ├── service/                    <-- business logic
// │   │   │       ├── repository/                 <-- database access
// │   │   │       └── model/                      <-- entity classes
// │   │   └── resources/
// │   │       ├── static/                         <-- static files (HTML, CSS, JS)
// │   │       ├── templates/                      <-- HTML templates (Thymeleaf/Freemarker)
// │   │       ├── application.properties          <-- configuration file
// │   │       └── application.yml                 <-- alternative config format (optional)
// │
// ├── src/
// │   └── test/
// │       └── java/com/example/demo/              <-- test classes
// │           └── DemoApplicationTests.java
// │
// ├── pom.xml                                     <-- Maven dependencies
// └── README.md (optional)

// ---------------------------------------------------------------------------------------

// Folder/File Breakdown

// 1. src/main/java
// - This is where all your Java source code lives.
// - Common packages inside:

// | Package Name           | Purpose                                                |
// | ---------------------- | ------------------------------------------------------ |
// | `controller/`          | REST API endpoints (with `@RestController`)            |
// | `service/`             | Business logic (with `@Service`)                       |
// | `repository/`          | Data access using Spring Data JPA (with `@Repository`) |
// | `model/` or `entity/`  | Java classes that map to DB tables (with `@Entity`)    |
// | `DemoApplication.java` | Main entry point with `@SpringBootApplication`         |

// ---------------------------------------------------------------------------------------

// 2. src/main/resources
// - This folder contains non-code resources, like:

// | File/Folder                                   | Purpose                                                          |
// | --------------------------------------------- | ---------------------------------------------------------------- |
// | `application.properties` or `application.yml` | App configuration (port, DB settings, etc.)                      |
// | `static/`                                     | Static web content (HTML, JS, CSS, images)                       |
// | `templates/`                                  | HTML templates for web views (used with Thymeleaf or Freemarker) |
// | `banner.txt`                                  | Custom banner when app starts (optional)                         |

// ---------------------------------------------------------------------------------------

// 3. src/test/java
// - This folder contains unit and integration tests.
// A. Uses JUnit, Mockito, etc.
// B. File like DemoApplicationTests.java is auto-generated

// ---------------------------------------------------------------------------------------

// 4. pom.xml (for Maven) or build.gradle (for Gradle)
// - This is the project’s dependency file, where you define:
// A. What Spring Boot starters you need
// B. Java version
// C. Build instructions

// Example from pom.xml:-

// <dependency>
//   <groupId>org.springframework.boot</groupId>
//   <artifactId>spring-boot-starter-web</artifactId>
// </dependency>

// ---------------------------------------------------------------------------------------

// Example:- File Locations

// | What You Want to Do            | File Goes In                       |
// | ------------------------------ | ---------------------------------- |
// | Create a REST API              | `controller/HelloController.java`  |
// | Connect to a database          | `repository/UserRepository.java`   |
// | Create database entity         | `model/User.java`                  |
// | Business logic                 | `service/UserService.java`         |
// | Set app port and DB connection | `application.properties`           |
// | Add logo or JS files           | `static/logo.png`, `static/app.js` |
// | Add HTML template              | `templates/home.html`              |

// ---------------------------------------------------------------------------------------

// Creating Spring Boot Project Using IntelliJ IDEA (Spring Initializr is built-in)

// Steps:-
// 1. File > New > Project
// 2. Select Spring Initializr
// 3. Fill in the same details as above
// 4. Select dependencies like Spring Web
// 5. Click Finish – Project will be created and opened in your IDE

// ---------------------------------------------------------------------------------------

// Creating Spring Boot Project Using Spring Boot CLI (Command Line)
// - If you have Spring CLI installed:

// spring init --dependencies=web demo
// cd demo
// ./mvnw spring-boot:run

// ---------------------------------------------------------------------------------------

// Add Your First Controller (REST API)
// - In com.example.demo.controller, create: "HelloController" file

// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;

// @RestController
// public class HelloController {

//     @GetMapping("/hello")
//     public String hello() {
//         return "Hello, Spring Boot!";
//     }
// }


// 1. Run the Application
// - From Terminal (./mvnw spring-boot:run)

// 2. Test in Browser
// - Go to:http://localhost:8080/hello

// 3. You will see:

// Hello, Spring Boot!

// ---------------------------------------------------------------------------------------

// Use 'mvn clean install' command when:-

// - You made changes to your code and want a fresh build
// - You're building a project for the first time
// - You want to test, compile, and generate a .jar/.war
// - You want the package available for other local Maven projects

// ---------------------------------------------------------------------------------------

// clean
// - Deletes the target/ folder (i.e., old compiled files)
// - Ensures a fresh build
// - Removes previously compiled .class files, old .jar files, etc.
// - Think of it like cleaning your desk before starting new work.

// ---------------------------------------------------------------------------------------

// install
// - Compiles, runs tests, and packages your app Then it installs the .jar or .war into your
//   local Maven repository (~/.m2)

// - This includes:
// 1. validate → checks if the project is correct
// 2. compile → compiles the source code
// 3. test → runs unit tests
// 4. package → creates a .jar or .war file
// 5. install → copies the file into your local Maven repo

// - Now other Maven projects on your machine can use this .jar as a dependency.

// ---------------------------------------------------------------------------------------

// After Running 'mvn clean install'
// - Maven will create a target/ folder like:

// target/
// ├── demo-0.0.1-SNAPSHOT.jar
// ├── classes/
// ├── test-classes/
// ├── generated-sources/

// ---------------------------------------------------------------------------------------

// | Command             | What It Does                                  |
// | ------------------- | --------------------------------------------- |
// | `mvn clean`         | Deletes old build files                       |
// | `mvn install`       | Builds the project and installs in local repo |
// | `mvn clean install` | Full clean build + install                    |

// ---------------------------------------------------------------------------------------

// - Now, Main Class ko run karne ke baad "http://localhost:8080/" url paste karenge browser pe
//   toh hamara server start ho jayega.

// ---------------------------------------------------------------------------------------