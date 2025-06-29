# Mockito Mocking and Stubbing Exercise

Welcome! This guide walks through **Exercise 1: Mocking and Stubbing** using Mockito with JUnit 5.

## Project Overview

Here’s how the project is organized:
```
src/
├── main/java/
│   └── com/example/
│       ├── api/
│       │   └── ExternalApi.java          
│       └── service/
│           └── MyService.java            
└── test/java/
    └── com/example/service/
        └── MyServiceTest.java           
```

## What Will Be Learned

### 1. Creating Mock Objects
Create mock objects for dependencies:
```java
@Mock
private ExternalApi mockApi;
```

### 2. Stubbing Methods
Control mock behavior by stubbing methods:
```java
when(mockApi.getData()).thenReturn("Mock Data");
```

### 3. Verifying Interactions
Check if mocks were used as expected:
```java
verify(mockApi).getData();
```

## Main Components

### ExternalApi Interface
- `getData()` – Retrieves data from an external service
- `getDataById(String id)` – Gets data for a specific ID
- `isAvailable()` – Checks if the service is up

### MyService Class
- `fetchData()` – Fetches basic data
- `fetchDataById(String id)` – Fetches data using an ID
- `processData()` – Processes data with business logic
- `getServiceStatus()` – Checks the health of the service

### Test Scenarios Covered

1. **Basic mocking and stubbing** – Core exercise
2. **Stubbing with parameters** – Handling method arguments
3. **Service unavailability** – Testing error cases
4. **Null and empty data** – Edge case handling
5. **Argument matchers** – Using helpers like `anyString()`
6. **Method call verification** – Checking call counts with `times()`, `never()`, etc.

## Mockito Features in Action

### Annotations
- `@ExtendWith(MockitoExtension.class)` – Enables Mockito in JUnit 5
- `@Mock` – Declares mock objects
- `@BeforeEach` – Runs setup before each test

### Stubbing and Matchers
- `when().thenReturn()` – Basic stubbing
- `anyString()` – Flexible argument matching
- `never()` – Ensures a method wasn’t called
- `times(n)` – Checks how many times a method was called

### Verification
- `verify()` – Confirms method calls
- `verify(mock, times(n))` – Checks exact call counts
- `verify(mock, never())` – Ensures a method wasn’t called at all

This exercise will help build comfort with Mockito’s core features and best practices for unit testing in Java.