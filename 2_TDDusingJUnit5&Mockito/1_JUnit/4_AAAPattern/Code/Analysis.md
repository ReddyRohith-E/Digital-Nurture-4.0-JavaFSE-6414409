# Exercise 4: Arrange-Act-Assert (AAA) Pattern with JUnit 5

This project demonstrates the **Arrange-Act-Assert (AAA) pattern** in JUnit 5 testing, along with proper use of setup and teardown methods using `@BeforeEach` and `@AfterEach` annotations.

## Project Structure

```
src/
├── main/java/com/example/
│   └── model/
│       └── Student.java              
└── test/java/com/example/
    └── model/
        └── StudentTest.java 
```

## AAA Pattern Implementation

### What is the AAA Pattern?

The **Arrange-Act-Assert (AAA)** pattern is a way to structure unit tests that makes them more readable and maintainable:

- **Arrange**: Set up the test data and conditions
- **Act**: Execute the method or operation being tested
- **Assert**: Verify that the expected outcome occurred

### Example from StudentTest:

```java
@Test
@DisplayName("Should create student with valid constructor parameters")
void testStudentConstructor_ValidParameters_ShouldCreateStudent() {
    // ARRANGE
    String name = "Test Student";
    int age = 20;
    String email = "test@email.com";
    double gpa = 3.0;

    // ACT
    Student newStudent = new Student(name, age, email, gpa);

    // ASSERT
    assertEquals(name, newStudent.getName());
    assertEquals(age, newStudent.getAge());
    assertEquals(email, newStudent.getEmail());
    assertEquals(gpa, newStudent.getGpa());
}
```

## Setup and Teardown Methods

### @BeforeEach (Setup)
- Executed before each individual test method
- Used to initialize common test data and objects
- Ensures each test starts with a clean, known state

### @AfterEach (Teardown)
- Executed after each individual test method
- Used to clean up resources and reset state
- Ensures tests don't interfere with each other

### Example Implementation:

```java
@BeforeEach
void setUp() {
    System.out.println("Setting up Student test data...");
    
    // Arrange common test data
    validName = "Alice Johnson";
    validAge = 21;
    validEmail = "alice.johnson@university.edu";
    validGpa = 3.5;
    
    // Initialize student with valid data
    student = new Student(validName, validAge, validEmail, validGpa);
}

@AfterEach
void tearDown() {
    System.out.println("Cleaning up Student test data...");
    
    // Reset all references
    student = null;
    validName = null;
    validAge = 0;
    validEmail = null;
    validGpa = 0.0;
}
```

## Key Features Demonstrated

### 1. Student Model Class
- Basic properties: name, age, email, GPA
- Input validation with meaningful error messages
- Business logic methods (grade level calculation, honors eligibility)
- Proper equals() and hashCode() implementation

### 2. Comprehensive Test Coverage
- **Positive test cases**: Testing expected behavior with valid inputs
- **Negative test cases**: Testing error conditions and edge cases
- **Boundary testing**: Testing limits and edge values
- **Business logic testing**: Verifying complex calculations and decisions

## Test Categories Covered

### StudentTest (Model Testing)
- Constructor validation
- Setter method validation with error handling
- Business logic methods (grade level, honors eligibility)
- Object equality and string representation