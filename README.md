# SDET-Coding Interview 

Companion runnable project for the **Interview Assessment Prep Plan**.
Use it as your scratch repo: every task in the study doc (`DSA-01`, `API-01`, `SEL-04`, …)
gets implemented and run here so all your reps live in one place.

---

## 🚀 Key Framework Features

* **Thread-Safe Architecture:** Parallel test suite execution isolated cleanly via `DriverFactory`.
* **Real-time Logging Pipeline:** Log4j2 outputs routed straight to terminal streams, local file dumps (`target/logs/`), and step entries.
* **Automatic Failure Actions:** Automated page screenshot capturing and local storage management on failure states via TestNG's `CustomListeners`.

---

## 🛠️ Requirements
- JDK 17+
- Maven 3.8+
- Chrome Browser (Selenium Manager automatically resolves drivers locally)
---
## 📂 Repository Layout
```text
interview-prep/
├── pom.xml
├── testng.xml                          # Master execution suite switcher
├── src/main/java/com/interview/prep/
│   ├── dsa/
│   │   └── NthMax.java                 # DSA-01 (+ single-pass second largest)
│   └── web/
│       ├── LoginPage.java              # SEL-04 Page Object Model
│       └── DriverFactory.java          # FW-07 Factory pattern
└── src/test/
    ├── java/com/interview/prep/
    │   ├── api/                        # Suite: api (Disabled by default)
    │   │   ├── ApiTests.java           # API-01..API-13 RestAssured skeletons
    │   │   ├── GoRestApiTest.java
    │   │   └── GoRestPOJOApiTest.java
    │   ├── dsa/                        # Suite: dsa (Disabled by default)
    │   │   └── DSAProgramsTest.java
    │   ├── utility/                    # Support Hooks & Listeners
    │   │   ├── AllureLog4j2Appender.java
    │   │   └── CustomListeners.java
    │   └── web/                        # Suite: Selenium Test (Enabled)
    │       ├── AutocompleteTest.java
    │       ├── DragAndDropTest.java
    │       ├── DropDownTest.java
    │       ├── DynamicTableTest.java
    │       ├── IFrameTest.java
    │       ├── LocatorsTest.java
    │       ├── LoginTest.java
    │       ├── MultipleWindowsTest.java
    │       └── SlowTest.java
    └── resources/
        ├── log4j2-test.xml             # Log4j2 Configuration mapping
        └── user-schema.json            # JSON schema validation target
```

---

## 🧪 Execution & Commands

### 1. Run via TestNG Suite Configurations (`testng.xml`)
Running through Maven CLI ensures the **AspectJ Weaver javaagent** attaches properly to your framework threads, routing step details into the final dashboard:

```bash
# Execute active enabled blocks in testng.xml (Selenium Test by default)
mvn clean test

# Just a specific single class test target
mvn -Dtest=LoginTest test

# Run the NthMax program directly via CLI compilation
mvn -q compile exec:java -Dexec.mainClass=com.interview.prep.dsa.NthMax
```

### 2. Interactive Reporting
Run the following command in the project's base directory after a test run has been completed. This command builds and opens a web browser window displaying HTML test metrics, nested inline log steps, and failure screenshots:
```bash
allure serve target/allure-results
```

## Where to grow it
- Add each new **DSA-xx** program under `dsa/` with a matching test.
- Add API scenarios to `ApiTests` (schema validation, auth chain, data-driven).
- Add more page objects under `web/` and a `BaseTest` for driver setup/teardown.
- Drop `user-schema.json` in `src/test/resources/` and enable `getUser_matchesSchema`.

**Allure Reporting**

Run the following command in project's base directory after test run has been completed. This command will open a browser window with HTML test results.
```
allure serve target/allure-results
```
## Notes
- `reqres.in` now needs a free API key header: `x-api-key: reqres-free-v1` (already set in `ApiTests`).
- Swap the base URI / auth for whatever mock service you wish to use.

## 🤝 Contribution

1. Fork the project.
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.
