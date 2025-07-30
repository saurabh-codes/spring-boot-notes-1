
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