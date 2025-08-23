
// ---------- Creating REST API (Student Management) ---------- 

// ---------------------------------------------------------------------------------------

// Project Overview

// - We’ll build a simple REST API where you can:
// 1. Add new students
// 2. Get all students
// 3. Get student by ID
// 4. Update student
// 5. Delete student

// - This is a CRUD API (Create, Read, Update, Delete).

// ---------------------------------------------------------------------------------------

// STEP 1:- Create Spring Boot Project

// 1. You can create a project using Spring Initializr (https://start.spring.io/):

// 2. Dependencies: Spring Web, Spring Data JPA, PostgreSQL Driver Lombok

// ---------------------------------------------------------------------------------------

// STEP 2:- In Application Properties file

// # Database config
// spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
// spring.datasource.username=postgres
// spring.datasource.password=yourpassword

// # Hibernate settings
// spring.jpa.hibernate.ddl-auto=update
// spring.jpa.show-sql=true
// spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

// ---------------------------------------------------------------------------------------

// STEP 3:- Create Packges named (controller, entity, service, repository)

// ---------------------------------------------------------------------------------------

// STEP 4:- In 'Entity' package, create 'Student.java' file.

// @Entity
// @Data   // Lombok generates getters, setters, toString
// @NoArgsConstructor
// @AllArgsConstructor
// public class Student {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment ID
//     private Long id;

//     private String name;
//     private String email;
//     private int age;
// }

// ---------------------------------------------------------------------------------------

// Note:-
// 1. @Entity
// - Marks this class as a database entity.
// - Means This class = one table in the database (here: table student).


// 2. @Id
// - Marks id as the primary key of the table.


// 3. @GeneratedValue(strategy = GenerationType.IDENTITY)
// - Tells DB to auto-generate the ID (auto-increment).
// - Example: first student → id=1, next → id=2, etc.


// 4. Fields (name, email, age)
// - These become columns in the database table.

// ---------------------------------------------------------------------------------------

// In Short:- This Student class is a blueprint for the student table
//            in your database. Lombok reduces code writing, and JPA 
//            takes care of mapping it to SQL.

// ---------------------------------------------------------------------------------------

// STEP 5:- In 'repository' package, create "StudentRepository" interface

// public interface StudentRepository extends JpaRepository<Student, Long> {
// }

// ---------------------------------------------------------------------------------------

// Note:-
// 1. JpaRepository gives CRUD methods like save(), findAll(), findById(), 
//    deleteById() without writing SQL.

// 2. JpaRepository<Student, Long>
// - Student → the entity (table).
// - Long → the type of the primary key (id in Student is Long).

// ---------------------------------------------------------------------------------------

// STEP 6:- In 'service' package, create 'StudentService' file.

// @Service
// public class StudentService {
//     private final StudentRepository repository;

//     public StudentService(StudentRepository repository) {
//         this.repository = repository;
//     }

//     // 1. Create Student
//     public Student saveStudent(Student student) {
//         return repository.save(student);
//     }

//     // 2. Get All Students
//     public List<Student> getAllStudents() {
//         return repository.findAll();
//     }

//     // 3. Get by ID
//     public Student getStudentById(Long id) {
//         return repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
//     }

//     // 4. Update Student
//     public Student updateStudent(Long id, Student studentDetails) {
//         Student student = getStudentById(id);
//         student.setName(studentDetails.getName());
//         student.setEmail(studentDetails.getEmail());
//         student.setAge(studentDetails.getAge());
//         return repository.save(student);
//     }

//     // 5. Delete Student
//     public void deleteStudent(Long id) {
//         repository.deleteById(id);
//     }
// }

// ---------------------------------------------------------------------------------------

// Note:-
// 1. @Service
// - Tells Spring Boot This class contains business logic.

// - It acts as a middle layer between the Controller (API) and the
//   Repository (Database).


// 2. private final StudentRepository repository;
// - The service depends on the repository to talk to the database.
// - final → means once it’s set in the constructor, it cannot be changed.


// 3. Constructor Injection
// - Spring Boot automatically gives (injects) an object of StudentRepository
//   here.

// - This is called Dependency Injection (DI).


// 4. saveStudent(Student student){}
// - Saves a student to the database.


// 5. getAllStudents(){}
// - Fetches all students from the database.


// 6. getStudentById(Long id){}
// - Looks for a student by id.
// - If not found → throws an error "Student not found".


// 6(A). Student student = getStudentById(id);
// - First, it fetches the existing student from the database using the given id.
// - If the student is not found, getStudentById will throw "Student not found".


// 6(B). student.setName(studentDetails.getName());
// - Updates the name of the existing student with the new name.


// 6(C). student.setEmail(studentDetails.getEmail());
// - Updates the email with the new email.


// 6(D). student.setAge(studentDetails.getAge());
// - Updates the age with the new age.


// 6(E). return repository.save(student);
// - After updating the object, it saves the student back to the database.


// 7. updateStudent(Long id, Student studentDetails){}
// - Finds the student, updates details, saves back to DB.


// 8. deleteStudent(Long id){}
// - Deletes a student by ID.

// ---------------------------------------------------------------------------------------

// STEP 7:- In 'controller' package, create 'StudentController' file.

// @RestController
// @RequestMapping("/api/students")
// public class StudentController {

//     private final StudentService service;

//     public StudentController(StudentService service) {
//         this.service = service;
//     }

//     // Create Student
//     @PostMapping
//     public Student createStudent(@RequestBody Student student) {
//         return service.saveStudent(student);
//     }


//     // Get All Students
//     @GetMapping
//     public List<Student> getAllStudents() {
//         return service.getAllStudents();
//     }


//     // Get Student by ID
//     @GetMapping("/{id}")
//     public Student getStudentById(@PathVariable Long id) {
//         return service.getStudentById(id);
//     }


//     // Update Student
//     @PutMapping("/{id}")
//     public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
//         return service.updateStudent(id, student);
//     }


//     @PatchMapping("/{id}")
//     public Student updateStudentPartially(@PathVariable Long id, @RequestBody Student studentDetails) {
//         Student student = service.getStudentById(id);

//         if (studentDetails.getName() != null) {
//             student.setName(studentDetails.getName());
//         }
//         if (studentDetails.getEmail() != null) {
//             student.setEmail(studentDetails.getEmail());
//         }
//         if (studentDetails.getAge() != 0) {
//             student.setAge(studentDetails.getAge());
//         }
//         return service.saveStudent(student);
//     }


//     // Delete Student
//     @DeleteMapping("/{id}")
//     public String deleteStudent(@PathVariable Long id) {
//         service.deleteStudent(id);
//         return "Student deleted successfully!";
//     }
// }

// ---------------------------------------------------------------------------------------

// Note:-
// 1. @RequestMapping("/api/students")
// - Base URL for this controller.
// - So all endpoints will start with /api/students


// 2. When you send a request from Postman / frontend, you usually send JSON


// 3. @RequestBody tells Spring Boot:
// - Take this JSON (text) → Convert it into a Java object
// - service layer needs a Java object.


// 4. @PathVariable 
// - It is used to grab data from the URL path and pass it into your
//   method as a parameter.


// 5. return service.saveStudent(student);
// - Calls the Service layer method to save the student in the database.


// 6. Patch Method
// - Checks which fields were sent in the request.
// - If a field is not null / not 0, update it.
// - If the field is missing in JSON, leave the old value as it is.

// ---------------------------------------------------------------------------------------

// ---------- Test API (Student Management) ----------

// ---------------------------------------------------------------------------------------

// 1. Create Student (POST)

// - URL → http://localhost:8080/api/students
// - Method → POST
// - Body → raw → JSON

// For Example:-

// {
//   "name": "Saurabh",
//   "email": "saurabh@example.com",
//   "age": 23
// }

// Expected Response:-

// {
//   "id": 1,
//   "name": "Saurabh",
//   "email": "saurabh@example.com",
//   "age": 23
// }

// ---------------------------------------------------------------------------------------

// 2. Get All Students (GET)

// - URL → http://localhost:8080/api/students
// - Method → GET

// ---------------------------------------------------------------------------------------

// 3. Get Student by ID (GET)

// - URL → http://localhost:8080/api/students/1
// - Method → GET

// ---------------------------------------------------------------------------------------

// 4. Update Student (PUT)

// - URL → http://localhost:8080/api/students/1
// - Method → PUT
// - Body → JSON

// ---------------------------------------------------------------------------------------

// 5. Delete Student (DELETE)

// - URL → http://localhost:8080/api/students/1
// - Method → DELETE

// ---------------------------------------------------------------------------------------