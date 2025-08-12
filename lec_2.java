
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

// @Bean Annotations
// - @Bean is a method level annotation

// - @Bean is used inside a @Configuration class to define a Spring-managed bean manually 
//   (instead of using @Component).

// - You write a method, and Spring will run it and register the returned object as a bean 
//   in the container.

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

// Add Dependencies and choose:
// - Spring Web (for building REST APIs)
// - Spring Boot DevTools (for auto-reloading)
// - Spring Data JPA and H2 Database (for database apps)
// - Lombok (Java annotation library which helps to reduce boilerplate code.)

// ---------------------------------------------------------------------------------------

// Step 1:- Make some packages 'entity', 'controller', 'service', 'dto', 'repository' and 
//          'mapper'.

// ---------------------------------------------------------------------------------------

// Step 2:- 'In entity package', make a class name 'Product'

// Example:-

// @Entity
// @Getter @Setter
// // Note:- Lombok ki vajah se yaha pe direct use kar paa rahe hai.
// public class Product {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     // Note:- hm product ki id automatic create karne ke liye isse use
//     // kar rahe.

//     private Long id;
//     private String name;
//     private String description;
//     private Double price;

//     @ManyToOne
//     @JoinColumn(name = "category_id", nullable = false)
//     // Note:- iss table mey jo column name hoga vaha pe category id add ho
//     // jayega. and 'Category' class ki id isme store ho jayega.
//     private Category category;
//     // Note:- iska use Category class mey 'OneToMany' ke andar use karenge.
// }

// ---------------------------------------------------------------------------------------

// Step 3:- 'In entity package', make a class name 'Category'

// Example:-

// // Note:- 'Category' ka 'Product' se One to Many ka relationship
// // hoga.
// @Entity
// @Getter @Setter
// public class Category {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String name;

//     // Note:- yaha pe 'One to Many' ka relationship ban raha hai.
//     @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//     // Note:- category mey kuch change ho toh product mey bhi hona
//     // cahiye. isiliye arguments pass kar rahe hai.
//     private List<Product> products;
//     // Note:- List<Product> → A collection (list) that will store many
//     // Product objects.
// }

// ---------------------------------------------------------------------------------------

// Step 4:- In 'controller' package, make a class name 'ProductController'

// Example:-

// @RestController
// @RequestMapping("/api/products")
// // Note:- @RequestMapping tells Spring which URL should be handled by
// // which method (or class).

// public class ProductController {
//     // 1. Get Product

//     // 2. Create Product

//     // 3. Update Product

//     // 4. Get Product by Id

//     // 5. Delete Product
// }

// ---------------------------------------------------------------------------------------

// Step 5:- In 'controller' package, make a class name 'CategoryController'

// Example:-

// @RestController
// @RequestMapping("/api/categories")

// public class CategoryController {

//     // 1. Get all Categories

//     // 2. Create Categories

//     // 3. Get Category by Id

//     // 4. Delete Category
// }

// ---------------------------------------------------------------------------------------

// Step 6:- In 'repository' package, make a interface name 'ProductRepository'

// Example:-

// @Repository
// public interface ProductRepository extends JpaRepository<Product, Long> {

//     // Note:- Means I am creating a ProductRepository interface that can
//     // do all basic database operations (like save, update, delete, find)
//     // for the Product entity, and the primary key type is Long.
// }

// ---------------------------------------------------------------------------------------

// Step 7:- In 'repository' package, make a interface name 'CategoryRepository'

// Example:- 

// @Repository
// public interface CategoryRepository extends JpaRepository<Category, Long> {
// }

// ---------------------------------------------------------------------------------------

// Step 8:- In 'service' package, make a class name 'ProductService'

// Example:-

// @Service
// public class ProductService {

//     // 1. Repository ko yaha pe inject karenge
//     private ProductRepository productRepository;
// }

// ---------------------------------------------------------------------------------------

// Step 9:- In 'service' package, make a class name 'CategoryService'

// Example:-

// @Service
// public class CategoryService {
// }

// ---------------------------------------------------------------------------------------

// Step 10:- In 'dto' package, make a class name 'ProductDTO'

// Example:-

// @Data
// // Note:- Creates all the boring stuff for you automatically:
// // 1. getters (getName())
// // 2. setters (setName())
// // 3. toString()
// // 4. equals() and hashCode()
// // So you don’t have to write them manually.

// @AllArgsConstructor
// // Note:- Creates a constructor with all fields as parameters.

// @NoArgsConstructor
// // Note:- Creates a default empty constructor (no parameters).

// public class ProductDTO {

//     private Long id;
//     private String name;
//     private String description;
//     private Double price;
//     private Long categoryId;
// }

// ---------------------------------------------------------------------------------------

// Step 11:- In 'dto' package, make a class name 'CategoryDTO'

// Example:-

// @Data
// @AllArgsConstructor
// @NoArgsConstructor

// public class CategoryDTO {
//     private Long id;
//     private String name;
//     private List<ProductDTO> products;
// }

// ---------------------------------------------------------------------------------------

// Step 12:- In 'mapper' package, make a class name 'ProductMapper'

// Example:-

// public class ProductMapper {
// }

// ---------------------------------------------------------------------------------------

// Step 13:- In 'mapper' package, make a class name 'CategoryMapper'

// Example:- 

// public class CategoryMapper {
// }

// ---------------------------------------------------------------------------------------

// Step 14:- In 'service' package, in 'CategoryService' class

// Example:- 

// @Service
// public class CategoryService {
//     private CategoryRepository categoryRepository;

//     // A. Create Category
//     public CategoryDTO createCategory(CategoryDTO categoryDTO){

//         // Step 1:- Convert CategoryDTO → Category entity
//         // Here, CategoryMapper.toCategoryEntity(...) is a mapping
//         // method.
//         Category category = CategoryMapper.toCategoryEntity(categoryDTO);

//         // Step 2:- Save entity to the database
//         category = categoryRepository.save(category);

//         // Step 3:- Convert saved entity → DTO
//         return CategoryMapper.toCategoryDTO(category);
//     }
//     // Note:-
//     // 1. CategoryDTO before the method name → This method will 
//     // return a CategoryDTO object (a data container for category info).

//     // 2. createCategory → The method’s name. It tells us this 
//     // function’s purpose: to create a category.

//     // 3. CategoryDTO categoryDTO → This is the input parameter.
//     // Whoever calls this method must give a CategoryDTO object
//     // containing details of the category (like name, description, etc.).


//     // B. Get all Category

//     // C. Get Category by Id

//     // D. Delete Category
// }

// ---------------------------------------------------------------------------------------

// Step 15:- In 'mapper' package, in 'CategoryMapper' class

// Example:-

// public class CategoryMapper {
//     // Note:- This method is a mapper that converts a Category 
//     // entity (from the database) into a CategoryDTO (safe 
//     // format for sending to the frontend).

//     public static CategoryDTO toCategoryDTO(Category category){
//         if (category == null){
//             return null;
//         }
//         CategoryDTO categoryDTO = new CategoryDTO();
//         categoryDTO.setId(category.getId());
//         categoryDTO.setName(category.getName());
//         categoryDTO.setProducts(category.getProducts().stream()
//                 .map(ProductMapper::toProductDTO).toList());
//         return categoryDTO;
//     }
//     // Note:-
//     // 1. categoryDTO.setId(category.getId());categoryDTO.setName(category.getName());
//     // Copy simple fields from entity to DTO

//     // 2. Convert products list:
//     // a. category.getProducts() → gets the list of Product
//     // entities inside the category.

//     // b. .stream() → turns the list into a stream for processing.

//     // c. .map(ProductMapper::toProductDTO) → converts each Product
//     // entity into a ProductDTO using the toProductDTO method.

//     // d. .toList() → collects all converted products into a List<ProductDTO>.

//     // 3. Return DTO → Sends back the complete category data in DTO form.


//     // Note:- This method is a mapper that converts a CategoryDTO
//     // (data from the client or frontend) into a Category entity 
//     // (used to saveinto the database).
//     public static Category toCategoryEntity(CategoryDTO categoryDTO){
//         Category category = new Category();
//         category.setName(categoryDTO.getName());
//         return category;
//     }
//     // Note:-
//     // 1. Category → This method will return a Category object 
//     // (probably a JPA Entity that maps to the database table).

//     // 2. toCategoryEntity → The method name says: "Convert 
//     // something into a Category entity".

//     // 3. CategoryDTO categoryDTO → Input parameter. Whoever
//     // calls this method must provide category data in a DTO
//     // (Data Transfer Object) form.

//     // 4. category.setName(categoryDTO.getName()); → Takes the
//     // name value from categoryDTO and puts it into the new 
//     // Category object.

//     // 5. return category; → Gives back the ready Category 
//     // object so it can be used (like saving it to the database).
// }

// ---------------------------------------------------------------------------------------

// Step 16:- In 'mapper' package, in 'ProductMapper' class

// public class ProductMapper {
//     // Note:- This method is a mapper that converts a Product
//     // entity (from the database) into a ProductDTO (a simpler
//     // object for sending to the frontend).

//     // A. entity to dto
//     public static ProductDTO toProductDTO(Product product) {
//         return new ProductDTO(
//                 product.getId(),
//                 product.getName(),
//                 product.getDescription(),
//                 product.getPrice(),
//                 product.getCategory().getId()
//         );
//     }
//     // Note:-
//     // 1. toProductDTO(Product product) →
//     // Method name means: "Convert a Product entity into a ProductDTO".
//     // Takes a Product object from the database as input.

//     // 2. return new ProductDTO(...) →
//     // Creates a new ProductDTO object.
//     // Passes the values from the Product entity to the DTO 
//     // constructor

//     // 3. product.getCategory().getId() → gets the category
//     // ID from the category entity inside the product


//     // Note:- This method is a mapper that converts a ProductDTO
//     // (coming from the client/frontend) into a Product entity 
//     // (which can be saved in the database).

//     // B. dto to entity
//     public static Product toProductEntity(ProductDTO productDTO, Category category){
//         Product product = new Product();
//         product.setName(productDTO.getName());
//         product.setDescription(productDTO.getDescription());
//         product.setPrice(productDTO.getPrice());
//         product.setCategory(category);
//         return product;
//     }
//     // Note:-
//     // 1. public static Product →
//     // Returns a Product entity object.

//     // 2. toProductEntity(ProductDTO productDTO, Category category) →
//     // The method takes two inputs:

//     // a. productDTO → contains product details (like name, description,
//     // price) from the client.

//     // b. category → the actual Category entity from the database,
//     // so the product can be linked to it.

//     // 3. Setters (setName, setDescription, setPrice) → Copies values 
//     // from the DTO into the new entity.

//     // 4. product.setCategory(category); → Links the product with its 
//     // category (entity form, not just an ID).

//     // 5. return product; → Gives back the complete Product entity so 
//     // it can be saved to the database.
// }

// ---------------------------------------------------------------------------------------

// Step 17:- In 'controller' package, in 'CategoryController' class

// Example:-

// @RestController
// @RequestMapping("/api/categories")
// @AllArgsConstructor
// // Note:-
// // 1. @RestController
// // a. Marks this class as a REST API controller in Spring Boot.

// // b. Combines @Controller + @ResponseBody, meaning methods will return
// // JSON instead of HTML.

// // 2. @AllArgsConstructor (from Lombok)
// // a. Automatically creates a constructor with arguments for all fields in
// // the class.

// // b. Here, it allows Spring to inject CategoryService without manually
// // writing a constructor.

// public class CategoryController {

//     private CategoryService categoryService;

//     // A. Get all Categories

//     // B. Create Categories
//     @PostMapping
//     public CategoryDTO categoryDTO(@RequestBody CategoryDTO categoryDTO){
//         return categoryService.createCategory(categoryDTO);
//     }
//     // Note:-
//     // 1. @PostMapping → This method handles HTTP POST requests to
//     // /api/categories.

//     // 2. @RequestBody CategoryDTO categoryDTO → The incoming request
//     // body (JSON) will be converted into a CategoryDTO object.

//     // 3. categoryService.createCategory(categoryDTO) → Calls the 
//     // service layer to save the category.

//     // 4. Returns → The saved category as a CategoryDTO (converted
//     // from the entity).
// }

// ---------------------------------------------------------------------------------------

// Step 18:- In 'resources' package, in 'application.properties' file

// spring.datasource.url=jdbc:h2:mem:testDB
// spring.jpa.show-sql=true

// // Note:- spring.datasource.url=jdbc:h2:mem:testDB
// // 1. spring.datasource.url → Tells Spring Boot where the database is.
// // 2. jdbc: → Standard prefix for database URLs.
// // 3. h2: → The database type is H2 (a lightweight, in-memory database).

// // 4. mem: → Means the database is in memory (temporary — data 
// // disappears when the app stops).

// // 5. testDB → The name of the in-memory database.
// // 6. Use an in-memory H2 database named testDB for this application.

// ---------------------------------------------------------------------------------------

// // Note:- spring.jpa.show-sql=true
// // 1. spring.jpa.show-sql → Tells Hibernate (the JPA provider) whether to log
// // the SQL queries it runs.

// // 2. true → Means log all SQL statements in the console when the app is running.

// ---------------------------------------------------------------------------------------

// Step 18:- Run the application and see in the terminal

// 1. Hibernate aapka two table create kar dega (table category, table product )

// 2. Now, open the H2 Database console (http://localhost:8080/h2-console/)

// 3. Now, database url(jdbc:h2:mem:testDB) ko 'H2 console' ke JDBC URL input mey fill
//    karke connect kar denge. then database open ho jayega.

// 4. Now, aapko 'PRODUCT' and 'CATEGORY' table ready milega.

// ---------------------------------------------------------------------------------------

// What is Hibernate?
// - Hibernate is a Java framework that helps you work with databases without writing 
//   raw SQL for everything.

// - It’s an ORM (Object–Relational Mapping) tool:

// 1. Object → Java classes/objects
// 2. Relational → Database tables

// 3. Mapping → Connecting Java objects to database tables so you can work with data as
//    Java objects instead of SQL rows.

// ---------------------------------------------------------------------------------------

// For Example:-

// 1. You create a Product class in Java.
// 2. Hibernate maps it to a product table in the database.
// 3. When you save() the object, Hibernate writes the SQL behind the scenes.

// ---------------------------------------------------------------------------------------

// Why use Hibernate in Spring Boot?
// - Spring Boot uses Spring Data JPA, which internally uses Hibernate as the default 
//   ORM provider. This means:

// 1. You write Java classes (called Entities).
// 2. You use Repository interfaces (no SQL needed).

// 3. Hibernate automatically:
// A. Generates SQL queries
// B. Handles INSERT, SELECT, UPDATE, DELETE
// C. Manages relationships (One-to-Many, Many-to-Many, etc.)
// D. Converts database rows to Java objects and back

// ---------------------------------------------------------------------------------------

// How Hibernate fits in Spring Boot
// - A typical flow:

// 1. Entity class → Java class annotated with @Entity, mapped to a table.
// 2. Repository interface → Extends JpaRepository, gives CRUD methods without writing SQL.
// 3. Hibernate → Works behind the scenes to execute SQL.
// 4. Database → Stores and retrieves data.

// ---------------------------------------------------------------------------------------

// Benefits
// - Less SQL code → Hibernate generates SQL automatically.
// - Portability → Works with many databases (MySQL, PostgreSQL, H2, Oracle, etc.).
// - Relationships → Easy to handle One-to-Many, Many-to-One.
// - Caching → Can speed up database reads.

// ---------------------------------------------------------------------------------------

// Step 19:- Open the Postman

// 1. POST url "http://localhost:8080/api/categories"

// 2. click on 'Body' and write and send:

// {
//     "name": "Electronics"
// }

// ---------------------------------------------------------------------------------------

// Step 20:- In 'service' package, in 'CategoryService' class

// Note:- add "@AllArgsConstructor" annotation to the class

// ---------------------------------------------------------------------------------------

// Step 21:- In 'entity' package, in 'CategoryService' class

// 1. update the line number '24' code 
// "private List<Product> products;" with:
// private List<Product> products = new ArrayList<>();


// Note:- new ArrayList<>()
// 1. List is a Java interface that represents an ordered collection (like an array 
// but more flexible).

// 2. <Product> means the list will store only Product objects (generics).

// 3. Creates an empty ArrayList that will store Product objects.

// 4. ArrayList is a common implementation of List that stores elements in a 
// resizable array.

// ---------------------------------------------------------------------------------------

// Now, Body mey response milega with '200 ok' status:

// {
//     "id": 1,
//     "name": "Electronics",
//     "products": []
// }


// Note:- 
// 1. By default Postman mey data save hone ke baad '200 ok' status ka response deta hai.
// 2. hum isko fix kar sakte hai. follow next step:

// ---------------------------------------------------------------------------------------

// Step 22:- In 'controller' package, in 'CategoryController' class

// Note:- Update the line number 36 code:

// public CategoryDTO categoryDTO(@RequestBody CategoryDTO categoryDTO){
//     return categoryService.createCategory(categoryDTO);
// }

// WITH:

// public ResponseEntity<CategoryDTO> categoryDTO(@RequestBody CategoryDTO categoryDTO){
//     return new ResponseEntity<>( categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
// }

// Note:- Now, response code will be change into "201Created" status.

// ---------------------------------------------------------------------------------------

// Note:-
// 1. <CategoryDTO> means the response body will contain a CategoryDTO object.

// 2. return new ResponseEntity<>( ... , HttpStatus.CREATED)
// a. Second argument → HttpStatus.CREATED (HTTP code 201)

// b. Tells the client: "The resource was successfully created."

// ---------------------------------------------------------------------------------------

// Now, jb hum next 'categories' create karenge:

// {
//     "name": "Clothing"
// }


// Output in Body:-

// {
//     "id": 2,
//     "name": "Clothing",
//     "products": []
// }

// Note:- id ki value 2 mil gayi

// ---------------------------------------------------------------------------------------

// Step 23:- Now, database mey jab category run karenge:

// ID  	NAME  
// 1	Electronics
// 2	Clothing

// - Output Milega

// ---------------------------------------------------------------------------------------