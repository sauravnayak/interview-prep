# SDET-Coding Interview 

Companion runnable project for the **Interview Assessment Prep Plan**.
Use it as your scratch repo: every task in the study doc (`DSA-01`, `API-01`, `SEL-04`, …)
gets implemented and run here so all your reps live in one place.

## Requirements
- JDK 17+
- Maven 3.8+
- (Optional) Chrome for the Selenium example; Selenium Manager auto-resolves the driver.

## Layout
```
inteview-prep/
├── pom.xml
├── src/main/java/com/interview/prep/
│   ├── dsa/NthMax.java          # DSA-01 (+ single-pass second largest)
│   └── web/
│       ├── LoginPage.java       # SEL-04 Page Object Model
│       └── DriverFactory.java   # FW-07 Factory pattern
└── src/test/
    ├── java/com/interview/prep/
    │   ├── dsa/NthMaxTest.java   # DSA-01 tests with edge cases
    │   └── api/ApiTests.java     # API-01..API-13 RestAssured skeletons
    └── resources/testng.xml      # parallel suite
```

## Run
```bash
# Everything in the TestNG suite (DSA + API)
mvn test

# Just the DSA tests
mvn -Dtest=NthMaxTest test

# Just the API tests
mvn -Dtest=ApiTests test

# Run the NthMax program directly
mvn -q compile exec:java -Dexec.mainClass=dsa.com.interview.prep.NthMax
```

## Where to grow it
- Add each new **DSA-xx** program under `dsa/` with a matching test.
- Add API scenarios to `ApiTests` (schema validation, auth chain, data-driven).
- Add more page objects under `web/` and a `BaseTest` for driver setup/teardown.
- Drop `user-schema.json` in `src/test/resources/` and enable `getUser_matchesSchema`.

## Notes
- `reqres.in` now needs a free API key header: `x-api-key: reqres-free-v1` (already set in `ApiTests`).
- Swap the base URI / auth for whatever mock service you wish to use.
