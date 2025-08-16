
// What is Spring?
// - Spring is a lightweight, open-source framework for building Java applications.

// - It was created to make Java development simpler, faster, and more organized,
//   especially for enterprise (big, complex) applications.

// - It’s not just one thing, Spring is a whole ecosystem of projects:

// 1. Spring Core → The foundation (managing objects and their dependencies).
// 2. Spring MVC → Building web applications and APIs.
// 3. Spring Boot → Quickly creating Spring applications without tons of configuration.
// 4. Spring Data → Easy database access.
// 5. Spring Security → Handling authentication and authorization.
// 6. Spring Cloud → For microservices and cloud-based systems.

// ---------------------------------------------------------------------------------------

// - Spring can help you build small apps, big enterprise systems, REST APIs, 
//   microservices, secure portals, database apps, and more. all faster and 
//   with cleaner code.

// ---------------------------------------------------------------------------------------

// Why was Spring created?
// - Before Spring (early 2000s):

// 1. Java developers used Java EE (J2EE). it was powerful but complicated.
// 2. Too much boilerplate code (repeated, boring code).
// 3. Managing dependencies and application flow was manual and error-prone.

// - Spring came in to:

// 1. Reduce complexity.
// 2. Provide reusable solutions.
// 3. Make testing and scaling applications easier.

// - First public release (version 0.9) occurred in June 2003 when the project was 
//   published under the Apache 2.0 license.

// - The first stable, production-ready version 1.0 was released in March 2004.

// ---------------------------------------------------------------------------------------

// New Project Setup Time
// 1. Java EE:- setup is slow (3-5 days)
// 2. Spring:- setup is medium (1–2 days)
// 3. Spring Boot:- setup is super fast (less than 1 hour)

// ---------------------------------------------------------------------------------------

// Spring Boot
// - Spring Boot is a Java framework that makes it very easy to create Spring-based
//   applications without doing a lot of setup.

// - Removes the pain of manual configurations.

// - Comes with embedded servers (Tomcat, Jetty) so you don’t need to deploy manually.

// - It’s like Spring framework + auto-configuration + built-in server so you can start
//   coding quickly.

// - Lets you start a Spring app in minutes.

// - Spring Boot 1.0.0 (general availability release) was made public on April 1, 2014

// ---------------------------------------------------------------------------------------

// Inversion of Control (IoC)
// - Normally, you create objects with new keyword in Java.

// - IoC means the control of object creation and management is given to the 
//   Spring container.

// - Spring Boot automatically creates and manages beans, and injects them where
//   needed (via Dependency Injection).

// ---------------------------------------------------------------------------------------

// How IoC works in Spring Boot
// - Spring Boot uses the Spring IoC Container (backed by ApplicationContext).

// - When the app starts:
// - It scans your code for annotations (@Component, @Service, @Repository, @Controller).
// - Creates objects (beans) of those classes.
// - Stores them inside the container.
// - Whenever another bean needs one → Spring injects it automatically.

// ---------------------------------------------------------------------------------------

// Example:- Without IoC

// class Engine {
//     void start() {
//         System.out.println("Engine started...");
//     }
// }

// class Car {
//     private Engine engine = new Engine(); // YOU create the dependency

//     void drive() {
//         engine.start();
//         System.out.println("Car is running...");
//     }
// }

// Problem:-  Car is tightly coupled with Engine, hard to test and maintain.

// ---------------------------------------------------------------------------------------

// Example:- With IoC (Spring Boot)

// Step 1:- In "Engine" class 

// @Component
// class Engine {
//     void start() {
//         System.out.println("Engine started...");
//     }
// }


// ---------- Step 2:- In "CarService" class ----------

// @Service
// class CarService {
//     private final Engine engine;

//     Note:- Spring injects Engine using Constructor DI
//     public CarService(Engine engine) {  
//         this.engine = engine;
//     }

//     public void drive() {
//         engine.start();
//         System.out.println("Car is running...");
//     }
// }

// Note:-
// 1. You don’t write new Engine().
// 2. Spring’s IoC Container creates Engine and injects it into CarService.


// ---------- Step 3:- In main class ----------

// ApplicationContext context = SpringApplication.run(MyDemoApplication.class, args);
// Home home = context.getBean(Home.class);
// home.drive();

// ---------------------------------------------------------------------------------------

// IoC vs DI
// - IoC (Inversion of Control) → Big principle. Objects are created/managed by 
//   container.

// - DI (Dependency Injection) → Practical way of implementing IoC. Spring injects
//   dependencies (@Autowired) into classes.

// So:-
// 1. IoC = Concept
// 2. DI = Technique to achieve IoC

// ---------------------------------------------------------------------------------------

// @Autowired Annotation
// - It is used for Dependency Injection (DI).
// - It tells Spring "Hey Spring, please give me (inject) the object of this
//   class here automatically."

// ---------------------------------------------------------------------------------------

// Spring Container (a.k.a ApplicationContext)
// - The Spring Container is the engine of Spring.

// - It is responsible for:
// 1. Creating beans (objects).
// 2. Managing their lifecycle (create → inject dependencies → destroy).
// 3. Injecting dependencies (DI).
// 4. Storing beans in memory, so you can retrieve them.

// ---------------------------------------------------------------------------------------

// For Example:- In Spring Boot

// @SpringBootApplication
// public class DemoApp {
//     public static void main(String[] args) {
//         ApplicationContext context =
//             SpringApplication.run(DemoApp.class, args);

//         Car car = context.getBean(Car.class); // Bean comes from container
//         car.drive();
//     }
// }

// Note:- Here, ApplicationContext is the Spring Container.

// ---------------------------------------------------------------------------------------

// Aspect-Oriented Programming (AOP)
// - AOP says Write common code only once, in a separate place (called an 
//   Aspect), and I’ll apply it automatically wherever needed.

// - AOP in Spring Boot lets you separate cross-cutting concerns (like logging, 
//   security, transactions) from your main business logic.

// - You write them once as Aspects, and Spring applies them automatically to
//   your methods.

// - It’s like putting a filter in front of your methods. this filter can run before,
//   after, or around them.

// - This keeps your code clean and focused.

// ---------------------------------------------------------------------------------------

// Types of Advice in AOP
// 1. @Before → Run before method execution.
// 2. @After → Run after method execution (always).
// 3. @AfterReturning → Run only if method returns successfully.
// 4. @AfterThrowing → Run if method throws an exception.
// 5. @Around → Run before and after method (most powerful, can even stop execution).

// ---------------------------------------------------------------------------------------

// Setup for a Spring Boot Application

// 1. Install JDK
// 2. IDE (e.g., IntelliJ, Eclipse, VS Code)

// 3. Install Maven For dependency management
// - download Binary zip archive version. 
// - then file ko unzip karke 'bin' folder ka path copy kar lena hai.

// - then 'system properties' mey ja kar environment variable mey ja kar 'system 
//   variable' ke andar ja kar 'path' pe click karenge and new pe click kar ke paths
//   ko add kar denge.

// - then version check karne ke liye 'mvn -v' likhenge in command line.

// ---------------------------------------------------------------------------------------

// Maven
// - Maven is a build automation and dependency management tool for Java projects.

// - Think of it like a project manager that:
// 1. Builds your project (compiles Java code, packages it into JAR/WAR).
// 2. Manages dependencies (downloads required libraries automatically).
// 3. Runs tests.
// 4. Deploys your app if needed.

// ---------------------------------------------------------------------------------------

// Creating Spring Boot Project Using Spring Initializr

// - Spring Initializr is a free web-based tool provided by Spring to generate 
//   projects quickly.

// Steps:-
// 1. Go to https://start.spring.io
// 2. Fill in the details:

// 3. Click Add Dependencies and choose:
// - Spring Web (for building REST APIs)
// - Spring Boot DevTools (for auto-reloading)
// - Lombok (Java annotation library which helps to reduce boilerplate code.)

// 4. Click Generate and It will download a .zip file.
// 5. Extract the zip and open the project in your IDE (IntelliJ, Eclipse, VS Code, etc.)

// Note:- if your JDK version is 23 then use Java version 23 or less in Spring Initializr.

// ---------------------------------------------------------------------------------------

// Metadata in Spring Initializr

// +---------------------+----------------------------------------------------+-------------------+
// | Field_Name          | Description                                        | Example_Value     |
// +---------------------+----------------------------------------------------+-------------------+
// | Group               | Reverse domain name (company/organization)         | com.example       |
// | Artifact            | Project name, forms part of final file name        | demo              |
// | Name                | Readable project name                              | Demo              |
// | Description         | Short description of the project                   | A Spring Boot demo|
// | Packaging           | Output type: jar (standalone) or war (web app)     | jar               |
// | Package Name        | Base package where Java classes are stored         | com.example.demo  |
// +---------------------+----------------------------------------------------+-------------------+

// ---------------------------------------------------------------------------------------

// Spring Boot Project Structure

// 1. src/main/java → Your Java code (Controllers, Services, Repositories, Entities, etc.).
// 2. src/main/resources → Configuration files, static files, templates (like HTML, CSS, JS).

// 3. application.properties / application.yml → Main settings for the app (DB connection,
//    port, etc).

// 4. pom.xml / build.gradle → List of dependencies and project info (Maven/Gradle).
// 5. test/ → Code for testing your application.

// ---------------------------------------------------------------------------------------

// Spring Boot Project Structure Diagram

// Spring Boot Project
// │
// ├── src
// │   ├── main
// │   │   ├── java
// │   │   │   └── com.example.demo
// │   │   │       ├── controller       → Handles HTTP requests
// │   │   │       │    └── StudentController.java
// │   │   │       ├── service          → Business logic
// │   │   │       │    └── StudentService.java
// │   │   │       ├── repository       → Database queries
// │   │   │       │    └── StudentRepository.java
// │   │   │       ├── entity           → Maps DB tables to Java objects
// │   │   │       │    └── Student.java
// │   │   │       └── DemoApplication.java (Main class with @SpringBootApplication)
// │   │   │
// │   │   ├── resources
// │   │       ├── application.properties (App settings: DB, port, etc.)
// │   │       ├── static/              (CSS, JS, images)
// │   │       ├── templates/           (HTML templates: Thymeleaf, etc.)
// │   │
// │   └── test
// │       └── java
// │           └── com.example.demo
// │                └── StudentControllerTest.java (Unit/Integration tests)
// │
// ├── pom.xml or build.gradle          (Dependencies & build config)
// └── README.md                        (Project description)

// ---------------------------------------------------------------------------------------

// Note:-
// 1. Controllers → handle requests
// 2. Services → do the logic
// 3. Repositories → talk to the database
// 4. Entities → represent database tables
// 5. application.properties → stores app settings

// ---------------------------------------------------------------------------------------

// Spring Boot’s startup log message

// For Example:-

// 2025-08-15T20:17:00.037+05:30  INFO 3876 --- [myDemo] [  restartedMain] com.example
// .myDemo.MyDemoApplication     : Starting MyDemoApplication using Java 23.0.1 with PID
// 3876 (E:\myDemo\target\classes started by agrah in E:\myDemo)

// ---------------------------------------------------------------------------------------

// 1. Date & Time:- 2025-08-15T20:17:00.037+05:30

// 2. Log Level:- INFO

// - Spring Boot uses log levels like:
// A. ERROR → Serious problems
// B. WARN → Warning messages
// C. INFO → Normal informational messages (like startup messages)
// D. DEBUG / TRACE → Very detailed developer debugging info

// ---------------------------------------------------------------------------------------

// 3. Process ID (PID):- 3876

// 4. Application / Thread Info:- [myDemo]

// 5. Thread Name:- [restartedMain]

// 6. Main Class:- com.example.myDemo.MyDemoApplication

// 7. Startup Action:- Starting MyDemoApplication

// 8. Java Version:- using Java 23.0.1

// 9. PID Again:- with PID 3876

// 10. Classpath Location:- (E:\myDemo\target\classes)

// 11. Started By:- started by agrah

// 12. Working Directory:- in E:\myDemo

// ---------------------------------------------------------------------------------------

// Maven Wrapper (mvnw)
// - mvnw stands for Maven Wrapper in Spring Boot projects.

// - It’s a small script that lets you run Maven commands without having Maven 
//   installed on your computer.

// - When you use mvnw, your project:
// 1. Checks if Maven is installed.
// 2. If not, downloads the correct version automatically.
// 3. Runs Maven commands for you.

// ---------------------------------------------------------------------------------------

// mvnw.cmd File
// - The mvn.cmd file is a Windows batch script that comes with Maven.
// - It’s a command-line shortcut for running Maven on Windows.

// - When you type:- mvn clean install
//   Windows actually runs the instructions inside mvn.cmd.

// Note:- A Windows Batch Script is a plain text file with commands that Windows 
//        executes in order, one after another.

// ---------------------------------------------------------------------------------------

// .gitattributes file
// - The .gitattributes file is a Git configuration file that tells Git how to 
//   treat certain files in your repository.

// - It sets rules for:
// 1. Text vs Binary files → How Git should handle line endings and diffs.
// 2. Language-specific settings → For example, treat .java as UTF-8 text.
// 3. Merge strategies → Decide how files should be merged during conflicts.
// 4. Export settings → Control what happens when creating a release archive.

// ---------------------------------------------------------------------------------------

// Run Spring Boot Application
// 1. Run and go on url "http://localhost:8080/".

// 2. Output will be: Whitelabel Error Page

// 3. Beacuse there is no route for '/' and 'Error'.

// ---------------------------------------------------------------------------------------

// Creating Simple API

// Step 1:- Create "Home" Class

// @RestController
// public class Home {

//     @GetMapping
//     public String greet(){
//         return "Hello world from Spring Boot!";
//     }

//     @GetMapping("/home")
//     public String home(){
//         return "Welcome to Home Page!";
//     }
// }

// Step 2:- Run and go on url "http://localhost:8080/"
//          output will be: Hello world from Spring Boot!

// Step 3:- Now, go on url "http://localhost:8080/home"
//          output will be: Welcome to Home Page!

// ---------------------------------------------------------------------------------------

// ---------- Internal working of Spring Boot ----------

// ---------------------------------------------------------------------------------------

// 1. Main Class with @SpringBootApplication
// - @SpringBootApplication is an annotation in Spring Boot used on the main class
//   of your application. It tells Spring Boot “This is the starting point of my
//   application.”

// - @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan

// - SpringApplication.run() “Bootstraps the Spring context” basically means starting
//   and setting up the Spring container so it can manage all your application’s beans.

// ---------------------------------------------------------------------------------------

// 2. Bootstrapping SpringApplication.run()
// - When you call this method, Spring Boot starts the application:

// A. Creates Application Context (a special container)
// - Spring creates an IoC container (ApplicationContext).
// - This manages all beans (objects) in the application.


// B. Environment Setup
// - Reads properties (application.properties / application.yml).
// - Sets profiles (dev/test/prod).
// - Prepares logging system.


// C. Banner Display
// - Shows the Spring Boot banner/logo in console.

// ---------------------------------------------------------------------------------------

// 3. Component Scanning
// - Spring scans your base package (com.example.myapp).

// - Finds classes with annotations like:
// A. @Component
// B. @Service
// C. @Repository
// D. @Controller / @RestController

// - These are registered as beans inside the container.

// ---------------------------------------------------------------------------------------

// 4. Auto-Configuration
// - Spring Boot checks the classpath and loads configurations automatically.
// - Based on the libraries you added, Spring Boot automatically configures things.

// Example:-
// A. If spring-boot-starter-web is present → configures Tomcat, DispatcherServlet, 
//    Spring MVC.

// B. If spring-boot-starter-data-jpa is present → It configures Hibernate + Database
//    connection.

// ---------------------------------------------------------------------------------------

// 5. Bean Creation & Dependency Injection
// - Spring Boot creates all required beans.
// - Their dependencies are injected using Spring IoC (Inversion of Control).

// ---------------------------------------------------------------------------------------

// 6. Embedded Server Starts (for Web Apps)
// - An embedded Tomcat/Jetty/Undertow server starts automatically.
// - Registers DispatcherServlet to handle incoming HTTP requests.
// - Now the app is ready to accept HTTP requests.

// ---------------------------------------------------------------------------------------

// 7. Handling Requests
// - When a request comes (like http://localhost:8080/users):

// 1. Request goes to DispatcherServlet.
// 2. DispatcherServlet checks which @Controller/@RestController method matches.
// 3. Calls that method and gets a response.
// 4. Sends response back to client (JSON/XML/HTML).

// ---------------------------------------------------------------------------------------

// Internal Working Flow

// @SpringBootApplication →
// SpringApplication.run() →
// Creates ApplicationContext →
// Loads application.properties →
// Component Scan →
// Auto-Configuration →
// Beans Created & Dependencies Injected →
// Embedded Server Starts →
// DispatcherServlet Registered →
// Handles Requests →
// Application Runs

// ---------------------------------------------------------------------------------------

// Note:- Spring Boot internally creates a Spring container, auto-configures required
//        components, starts an embedded server, and manages everything automatically,
//        so you can just focus on business logic.

// ---------------------------------------------------------------------------------------