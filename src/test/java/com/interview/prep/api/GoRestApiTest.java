package com.interview.prep.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GoRestApiTest {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI="https://gorest.in";
        RestAssured.basePath="/public/v2";
    }

    @Test
    public void getAllUsers(){
        given()
                .header("Accept","application/json")
        .when()
                .get("/users")
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().body()
                .body("[0].id",equalTo(1001))
                .body("[0].name",containsString("Aarav Sharma"))
                .body("[0]",hasKey("gender"))
                .body("name",hasItems("Aarav Sharma","Priya Mehta","Rohan Verma"))
                .body("gender",hasItems("male","female"))
                .body("[0].id",greaterThan(1000));

    }

    @Test()
    public void createUserSaurav(){
        int random=new Random().nextInt(100);
        Map<String,Object> requestBody = new HashMap<>();
        requestBody.put("name","Saurav");
        requestBody.put("id",1018);
        requestBody.put("email","saurav"+random+"@example.com");
        requestBody.put("gender","male");
        requestBody.put("status","active");

        given()
                .header("Authorization","Bearer Saurav")
                .header("Content-Type","application/json")
                .body(requestBody)
        .when()
                .post("users")
        .then()
                .log().body()
                .statusCode(201)
                .log().body()
                .body("name",equalTo("Saurav"))
                .body("id",greaterThan(1000))
                .body("email",equalTo("saurav"+random+"@example.com"));
    }


}
