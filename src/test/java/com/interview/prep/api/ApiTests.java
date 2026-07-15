package com.interview.prep.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

/**
 * API-01..API-10 skeletons against reqres.in.
 * NOTE: reqres.in requires a free API key header: x-api-key: reqres-free-v1
 * Swap baseUri/headers for whatever service the CodeSignal question provides.
 */
public class ApiTests {

    private RequestSpecification req;
    private ResponseSpecification okJson;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
        req = new RequestSpecBuilder()
                .addHeader("x-api-key", "reqres-free-v1")
                .setContentType(ContentType.JSON)
                .build();
        okJson = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    // API-01 — GET + assert status, content-type, body fields
    @Test
    public void getUser_returns200_withFields() {
        given().spec(req)
        .when().get("/users/2")
        .then().spec(okJson)
                .body("data.id", equalTo(2))
                .body("data.email", containsString("@reqres.in"))
                .body("data", hasKey("first_name"));
    }

    // API-02 — POST create + assert 201 and echoed fields
    @Test
    public void createUser_returns201() {
        String body = "{\"name\":\"saurav\",\"job\":\"SDET\"}";
        given().spec(req).body(body)
        .when().post("/users")
        .then().statusCode(201)
                .body("name", equalTo("saurav"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }

    // API-07 — extract a value and reuse it
    @Test
    public void extractIdFromCreate() {
        String id = given().spec(req).body("{\"name\":\"a\",\"job\":\"b\"}")
                .when().post("/users")
                .then().statusCode(201)
                .extract().path("id");
        org.testng.Assert.assertNotNull(id);
    }

    // API-09 — JSON schema validation (place user-schema.json on the test classpath)
    @Test(enabled = false) // enable after you add src/test/resources/user-schema.json
    public void getUser_matchesSchema() {
        given().spec(req)
        .when().get("/users/2")
        .then().statusCode(200)
                .body(matchesJsonSchemaInClasspath("user-schema.json"));
    }

    // API-13 — negative: non-existent resource -> 404
    @Test
    public void getMissingUser_returns404() {
        given().spec(req)
        .when().get("/users/23")
        .then().statusCode(404);
    }
}
