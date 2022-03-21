import io.restassured.response.ResponseOptions;
import utilities.RestassuredExtensions;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class ValidateJSONSchema {
    public static ResponseOptions Response;
    public static void main(String[] args) {
        RestassuredExtensions restassuredExtensions=new RestassuredExtensions();
        Response=RestassuredExtensions.GetOps("api/users");

        //Place the JSON file always in the target\classes folder as all the compiled classes are saved here
        assertThat(Response.getBody().asString(), matchesJsonSchemaInClasspath("apiusers.json"));
    }
}
