
// ---------- REST API ----------

// ---------------------------------------------------------------------------------------

// Controller
// - A Controller in Spring Boot is like a receptionist in an office. it receives requests
//   from users (via the browser or API call), decides what needs to be done, and then sends
//   back the right response.

// - Controllers usually have annotations like @RestController or @Controller and handle
//   URLs defined with @RequestMapping or @GetMapping, etc.

// Note:- The controller package is just where you store your classes that handle web 
//        requests and responses.

// ---------------------------------------------------------------------------------------

// Service
// 1. The controller receives a request from the user and passes it to the service.

// 2. The service contains the actual business logic. the main work your application 
//    needs to do.

// 3. It talks to the repository (database layer) if data is needed, processes it, and
//    then sends the result back to the controller.

// 4. Services are usually marked with the @Service annotation so Spring Boot knows they
//    are special “logic-handling” classes.

// ---------------------------------------------------------------------------------------

// Entity
// - Entity is simply a class that represents a table in the database.
// - Each object of that class is like one row in the table.
// - The fields/variables in the class are like columns in the table.

// - We mark it with the @Entity annotation so Spring Boot (via JPA/Hibernate) knows:
//   “This class should be stored in the database.”

// Note:- An Entity is just a blueprint for a database table, and each object you create
//        from it is a row in that table.

// ---------------------------------------------------------------------------------------

// JPA
// - JPA (Java Persistence API) → A set of rules that says how Java classes should be 
//   saved, read, updated, or deleted from a database. It’s just the guideline, not the
//   worker.

// ---------------------------------------------------------------------------------------

// Hibernate
// - The actual worker that follows JPA’s rules and does the real job of talking to
//   the database.

// In short:-
// 1. JPA = What to do
// 2. Hibernate = How to do it

// ---------------------------------------------------------------------------------------

// Note:-
// 1. You write code using JPA style (like @Entity, @Repository, save() etc).

// 2. Spring Boot uses Hibernate under the hood to make it actually work with the
//    database.

// Example flow:-
// Your Code (JPA style) → JPA Rules → Hibernate → Database

// ---------------------------------------------------------------------------------------

// Repository
// - A repository is like the database operator in your app. you tell it what you want,
//   and it gets or stores the data for you.

// It handles:-
// 1. Saving data (Insert / Update)
// 2. Reading data (Select)
// 3. Deleting data

// - Instead of writing long SQL queries, you just call simple methods like save(), 
//   findAll(), or deleteById().

// - We usually create repository interfaces and mark them with @Repository (or extend
//   JpaRepository), and Spring Boot automatically provides the code behind those methods.

// ---------------------------------------------------------------------------------------

// Example:-

// @Repository
// public interface UserRepository extends JpaRepository<User, Long> {
// }

// Here:-
// 1. User → Your Entity class (represents a table)
// 2. Long → Data type of your primary key (@Id)

// ---------------------------------------------------------------------------------------

// How it works in the project
// - The Controller → Service → Repository flow looks like this:

// 1. Controller → Gets a request from the user.
// 2. Service → Does the business logic (calculations, checks, etc.).
// 3. Repository → Saves or fetches the actual data from the database.

// ---------------------------------------------------------------------------------------

// ---------- Creating REST API ----------

// ---------------------------------------------------------------------------------------

// Step 1:- Create package named 'controller, entity, repository and service'.

// ---------------------------------------------------------------------------------------

// Flow of Project Structure (controller + entity + repository + service )
// 1. controller layer ke paas hamari request jayengi.

// 2. uske baad 'controller' ek model create karega and model create karne ke liye
//    'service' ka use karega.

// 3. 'service' internally entity and repository ka use karegi taaki vah model generate
//    kar sake.

// 4. and uss model ko 'controller' ke paas bhej degi.

// 5. and 'controller' iss model ka json bana kr return krega.

// ---------------------------------------------------------------------------------------

// Three Layered Architecture
//                         (DTO)                      (Entity)
// 1. Presentation Layer ------------> Service Layer ------------> Data-access Layer
//    (Controller)                     (Service)                   (Repository)

// ---------------------------------------------------------------------------------------

//                              (DTO)                    (Entity)
// 2. Presentation Layer <------------ Service Layer <------------ Data-access Layer
//    (Controller)                     (Service)                   (Repository)

// ---------------------------------------------------------------------------------------

// Note:-
// 1. client request 'Presentation Layer' ke pass jati hai.
// 2. uske baad 'Presentation Layer' baat karta hai 'Service Layer' se.
// 3. inke beech jo bhi data ka aapas mey sharing hota hai, vo 'DTO' ki help se hota hai.
// 4. DTO ko 'data transfer object' bolte hai and ye normal java class hoti hai.
// 5. jiski help se 'data' ko Presentation Layer se Service Layer mey bhejte hai.

// Note:-
// 1. Service Layer se Data-access Layer tak 'data' ka transfer Entity ki help se hota hai.
// 2. Entity ko model bhi kahte hai.
// 3. Data-access Layer Database se baat karti hai.
// 4. and Data-access Layer Database se 'data' le kar aayegi.
// 5. and uss data ko 'Entity' form mey vapas bhejegi 'Service Layer' ko.
// 6. and 'Service Layer' data ko 'Presentation Layer' mey bhejega 'DTO' form mey.

// ---------------------------------------------------------------------------------------

// Note:-
// 1. jb bhi Presentation Layer and Service Layer ke beech mey baat hoti hai toh
//    'DTO' ke form mey hoti hai.

// 2. jb bhi Service Layer and Data-access Layer ke beech mey baat hoti hai toh
//    'Entity' and 'DTO' ke form mey ho sakti hai.

// Note:- It keeps your code organized, flexible, reusable, and easy to test. just like
//        a well-run restaurant where waiters, chefs, and the store all have their own
//        clear roles.

// ---------------------------------------------------------------------------------------

// Three Layered Architecture Diagram

// [ User / Browser ]
//         |
//         v
// +---------------------+
// |   Controller Layer  |  <-- Handles requests & responses
// +---------------------+
//         |
//         v
// +---------------------+
// |    Service Layer    |  <-- Business logic (rules, calculations)
// +---------------------+
//         |
//         v
// +---------------------+
// |  Repository Layer   |  <-- Talks to the database
// +---------------------+
//         |
//         v
// [  Database  ]


// Flow:-
// 1. User sends a request → Controller
// 2. Controller sends to → Service
// 3. Service asks → Repository
// 4. Repository talks to → Database
// 5. Data comes back the same way in reverse.

// ---------------------------------------------------------------------------------------