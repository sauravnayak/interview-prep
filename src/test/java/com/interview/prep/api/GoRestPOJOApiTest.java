package com.interview.prep.api;

import com.interview.prep.utility.CustomListeners;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

@Listeners(CustomListeners.class)
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

    @Test(priority = 1)
    public void getAllUsers() {
        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer demo-token")
                .when()
                        .get("/users")
                .then()
                        .body(matchesJsonSchemaInClasspath("user-schema.json"))
                        .log().body()
                        .extract()
                        .response();
        totalItem = Integer.parseInt(response.header("x-pagination-total"));
        Assert.assertEquals(response.getStatusCode(), 200,
                "The Response code mismatch");
    }

    @Test(dependsOnMethods = "getAllUsers",priority =2)
    public void testPagination() {
        targetPage = Math.max(totalItem % 10,1);
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

    @Test(priority = 3)
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
    @Test(priority = 4,dependsOnMethods = "createUser")
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
    @Test(priority = 5, dependsOnMethods = "createUser")
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

    @Test(dependsOnMethods = "createUser", priority = 6)
    public void deleteUser() {
        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer demo-token")
        .when()
                .delete("users/" + userID)
        .then()
                .statusCode(204);
    }

    @Test(priority = 7)
    public void requestSpecResponseSpec() {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api")
                .setContentType(ContentType.JSON)
                .addHeader("x-api-key","free_user_3Gp42nmyMV2T0cvDYHfI4l79N7b")
                .build();

        // 2. Response specification matching exact JSON type
        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        // 3. Simple execution
        given()
                .spec(req)
                .when()
                .get("/users/2")
                .then()
                .spec(res)
                .log().body()
                .body("data.id", equalTo(2));
    }
//Running test with Data Provider
    @Test(priority = 3,dataProvider = "getUser",enabled = false)
    public void createUserDataProvider(String name, String email, String gender, String status) {
        Map<String,Object> user= new HashMap<>();
        user.put("name",name);
        user.put("email",email);
        user.put("gender",gender);
        user.put("status",status);
        userID =
                given()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer demo-token")
                        .body(user)
                        .when()
                        .post("/users")
                        .then()
                        .statusCode(201)
                        .body("id", greaterThan(1000))
                        .body("name", equalTo(user.get("name")))
                        .body("email", equalTo(user.get("email")))
                        .body("gender", equalTo(user.get("gender")))
                        .body("status", equalTo(user.get("status")))
                        .time(lessThan(2000L))
                        .log().ifValidationFails()
                        .extract()
                        .path("id");

    }


    @DataProvider(name = "getUser")
    public Object [] [] getusername(){
        return new Object[][]{{"Saurav","saurav1@example.com","male","active"},{"Nayak","saurav2@example.com","male","active"}};
    }

}
