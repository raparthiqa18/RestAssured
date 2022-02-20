package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestassuredExtensions;

import javax.xml.crypto.Data;
import java.net.URISyntaxException;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GETPoststeps {

    private static ResponseOptions<Response> response;



    public static class MyStepdefs {

        @Given("I perform GET operation for {string}")
        public void iPerformGETOperationFor(String url) {
            response=RestassuredExtensions.GetOps(url);
        }

        @Then("I should see the author name as {string}")
        public void iShouldSeeTheAuthorNameAs(String authorName) {
            assertThat(response.getBody().jsonPath().get("author"), hasItem(authorName));
        }

        @Then("I should see the body has name as {string}")
        public void iShouldSeeTheBodyHasNameAs(String name) {
            assertThat(response.getBody().jsonPath().get("name"), equalTo(name));
        }

        @And("I perform GET operation with path parameter for {string}")
        public void iPerformGETOperationWithPathParameterFor(String url, DataTable table) {
            var data=table;
            HashMap<String, String> pathparams=new HashMap<>();
            pathparams.put("postID", data.cell(1, 0));
            response= RestassuredExtensions.GetOps(url, pathparams);
        }

        @Then("I should see the author names")
        public void iShouldSeeTheAuthorNames() {BDDStylemethod.performContainsColelction();}

        @Then("I should verify perform parameter")
        public void iShouldVerifyPerformParameter() {
            BDDStylemethod.performPathParam();
        }

        @Then("I should verify perform Query parameter")
        public void iShouldVerifyPerformQueryParameter() {
            BDDStylemethod.performQueryParam();
        }

        @And("I perform GET for the post number {string}")
        public void iPerformGETForThePostNumber(String postNumber) {
            BDDStylemethod.simpleGETPost(postNumber);
        }



    }
}


