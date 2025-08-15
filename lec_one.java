
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

// ---------- Key Features of Spring ----------

// ---------------------------------------------------------------------------------------

// 1. Inversion of Control (IoC)
// - Normally, you create objects with new in Java.

// - In Spring, you just describe what objects you need, and Spring creates and gives
//   them to you.

// - This is called Dependency Injection (DI).

// ---------------------------------------------------------------------------------------

// Example:- In normal Java

// UserService service = new UserService(); 

// Note:- You control object creation

// ---------------------------------------------------------------------------------------

// Example:- In Spring Boot with IoC

// @Autowired
// UserService service; 

// Note:- Spring controls object creation & gives it to you

// ---------------------------------------------------------------------------------------

// 2. Aspect-Oriented Programming (AOP)
// - AOP is a way to add extra code (like logging, security checks, performance 
//   monitoring) to many methods without writing it inside every method.

// - It’s like putting a filter in front of your methods. this filter can run before,
//   after, or around them.

// - This keeps your code clean and focused.

// ---------------------------------------------------------------------------------------

// 3. Spring MVC
// - Spring MVC is Model-View-Controller framework inside Spring for building web 
//   applications and REST APIs.

// - Handles HTTP requests and responses in an organized way.

// ---------------------------------------------------------------------------------------

// 4. Spring Boot
// - Spring Boot is a Java framework that makes it very easy to create Spring-based
//   applications without doing a lot of setup.

// - Removes the pain of manual configurations.

// - Comes with embedded servers (Tomcat, Jetty) so you don’t need to deploy manually.

// - It’s like Spring framework + auto-configuration + built-in server so you can start
//   coding quickly.

// - Lets you start a Spring app in minutes.

// - Spring Boot 1.0.0 (general availability release) was made public on April 1, 2014

// ---------------------------------------------------------------------------------------

// 5. Spring Security
// - Makes adding authentication & authorization easy.
// - Supports OAuth, JWT, and many security standards.

// ---------------------------------------------------------------------------------------

// 6. Spring Data
// - Simplifies database operations.

// - You can write a repository interface and Spring will generate the implementation 
//   automatically.

// ---------------------------------------------------------------------------------------