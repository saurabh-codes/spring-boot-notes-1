
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

// 1. Constructor Injection
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

// 2. Setter Injection
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

// 3. Field Injection
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