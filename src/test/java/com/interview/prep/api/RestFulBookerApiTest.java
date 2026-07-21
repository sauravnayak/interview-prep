package com.interview.prep.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestFulBookerApiTest {
    private String token;
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
    }

    @Test(priority = 0)
    public void login(){
        token =given()
                .contentType(ContentType.JSON)
                .body("{\"username\":\"admin\",\n \"password\":\"password123\"}")
        .when()
                .post("/auth")
        .then()
                .log().body()
                .body("token",notNullValue())
                .extract().jsonPath().get("token");
    }
    @Test(priority = 0)
    public void loginUsingAuthBasic(){
        Map<String, Object> credentials = new HashMap<>();
        credentials.put("username", "admin");
        credentials.put("password", "password123");

        token =
                given()
                    .contentType(ContentType.JSON)
                    .body(credentials)
                .when()
                    .post("/auth")
                .then()
                    .log().body()
                    .body("token",notNullValue())
                    .extract().jsonPath().get("token");
        System.out.println(token);
    }
    @Test(priority = 1)
    public void deleteBookingUsingBasicAuth() {
        String u="admin";
        String p="password123";
        given()
                // Passing credentials natively via Basic authorization headers works for resource mutations
                .auth().preemptive().basic(u, p)
                .contentType(ContentType.JSON)
                .when()
                .delete("/booking/968") // Targets a specific created record index
                .then()
                .log().status()
                .statusCode(201); // Restful-Booker deletes return 201 Created status signals
    }

    @Test(priority = 1,dependsOnMethods = "login")
    public void getBooking(){
        given()
                .contentType(ContentType.JSON)
                //.header("token",token)
        .when()
                .get("/booking")
        .then()
                .log().body()
                .body("bookingid",notNullValue())
                .body("bookinngid",hasSize(greaterThan(4000)));
    }
}
