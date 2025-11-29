# Selenium Cucumber Automation Test Project

## Description
This is a comprehensive automation testing project using Selenium WebDriver, Cucumber BDD, and Extent Reports for testing web applications. The project implements the Page Object Model (POM) design pattern and includes advanced reporting with screenshots on test failures.

## Features
- ✅ **Selenium WebDriver** for browser automation
- ✅ **Cucumber BDD** with Gherkin syntax for readable test scenarios
- ✅ **Page Object Model (POM)** for maintainable test code
- ✅ **Extent Reports** for detailed HTML test reports
- ✅ **Automatic Screenshot Capture** on test failures
- ✅ **Scenario Outline** support for data-driven testing
- ✅ **WebDriverManager** for automatic driver management

## Technologies Used
- **Java 17**
- **Maven** - Dependency management and build tool
- **Selenium WebDriver 4.12.1** - Browser automation
- **Cucumber 7.11.0** - BDD framework
- **JUnit 5** - Test execution
- **Extent Reports 5.0.6** - Advanced reporting
- **WebDriverManager 5.7.0** - Automatic driver management

## Project Structure
```
AutoTest/
├── src/
│   ├── main/java/
│   │   ├── org/example/
│   │   │   └── Main.java
│   │   └── pages/
│   │       ├── LoginPage.java
│   │       └── SubmitFormPage.java
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── TestBase.java
│       │   ├── stepdefinitions/
│       │   │   ├── CucumberRunner.java
│       │   │   ├── RunCucumberTest.java
│       │   │   ├── Hooks.java
│       │   │   ├── LoginStep.java
│       │   │   └── SubmitFormStep.java
│       │   └── utils/
│       │       ├── ExtentManager.java
│       │       └── ExtentTestManager.java
│       └── resources/
│           ├── features/
│           │   └── login.feature
│           └── cucumber.properties
├── pom.xml
└── README.md
```

## Prerequisites
- Java JDK 17 or higher
- Maven 3.6+
- Chrome browser (or modify for other browsers)

## Installation

1. **Clone the repository**
   ```bash
   git clone <your-repo-url>
   cd AutoTest
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

## Running Tests

### Run all tests
```bash
mvn test
```

### Run specific test runner
```bash
mvn -Dtest=CucumberRunner test
```

### Run tests from batch file (Windows)
```bash
run-tests.bat
```

### Compile and run
```bash
compile-and-run.bat
```

## Test Reports

After test execution, reports are generated in:
- **Extent Report**: `target/ExtentReport.html` (Detailed HTML report with screenshots)
- **Cucumber Reports**: `target/cucumber-reports/`
- **Screenshots**: `target/screenshots/` (Captured on test failures)
- **Surefire Reports**: `target/surefire-reports/`

## Test Scenarios

### Login Functionality
The project includes login test scenarios with both valid and invalid credentials:

- **Successful Login**: Tests with valid credentials
- **Failed Login**: Tests with invalid credentials (multiple data sets)

Example feature file:
```gherkin
Feature: Authentication

  @ValidCredentials
  Scenario Outline: Successful login
    Given the user is on the login page
    When the user enters a username as "<username>"
    And the user enters a password as "<password>"
    And clicks on the login button
    Then the user should see a success message

    Examples:
      | username  | password                 |
      | tomsmith  | SuperSecretPassword!     |

  @InvalidCredentials
  Scenario Outline: Failed login
    Given the user is on the login page
    When the user enters a username as "<username>"
    And the user enters a password as "<password>"
    And clicks on the login button
    Then the user should see an error message

    Examples:
      | username    | password  |
      | invaliduser | wrongpass |
      | admin       | 123456    |
```

## Configuration

### Cucumber Properties
Located in `src/test/resources/cucumber.properties`:
```properties
cucumber.publish.enabled=true
cucumber.publish.quiet=true
```

### Maven Surefire Plugin
Configured to run test classes matching `*Runner` pattern.

## Key Components

### TestBase
- Static WebDriver and WebDriverWait management
- Browser setup and teardown
- Screenshot capture functionality

### Hooks
- BeforeAll/Before setup for test initialization
- AfterAll/After teardown with screenshot capture on failure
- Extent Report integration

### Page Objects
- `LoginPage`: Encapsulates login page elements and actions
- Clean separation of test logic from page interactions

### Extent Reports Integration
- Real-time logging of test steps
- Screenshot attachment on failures
- Dark theme HTML reports
- Pass/Fail status tracking

## Best Practices Implemented
- ✅ Page Object Model for better maintainability
- ✅ Explicit waits for reliable element interactions
- ✅ Centralized driver management
- ✅ Screenshot capture for debugging failures
- ✅ Detailed reporting with Extent Reports
- ✅ BDD approach with Cucumber for business-readable tests
- ✅ Data-driven testing with Scenario Outline
- ✅ Proper resource cleanup in Hooks

## Test Site
The project uses [The-Internet Herokuapp](https://the-internet.herokuapp.com/) for demonstration:
- Login page: https://the-internet.herokuapp.com/login

## Contributing
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Troubleshooting

### Tests not running
- Ensure Java 17 is installed: `java -version`
- Clean and rebuild: `mvn clean install`
- Check Chrome browser is installed

### WebDriver errors
- WebDriverManager handles driver downloads automatically
- Check internet connection for driver downloads
- Verify Chrome browser version compatibility

### Screenshot issues
- Screenshots saved to `target/screenshots/`
- Check disk space and write permissions

## License
This project is created for educational purposes.

## Author
[Your Name]

## Acknowledgments
- Selenium WebDriver community
- Cucumber BDD framework
- Extent Reports team
