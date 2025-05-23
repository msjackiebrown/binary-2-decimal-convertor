# Building and Running the Binary-to-Decimal Converter

This document provides instructions on how to build and run the Binary-to-Decimal Converter application.

## Prerequisites

- Java Development Kit (JDK) 21 or later
- Maven 3.6+ (optional, as the project includes Maven Wrapper)

## Building the Project

### Using Maven Wrapper (Recommended)

The project includes a Maven Wrapper, which allows you to build the project without installing Maven.

#### On Windows:
```powershell
.\mvnw.cmd clean package
```

#### On macOS/Linux:
```bash
./mvnw clean package
```

### Using Maven (if installed)

If you have Maven installed on your system, you can use it directly:

```bash
mvn clean package
```

## Running the Application

### Using Maven Wrapper

#### On Windows:
```powershell
.\mvnw.cmd javafx:run
```

#### On macOS/Linux:
```bash
./mvnw javafx:run
```

### Using Maven (if installed)

```bash
mvn javafx:run
```

## Running Tests

### Using Maven Wrapper

#### On Windows:
```powershell
.\mvnw.cmd test
```

#### On macOS/Linux:
```bash
./mvnw test
```

### Using Maven (if installed)

```bash
mvn test
```

## Creating a Standalone Distribution

To create a standalone distribution that can be run without Maven:

### Using Maven Wrapper

#### On Windows:
```powershell
.\mvnw.cmd javafx:jlink
```

#### On macOS/Linux:
```bash
./mvnw javafx:jlink
```

### Using Maven (if installed)

```bash
mvn javafx:jlink
```

This will create a distribution in the `target/app` directory. You can run the application using:

#### On Windows:
```powershell
target\app\bin\launcher.bat
```

#### On macOS/Linux:
```bash
./target/app/bin/launcher
```

## Project Structure

- `src/main/java` - Java source files
- `src/main/resources` - Application resources (FXML, CSS, properties files)
- `src/test/java` - Test source files
- `logs/` - Application log files

## Troubleshooting

### Common Issues

#### JavaFX Not Found

If you encounter an error related to JavaFX not being found, ensure that you are using the Maven commands to run the application, as they will download the necessary dependencies.

#### Log File Permissions

If the application fails to write log files, ensure that the `logs/` directory has the appropriate write permissions.

#### Compiler Errors

If you encounter compiler errors related to Java version, ensure that you have JDK 21 or later installed and properly configured in your PATH.
