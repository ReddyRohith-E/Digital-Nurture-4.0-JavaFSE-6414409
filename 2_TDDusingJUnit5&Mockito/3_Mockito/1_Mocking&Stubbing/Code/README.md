# Mockito Mocking and Stubbing Exercise

This project demonstrates **Exercise 1: Mocking and Stubbing** using Mockito and JUnit 5.

## Project Structure
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

## Key Concepts Demonstrated

### 1. Creating Mock Objects
```java
@Mock
private ExternalApi mockApi;
```

### 2. Stubbing Methods
```java
when(mockApi.getData()).thenReturn("Mock Data");
```

### 3. Verification
```java
verify(mockApi).getData();
```

## Features Implemented

### ExternalApi Interface
- `getData()` - Fetches data from external service
- `getDataById(String id)` - Fetches data by specific ID
- `isAvailable()` - Checks service availability

### MyService Class
- `fetchData()` - Basic data fetching
- `fetchDataById(String id)` - Data fetching with ID parameter
- `processData()` - Data processing with business logic
- `getServiceStatus()` - Service health check

### Test Cases
1. **Basic mocking and stubbing** - The main exercise requirement
2. **Stubbing with parameters** - Using method arguments
3. **Service unavailability handling** - Testing error scenarios
4. **Null and empty data handling** - Edge case testing
5. **Argument matchers** - Using `anyString()` and similar matchers
6. **Method call verification** - Using `times()`, `never()` etc.


## Key Mockito Features Used

### Annotations
- `@ExtendWith(MockitoExtension.class)` - Enables Mockito in JUnit 5
- `@Mock` - Creates mock objects
- `@BeforeEach` - Setup method before each test

### Stubbing Methods
- `when().thenReturn()` - Basic stubbing
- `anyString()` - Argument matchers
- `never()` - Verification that method was not called
- `times(n)` - Verification of exact number of calls

### Verification
- `verify()` - Verifies method calls
- `verify(mock, times(n))` - Verifies exact number of calls
- `verify(mock, never())` - Verifies method was never called