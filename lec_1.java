
// Spring Boot
// - Spring Boot is a framework built on top of the Spring Framework. 
// - Spring Boot is used to develop enterprise-level application.

// - Its main goal is to simplify the setup, configuration, and development of Spring-based
//   applications by providing:

// ---------------------------------------------------------------------------------------

// 1. Auto Configuration:- 
// - Automatically configures Spring application based on the dependencies you add
//   (no need for a lot of XML or Java configuration).

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

// Example Project Structure (Spring Boot Web App):-

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

// Sample Code:- in Main Class file

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

// ---------- Features of Spring Framework ----------

// ---------------------------------------------------------------------------------------
// 1. Inversion of Control (IoC)
// - IoC (Inversion of Control) in Spring refers to the design principle where the control of object
//   creation and dependency management is given to the Spring Container.

// - Instead of manually instantiating classes and managing dependencies, Spring handles it 
//   automatically.

// ---------------------------------------------------------------------------------------

// How Spring Uses IoC
// - Spring implements IoC using Dependency Injection (DI).

// - When your application starts:
// A. Spring creates all the required objects (called beans).
// B. It injects dependencies (other beans) into them automatically.
// C. You just define what needs to be injected, not how or when.

// ---------------------------------------------------------------------------------------

// Example without Spring IoC (manual dependency):-

// class Service {
//     void serve() {
//         System.out.println("Service running");
//     }
// }

// class Client {
//     Service service = new Service();  // tightly coupled

//     void doWork() {
//         service.serve();
//     }
// }

// Problem:- Tight coupling. Hard to test and replace dependencies.

// ---------------------------------------------------------------------------------------

// Example using Spring IoC:-

// @Component
// class Service {
//     void serve() {
//         System.out.println("Service running");
//     }
// }

// @Component
// class Client {
//     @Autowired
//     private Service service;

//     void doWork() {
//         service.serve();
//     }
// }


// Note:- Spring Container Automatically creates objects of Service and Client. Injects Service
//        into Client.

// ---------------------------------------------------------------------------------------

// How Spring knows what to inject?
// - @Component → Marks class as a Spring-managed bean.
// - @Autowired → Tells Spring to inject the dependency automatically.
// - Spring uses reflection to inject dependencies.

// ---------------------------------------------------------------------------------------

// Benefits of IoC in Spring
// - Loose coupling
// - Easier unit testing
// - Better code organization
// - Easier to manage large applications
// - Objects managed by container (life cycle, scope, etc.)

// ---------------------------------------------------------------------------------------

// Spring IoC Container Types

// 1. BeanFactory:- Basic container, lazy initialization.

// 2. ApplicationContext:- Advanced container (used commonly), supports:
// A. Internationalization
// B. Event propagation
// C. AOP
// D. Dependency injection

// ---------------------------------------------------------------------------------------

// | Concept                  | Description                                |
// | ------------------------ | ------------------------------------------ |
// | **IoC**                  | Spring controls object creation and wiring |
// | **Dependency Injection** | Method used to implement IoC               |
// | **Bean**                 | Object managed by Spring container         |
// | **@Component/@Service**  | Tell Spring to create beans                |
// | **@Autowired**           | Tell Spring to inject dependencies         |

// ---------------------------------------------------------------------------------------

// 2. Spring Container
// - The Spring Container is the core of the Spring Framework.

// - It is responsible for:
// 1. Creating objects (called beans)
// 2. Managing the lifecycle of those beans
// 3. Injecting dependencies (Dependency Injection)
// 4. Configuring beans using annotations or XML

// Note:- Spring Container is the implementation of the IoC principle in Spring.

// ---------------------------------------------------------------------------------------

// Responsibilities of Spring Container

// | Responsibility         | Description                                             |
// | ---------------------- | ------------------------------------------------------- |
// | Bean Creation          | Creates objects (beans) from your classes.              |
// | Dependency Injection   | Injects required dependencies into beans.               |
// | Bean Lifecycle         | Manages initialization, destruction, and scopes.        |
// | Configuration Handling | Reads annotations, XML, or Java config to set up beans. |
// | Object Lookup          | Provides beans when needed (via `getBean()` method).    |

// ---------------------------------------------------------------------------------------

// Types of Spring Containers
// 1. BeanFactory:- 
// - Basic container, lazy initialization, lower memory usage.
// - Interface/Class: org.springframework.beans.factory.BeanFactory

// 2. ApplicationContext:-
// - Advanced container. Used in most Spring applications.
// - Interface/Class: org.springframework.context.ApplicationContext

// ---------------------------------------------------------------------------------------

// ApplicationContext vs BeanFactory

// | Feature              | `ApplicationContext` | `BeanFactory`       |
// | -------------------- | -------------------- | ------------------- |
// | Dependency Injection | Yes                  | Yes                 |
// | Eager Initialization | (default)            | (lazy by default)   |
// | Internationalization | Supports i18n        | No                  |
// | Event Publishing     | Built-in             | No                  |
// | Use in Spring Boot   | Commonly used        | Rarely used         |

// ---------------------------------------------------------------------------------------

// How Spring Container Works (Simplified Flow)
// 1. Spring starts.
// 2. It scans for components or reads XML/Java config.
// 3. It creates bean objects.
// 4. It resolves and injects dependencies.
// 5. It manages lifecycle (init/destroy).
// 6. You use the bean from the container.

// ---------------------------------------------------------------------------------------

// Example Using AnnotationConfigApplicationContext:-

// @Configuration
// @ComponentScan("com.example")
// class AppConfig {}

// @Component
// class Car {
//     void drive() {
//         System.out.println("Car is driving...");
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         ApplicationContext context = 
//             new AnnotationConfigApplicationContext(AppConfig.class);

//         Car car = context.getBean(Car.class);
//         car.drive();
//     }
// }


// Note:-
// 1. @Component → Marks the class as a bean.
// 2. @Configuration → Marks class as configuration class.
// 3. @ComponentScan → Tells Spring where to look for components.

// ---------------------------------------------------------------------------------------

// What is Reflection in Java?
// - Reflection is a feature in Java that allows a program to inspect and modify its own 
//   structure at runtime, including:

// 1. Classes
// 2. Methods
// 3. Constructors
// 4. Fields (variables)

// - Reflection is part of the java.lang.reflect package.

// ---------------------------------------------------------------------------------------

// What does Dependency Injection mean in Spring?
// - Dependency Injection (DI) means Spring automatically provides the required object 
//   (dependency) to a class.

// ---------------------------------------------------------------------------------------

// Example:-

// @Component
// class Engine {}

// @Component
// class Car {
//     @Autowired
//     Engine engine; // Spring will inject this
// }

// Note:-
// 1. You never write: engine = new Engine();
// 2. Spring does it for you, behind the scenes.

// ---------------------------------------------------------------------------------------

// So How Does Spring Inject It?
// - Spring uses Java Reflection to:

// 1. Find the field or method marked with @Autowired
// 2. Bypass access modifiers (even if it's private)
// 3. Set the value of that field or call that method

// ---------------------------------------------------------------------------------------

// Example:- Step-by-Step: How Spring Uses Reflection

// @Component
// class Service {}

// @Component
// class Client {
//     @Autowired
//     private Service service;
// }


// Note:- 
// - Behind the scenes, Spring does:
// 1. Loads Client class using reflection.
// 2. Scans for fields/methods annotated with @Autowired.
// 3. Creates a Service object (bean).

// 4. Uses reflection to access the private service field.
// Field field = Client.class.getDeclaredField("service");
// field.setAccessible(true); // allow access to private field
// field.set(clientObject, serviceObject);

// 5. Now service is injected into Client.

// ---------------------------------------------------------------------------------------

// Why Use Reflection?

// | Reason                     | Explanation                                       |
// | -------------------------- | ------------------------------------------------- |
// | **Runtime flexibility**    | Injects dependencies without changing source code |
// | **Access private members** | Even private fields/methods can be accessed       |
// | **Dynamic behavior**       | Works for any class, not just known ones          |

// ---------------------------------------------------------------------------------------

// Security and Performance
// - Reflection is powerful but can be slower than normal code.
// - Spring optimizes it with caching.
// - Also, Spring avoids using reflection too frequently at runtime.

// ---------------------------------------------------------------------------------------

// 2. What is Dependency Injection?
// - Dependency Injection (DI) is a design pattern where an object receives its dependencies
//   from an external source rather than creating them itself.

// - In Spring, DI is the way Spring implements IoC (Inversion of Control).

// ---------------------------------------------------------------------------------------

// Real-world Analogy
// - A car needs an engine to run.
// - Without DI: the car builds its own engine.
// - With DI: the engine is given to the car from outside.

// ---------------------------------------------------------------------------------------

// Why Use DI?

// | Without DI                            | With DI (Spring)                     |
// | ------------------------------------- | ------------------------------------ |
// | Objects create their own dependencies | Dependencies are provided externally |
// | Tight coupling                        | Loose coupling                       |
// | Hard to test                          | Easy to test (mock dependencies)     |
// | Less flexible                         | More flexible and maintainable       |

// ---------------------------------------------------------------------------------------

// DI in Spring: How it Works

// - Spring:
// 1. Creates objects (called beans)
// 2. Identifies dependencies using annotations/configuration
// 3. Injects them into the correct places using Reflection

// ---------------------------------------------------------------------------------------

// Types of Dependency Injection in Spring

// | Type                      | Description                                    | Used When                       |
// | ------------------------- | ---------------------------------------------- | ------------------------------- |
// | **Constructor Injection** | Dependencies are passed via constructor        | When dependencies are mandatory |
// | **Setter Injection**      | Dependencies are set via setter methods        | When optional or changeable     |
// | **Field Injection**       | Dependencies are injected directly into fields | Common with `@Autowired`        |

// ---------------------------------------------------------------------------------------

// Example:- Constructor Injection

// @Component
// class Engine {}

// @Component
// class Car {
//     private Engine engine;

//     @Autowired
//     public Car(Engine engine) {
//         this.engine = engine;
//     }
// }

// ---------------------------------------------------------------------------------------

// Example:- Setter Injection

// @Component
// class Engine {}

// @Component
// class Car {
//     private Engine engine;

//     @Autowired
//     public void setEngine(Engine engine) {
//         this.engine = engine;
//     }
// }

// ---------------------------------------------------------------------------------------

// Example:- Field Injection

// @Component
// class Engine {}

// @Component
// class Car {
//     @Autowired
//     private Engine engine;
// }

// ---------------------------------------------------------------------------------------

// Annotations Used for DI

// | Annotation   | Purpose                                             |
// | ------------ | --------------------------------------------------- |
// | `@Component` | Marks a class as a Spring-managed bean              |
// | `@Autowired` | Tells Spring to inject the dependency               |
// | `@Qualifier` | Used to resolve ambiguity when multiple beans exist |
// | `@Inject`    | Java standard version of `@Autowired`               |
// | `@Value`     | Injects literal values                              |

// ---------------------------------------------------------------------------------------

// Spring DI Container
// - DI is handled by the Spring Container (typically ApplicationContext).
// - It scans the code for beans and injects dependencies automatically.

// ---------------------------------------------------------------------------------------

// Example Code with All Pieces:-

// @Component
// class Engine {
//     public void start() {
//         System.out.println("Engine started");
//     }
// }


// @Component
// class Car {
//     @Autowired
//     private Engine engine;

//     public void drive() {
//         engine.start();
//         System.out.println("Car is driving...");
//     }
// }


// @Configuration
// @ComponentScan("com.example")
// class AppConfig {}

// public class Main {
//     public static void main(String[] args) {
//         ApplicationContext context =
//             new AnnotationConfigApplicationContext(AppConfig.class);

//         Car car = context.getBean(Car.class);
//         car.drive();
//     }
// }

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

// mvn clean
// - Deletes the target/ folder (i.e., old compiled files)
// - Ensures a fresh build
// - Removes previously compiled .class files, old .jar files, etc.
// - Think of it like cleaning your desk before starting new work.

// ---------------------------------------------------------------------------------------

// mvn install
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