
// Spring Boot Annotations
// - Spring Boot uses annotations extensively to simplify configuration, define components,
//   handle dependency injection, and build REST APIs, among other features.

// ---------------------------------------------------------------------------------------

// @Component Annotations
// - It is a class level annotation.
// - When we use this annotation to our application, spring will do the following steps:

// ---------------------------------------------------------------------------------------

// 1. Find the class
// - Spring will scan the application to find the class with @Component annotation.

// ---------------------------------------------------------------------------------------

// 2. Create an Object
// - Spring will then create an object(bean) of that class without writing extra code. 

// ---------------------------------------------------------------------------------------

// 3. Handle dependencies
// - If the class need other object to work (like another bean or service) spring will
//   automatically provide those when it creates the object.

// ---------------------------------------------------------------------------------------

// 4. Inject the beans
// - Spring will also inject bean where ever its needed in your application.

// ---------------------------------------------------------------------------------------

// Example:- @Component Annotations

// @Component
// public class MyComponent {
//     public MyComponent() {
//         System.out.println("Hello from MyComponent Constructor");
//     }

//     public void message(){
//         System.out.println("Hello from MyComponent Method");
//     }
// }


// Output:- Hello from MyComponent Constructor

// Note:- Bina object create kiye aapko output milega.

// ---------------------------------------------------------------------------------------

// Example:- Print the methods of Objects

// @Component
// public class MyComponent {
//     public MyComponent() {
//         System.out.println("Hello from MyComponent Constructor");
//     }

//     public void myMessage(){
//         System.out.println("Hello from MyComponent Method");
//     }
// }

// ---------------------------------------------------------------------------------------

// Step 1:- sabse phle isse import karenge main class mey.
// import org.springframework.context.ApplicationContext;


// Step 2:- we will replace this code
// SpringApplication.run(SpringBootDemoApplication.class, args);

// ---------- into ----------

// ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
// MyComponent myComponent = context.getBean(MyComponent.class);
// myComponent.myMessage();

// ---------- this code ----------

// - now, we will access the method of object.

// ---------------------------------------------------------------------------------------

// @Configuration Annotations
// - @Configuration is used to mark a class as a source of Spring bean definitions.
// - It's like saying: "Hey Spring, this class will provide some beans manually."

// ---------------------------------------------------------------------------------------

// - @Configuration is an annotation in spring that designates a class as a source of bean
//   definitions.

// - In other words, when we annotate a class with @Configuration:

// 1. We are telling spring that this class contains methods that define beans using the @Bean
//    annotation.

// 2. Spring will automatically process the class to create and configure all the beans defined
//    within it.

// 3. The @Configuration class also ensure that each @Bean method is only called once and the
//    same bean instance is returned each time, which is important for managing singleton beans.

// ---------------------------------------------------------------------------------------

// @Bean Annotations
// - @Bean is a method level annotation

// - @Bean is used inside a @Configuration class to define a Spring-managed bean manually 
//   (instead of using @Component).

// - You write a method, and Spring will run it and register the returned object as a bean 
//   in the container.

// ---------------------------------------------------------------------------------------

// - in other words, without relying on spring to automatically detect and create beans, we can:

// 1. Explicitly create and congigure beans by writing methods annotated with @Beans inside a
//    class annotated with @Configuration.

// 2. Spring will automatically manage the lifecycle of these beans, inject them wherever needed,
//    and handle dependencies between them.

// ---------------------------------------------------------------------------------------

// Example:- @Configuration and @Bean Annotations

// Step 1:- Define a normal class (not annotated)

// public class HelloService {
//     public void sayHello() {
//         System.out.println("Hello from HelloService!");
//     }
// }


// Step 2:- Define a Configuration class using @Configuration and @Bean

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class AppConfig {

//     @Bean
//     public HelloService helloService() {
//         return new HelloService();  // Spring will register this as a bean
//     }
// }

// Note:- public HelloService helloService()
// 1. Its name (helloService) becomes the bean name in the Spring container (unless you specify
//    a custom name).

// Note:- return new HelloService();
// 1. You're manually creating an object using new.
// 2. Spring registers this object as a bean, so it can be reused, injected, and managed.


// Step 3:- Access the Bean in Main Class

// ApplicationContext context = SpringApplication.run(DemoApp.class, args);
        
// HelloService helloService = context.getBean(HelloService.class);
// helloService.sayHello();  

// Output:- Hello from HelloService!

// ---------------------------------------------------------------------------------------

// Note:- You can then access this HelloService object from anywhere using:
 
// @Autowired
// private HelloService helloService;

// ---------- OR ----------

// HelloService helloService = context.getBean(HelloService.class);

// ---------------------------------------------------------------------------------------

// @Controller Annotation
// - @Controller Annotation is a specialized version of @Component designed specifically for
//   handling web requests in spring mvc.

// - Spring automatically looks for methods in a @Controller annotated class and maps HTTP
//   requests to these methods (using @RequestMapping, @GetMapping, etc).

// - It also handles view resolution (returning HTML pages or templates).

// ---------------------------------------------------------------------------------------

// @RestController Annotation
// - It is a specialized version of @Controller designed for RESTful web services.
// - It combines the behaviour of @Controller and @ResponseBody.
// - You dont need to annotate each method with @ResponseBody to return data like JSON.

// - Use @RestController when building REST APIs that return data(JSON, XML, etc) directly
//   instead of views(HTML pages).

// ---------------------------------------------------------------------------------------

// @Service Annotation
// - @Service is a specialization of @Component.

// - Its intended to indicate that the class provides some businness logic with in the
//   application.

// - Using @Service helps clarify the intent of the class for other developers and aligns with
//   best practices in code organization.

// - In short, using @Component insted of @Service will work the same, but its more meaningful
//   to use @Service to indicate that the class provides service or business logic.

// ---------------------------------------------------------------------------------------

// @Repository Annotation
// - @Repository is a specialization of @Component intended specifically for data access layer
//   (DAO) classes that interact with databases.

// - One of the primary roles of @Repository is to provide a mechanism for translating database
//   related exceptions into Spring's DataAccessException hierarchy.

// - It reduce the complexity of error handling and makes the code more readable and maintainable.

// ---------------------------------------------------------------------------------------

// REST API
// - REST stands for Representational State Transfer.
// - It is a ways to implement communication between two apps.
// - Its client-server communication model, stateless communication.
// - It is widely used for building scalable and easy-to-maintain APIs.
// - API stands for Application Programming Interface.

// ---------------------------------------------------------------------------------------

// Key Concepts of REST API

// | Term             | Explanation                                                             |
// | ---------------- | ----------------------------------------------------------------------- |
// | **Client**       | The system (e.g., browser/app) that sends requests                      |
// | **Server**       | The system that processes requests and sends responses                  |
// | **Resource**     | Data entity like `User`, `Product`, `Order`                             |
// | **Endpoint**     | A specific URL that performs an action on a resource (e.g., `/users/1`) |
// | **HTTP Methods** | Used to perform actions like read, write, update, delete                |
// | **Stateless**    | Each request from client to server must contain all information needed  |
// | **JSON**         | Common data format used in REST APIs for data transfer                  |

// ---------------------------------------------------------------------------------------

// HTTP Methods
// - HTTP methods are used to perform CRUD operations on resources like User, Product, etc.

// ---------------------------------------------------------------------------------------

// Common HTTP Methods in REST API

// | HTTP Method | Purpose        | Spring Boot Annotation |
// | ----------- | -------------- | ---------------------- |
// | GET         | Read data      | `@GetMapping`          |
// | POST        | Create data    | `@PostMapping`         |
// | PUT         | Update data    | `@PutMapping`          |
// | PATCH       | Partial update | `@PatchMapping`        |
// | DELETE      | Delete data    | `@DeleteMapping`       |

// ---------------------------------------------------------------------------------------

// Note:- 
// 1. A Partial Update means updating only specific fields of a resource instead of replacing
//    the entire object.


// Example:-
// - Imagine you have a User object like this:

// {
//   "id": 1,
//   "name": "John Doe",
//   "email": "john@example.com",
//   "age": 30
// }

// - You only send the field you want to update:

// PATCH /users/1
// {
//   "name": "John Smith"
// }

// - This will only change the name, and keep email & age the same.

// ---------------------------------------------------------------------------------------

// Example:- REST API for a User System

// | Action            | URL        | HTTP Method | Description             |
// | ----------------- | ---------- | ----------- | ----------------------- |
// | Get all users     | `/users`   | GET         | Returns a list of users |
// | Get user by ID    | `/users/1` | GET         | Returns user with ID 1  |
// | Create a new user | `/users`   | POST        | Adds a new user         |
// | Update a user     | `/users/1` | PUT         | Updates user with ID 1  |
// | Delete a user     | `/users/1` | DELETE      | Deletes user with ID 1  |

// ---------------------------------------------------------------------------------------

// ---------- Creating a REST API ----------

// ---------------------------------------------------------------------------------------

// Step 1:- Make some packages 'entity', 'controller', 'service', 'dto', 'repository' and 
//          'mapper'.

// Step 2:- 'In entity package', make a class name Product and class pe "@Entity" annotation
//          use karenge and "@Getter" and "@Setter" annotation ka use karenge. 

// ---------------------------------------------------------------------------------------