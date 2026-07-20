package com.interview.prep.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GoRestPOJOApiTest {

    int random = new Random().nextInt(100);
    private String email = "sauravn" + random + "@example.com";
    private UserPOJO user1 = new UserPOJO("Saurav", email, "male", "active");
    private UserPOJO user2 = new UserPOJO("Saurav Nayak", email, "male", "inactive");
    private int userID;
    private int totalItem;
    private int targetPage;
    private int targetLimit;


    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://gorest.in";
        RestAssured.basePath = "/public/v2";
    }

    @Test()
    public void getAllUsers() {
        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer demo-token")
                .when()
                        .get("/users")
                .then()
                        .log().body()
                        .extract()
                        .response();
        totalItem = Integer.parseInt(response.header("x-pagination-total"));
        Assert.assertEquals(response.getStatusCode(), 200,
                "The Response code mismatch");
    }

    @Test(dependsOnMethods = "getAllUsers")
    public void testPagination() {
        targetPage = totalItem % 10;
        targetLimit = 5;
        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer demo-token")
                        .queryParam("page", targetPage)
                        .queryParam("per_page", targetLimit)
                .when()
                        .get("/users")
                .then()
                        .log().body()
                        .extract()
                        .response();
        Assert.assertEquals(Integer.parseInt(response.header(
                "x-pagination-limit")), targetLimit);
        Assert.assertEquals(Integer.parseInt(response.header(
                "x-pagination-page")), targetPage);
        Assert.assertEquals(response.getStatusCode(), 200,
                "The Response code mismatch");

    }

    @Test(priority = 1)
    public void createUser() {
        userID =
        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer demo-token")
                .body(user1)
        .when()
                .post("/users")
        .then()
                .log().body()
                .statusCode(201)
                .body("id", greaterThan(1000))
                .body("name", equalTo("Saurav"))
                .body("email", equalTo(email))
                .body("$", hasKey("gender"))
                .body("status", equalTo("active"))
                .extract()
                .path("id");

    }

    //Example of PUT
    @Test(priority = 2)
    public void updateUser() {
        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer demo-token")
                .body(user2)
        .when()
                .put("users/" + userID)
        .then()
                .log().body()
                .body("id", greaterThan(1000))
                .body("name", equalTo(user2.getName()))
                .body("email", equalTo(user2.getEmail()))
                .body("gender", equalTo(user2.getGender()))
                .body("status", equalTo(user2.getStatus()));

    }

    //Example of Patch
    @Test(priority = 3)
    public void updateEmail() {
        String updatedEmail = "sauravnayak9@example.com";
        String emailBody = "{\"email\":\"" + updatedEmail + "\"}";
        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer demo-token")
                .body(emailBody)
        .when()
                .patch("users/" + userID)
        .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(user2.getName()))
                .body("email", equalTo(updatedEmail))
                .body("gender", equalTo(user2.getGender()))
                .body("status", equalTo(user2.getStatus()))
                .body("id", greaterThan(1000))
                .log().body();
    }

    @Test(dependsOnMethods = "createUser", priority = 4)
    public void deleteUser() {
        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer demo-token")
        .when()
                .delete("users/" + userID)
        .then()
                .statusCode(204);
    }

}
