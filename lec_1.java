
// Spring Boot
// - Spring Boot is a framework built on top of the Spring Framework. Its main goal is to 
//   simplify the setup, configuration, and development of Spring-based applications by providing:

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