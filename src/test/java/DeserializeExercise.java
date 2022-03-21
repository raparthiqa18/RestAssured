import POJO.UsersPojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestassuredExtensions;

public class DeserializeExercise {
    private static ResponseOptions<Response> Response;
//    @JsonIgnoreProperties(ignoreUnknown = true)
    public static void main(String[] args) throws JsonProcessingException {
        RestassuredExtensions restassuredExtensions=new RestassuredExtensions();
        Response=RestassuredExtensions.GetOps("/api/users");
        System.out.println(Response.statusCode());

        //Deserialize the response body
        UsersPojo usersPojo=Response.getBody().as(UsersPojo.class);
        System.out.println(usersPojo.getPer_page());

        System.out.println(usersPojo.getData().get(0).getEmail());

    }
}
