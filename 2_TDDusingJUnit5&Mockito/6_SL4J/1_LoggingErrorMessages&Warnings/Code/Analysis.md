# SLF4J Logging Example

This project demonstrates logging error messages and warning levels using SLF4J with Logback.

## Project Structure
```
Code/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── LoggingExample.java
│       └── resources/
│           └── logback.xml
└── README.md
```

## Dependencies
- **SLF4J API 1.7.30**: Simple Logging Facade for Java API
- **Logback Classic 1.2.3**: The logging implementation

## Expected Output
The application will:
- Display log messages on the console with timestamps and log levels
- Create a `logs/` directory with two files:
  - `application.log`: Contains all log messages
  - `error.log`: Contains only error messages

## Log Configuration
The `logback.xml` file controls:
- **Console Appender**: Displays logs in the console
- **File Appender**: Writes all logs to `application.log`
- **Error File Appender**: Writes only ERROR level logs to `error.log`
- **Log Format**: Timestamp, thread, level, logger name, and message

## Logging Levels (from most to least verbose)
1. **TRACE**: Most detailed information
2. **DEBUG**: Debug information
3. **INFO**: General information
4. **WARN**: Warning messages
5. **ERROR**: Error messages

By default, the root logger is set to INFO level, so TRACE and DEBUG messages won't be displayed unless you change the configuration.
