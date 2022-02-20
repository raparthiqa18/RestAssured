package steps;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.*;

public class BDDStylemethod {

    public static void simpleGETPost(String postNumber){
        given()
                .contentType(ContentType.JSON)
        .when()
                .get(String.format("http://localhost:3000/posts/%s", postNumber))
        .then()
                .body("author", is("typicode"))
                .statusCode(200);
    }

    public static void performContainsColelction(){
        given()
                .contentType(ContentType.JSON)
        .when()
                .get(("http://localhost:3000/posts"))
        .then()
                .body("author", containsInAnyOrder("typicode"));
    }

    public static void performPathParam(){
        given()
                .contentType(ContentType.JSON).
        with()
                .pathParams("post", 1)
        .when()
                .get(("http://localhost:3000/posts/{post}"))
        .then()
                .body("author", containsString("typicode"));
    }

    public static void performQueryParam(){
        given()
                .contentType(ContentType.JSON)
                .queryParam("id", 1)
        .when()
                .get(("http://localhost:3000/posts/"))
        .then()
                .body("author", containsString("typicode"));
    }
}
