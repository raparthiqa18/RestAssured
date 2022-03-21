import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SampleRestAssured {
    public static RequestSpecification Request;
    public static ResponseOptions Response;
    /*URL: https://reqres.in/api/users
    GET response
    {"page":1,"per_page":6,"total":12,"total_pages":2,"data":[{"id":1,"email":"george.bluth@reqres.in","first_name":"George","last_name":"Bluth","avatar":"https://reqres.in/img/faces/1-image.jpg"},{"id":2,"email":"janet.weaver@reqres.in","first_name":"Janet","last_name":"Weaver","avatar":"https://reqres.in/img/faces/2-image.jpg"},{"id":3,"email":"emma.wong@reqres.in","first_name":"Emma","last_name":"Wong","avatar":"https://reqres.in/img/faces/3-image.jpg"},{"id":4,"email":"eve.holt@reqres.in","first_name":"Eve","last_name":"Holt","avatar":"https://reqres.in/img/faces/4-image.jpg"},{"id":5,"email":"charles.morris@reqres.in","first_name":"Charles","last_name":"Morris","avatar":"https://reqres.in/img/faces/5-image.jpg"},{"id":6,"email":"tracey.ramos@reqres.in","first_name":"Tracey","last_name":"Ramos","avatar":"https://reqres.in/img/faces/6-image.jpg"}],"support":{"url":"https://reqres.in/#support-heading","text":"To keep ReqRes free, contributions towards server costs are appreciated!"}}
     */

    public static void main(String[] args) throws URISyntaxException {
        RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://reqres.in");
        requestSpecBuilder.setContentType(ContentType.JSON);
        var requestSpec=requestSpecBuilder.build();
        Request = given().spec(requestSpec);

        Response=Request.get(new URI("/api/users"));
        System.out.println(Response.statusCode());
        int pagecount=Response.getBody().jsonPath().get("page");
        String firstpageemail=Response.getBody().jsonPath().get("data[0].email");
        System.out.println("Total page count : " + pagecount + "  Email id of the first page: " + firstpageemail);

    }
}
