## Elitea Playwright Demo TAF
Skeleton Test Automation Framework using Playwright + JUnit 5 + REST Assured + Maven.

### Stack
- Playwright (Java)
- JUnit 5
- REST Assured
- Lombok
- Maven

### Project structure
```
src/
  main/java/com/elitea/
    core/config/            # Config model + loader
    core/playwright/        # Playwright manager (thread-safe)
    ui/pages/               # Base and concrete page objects
  test/java/com/elitea/tests/
    ui/                     # UI tests
    api/                    # API tests
  test/resources/
    config/                 # common.properties, <env>.properties
    logback-test.xml        # test logging
pom.xml
.gitignore
```

### Setup
1) Ensure JDK 17+ and Maven are installed.
2) Install Playwright browsers (first time only):
```bash
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```

### Run tests
- UI + API tests (default env=local):
```bash
mvn test
```

- Run in headed mode:
```bash
mvn test -Dheadless=false
```

- Specify environment (uses `src/test/resources/config/<env>.properties`):
```bash
mvn test -Denv=qa
```

### Conventions
- Page Objects in `com.elitea.ui.pages`, tests in `com.elitea.tests.ui`.
- API base config in `BaseApiTest` with REST Assured.
- Config precedence: `common.properties` overridden by `<env>.properties`.

### Notes
- Example UI test: `HomePageTest` navigates to `baseUrl` and asserts page title is present.
- Example API test: `HealthApiTest` hits `/health` and validates response status.
