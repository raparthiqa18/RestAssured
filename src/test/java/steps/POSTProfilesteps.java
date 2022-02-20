package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.Is;
import utilities.RestassuredExtensions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.net.URISyntaxException;
import java.util.HashMap;

public class POSTProfilesteps {
    private static ResponseOptions<Response> response;

    @Given("I perform POST operation for {string}, {string}")
    public void iPerformPOSTOperationFor(String url, String id) {
        response= RestassuredExtensions.PostOps("url", id);
    }

    @Given("I perform Post operation for {string} with body")
    public void iPerformPostOperationForWithBody(String url, DataTable table) throws URISyntaxException {
        //Cucumber table data retrieve
        var data=table;
        //set body
        HashMap<String, String> body=new HashMap<>();
        body.put("name", data.cell(1, 0));
        //path params
        HashMap<String, String > pathparam=new HashMap<>();
        pathparam.put("profileNo", data.cell(1, 1));
        //Perform post operation
        response=RestassuredExtensions.PostOps(url, pathparam, body);
    }

    @Given("I ensure to Perform Post operation for {string} with body as")
    public void iEnsureToPerformPostOperationForWithBodyAs(String url, DataTable table) throws URISyntaxException {
        var data=table;

        HashMap<String, String > body= new HashMap<>();
        body.put("id", data.cell(1,0));
        body.put("title", data.cell(1,1));
        body.put("author", data.cell(1,2));

        response=RestassuredExtensions.PostOps(url, body);
    }


    @And("I perform PUT operation for {string}")
    public void iPerformPUTOperationFor(String url, DataTable table) {
        var data=table;
        //path params
        HashMap<String, String > pathparam=new HashMap<>();
        pathparam.put("postID", data.cell(1, 0));
        //body
        HashMap<String, String > body= new HashMap<>();
        body.put("id", data.cell(1,0));
        body.put("title", data.cell(1,1));
        body.put("author", data.cell(1,2));

        response=RestassuredExtensions.PutOps(url, pathparam, body);
    }

    @Then("I should see the body with title as {string}")
    public void iShouldSeeTheBodyWithTitleAs(String title) {
        assertThat(response.getBody().jsonPath().get("title"), equalTo(title));
    }
}
