package utilities;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class RestassuredExtensions {
    public static RequestSpecification Request;
    public static ResponseOptions<Response> response;

    public RestassuredExtensions(){
        //Arrange
        RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
//        requestSpecBuilder.setBaseUri("http://localhost:3000");
        requestSpecBuilder.setBaseUri("https://reqres.in");
        requestSpecBuilder.setContentType(ContentType.JSON);
        var requestSpec=requestSpecBuilder.build();
        Request = given().spec(requestSpec);
    }

    public static void main(String[] args) {
        RestassuredExtensions restassuredExtensions=new RestassuredExtensions();
       response= GetOps("/api/users");
//        response.getBody().prettyPrint();
        System.out.println(response.getBody().jsonPath().get("data[1].id").toString());
        System.out.println(response.getBody().jsonPath().get("data[1].email").toString());

        int arr=response.getBody().jsonPath().getInt("data.size()");
        int id=0;
        for(int i=1; i<arr; i++){
            id= Integer.parseInt(response.getBody().jsonPath().get("data["+ i + "].id").toString());
            if(id==2){
                System.out.println(response.getBody().jsonPath().get("data["+ i + "].email").toString());
                break;
            }
        }
    }

    public static ResponseOptions<Response> GetOps(String url){
        //Act
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> GetOps(String url, Map<String, String> pathParam){
        //Act
        Request.pathParams(pathParam);
        return Request.get((url));
    }

    public static ResponseOptions<Response> PostOps(String url, Map<String, String> body) throws URISyntaxException {
        Request.body(body);
        try {
            return Request.post(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ResponseOptions<Response> PostOps(String url, String id){
        HashMap<String, String > postContent= new HashMap<>();
        postContent.put("id", id);
        postContent.put("title", String.format("test%s", id));
        postContent.put("author", String.format("typicode%s", id));
        Request.body(postContent);
        try {
            return Request.post(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> PostOps(String url, Map<String, String> pathparams, Map<String, String> body) throws URISyntaxException {
        Request.pathParams(pathparams);
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> DeleteOps(String url, Map<String, String> pathparams) throws URISyntaxException {
        Request.pathParams(pathparams);
        return Request.delete(url);
    }


    public static ResponseOptions<Response> PutOps(String url, HashMap<String, String> pathparam, HashMap<String, String> body) {
        Request.pathParams(pathparam);
        Request.body(body);
        return Request.put(url);
    }
}
