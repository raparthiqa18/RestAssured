package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.hu.Ha;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.IsNot;
import utilities.RestassuredExtensions;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DELETEProfilesteps {
    private static ResponseOptions<Response> response;

    @And("I perform DELETE operation for {string}")
    public void iPerformDELETEOperationFor(String url, DataTable table) throws URISyntaxException {
        var data=table;
        HashMap<String, String> pathparams=new HashMap<>();
        pathparams.put("postID", data.cell(1, 0));

        response= RestassuredExtensions.DeleteOps(url, pathparams);

    }

    @Then("I should not see the body with title as {string}")
    public void iShouldNotSeeTheBodyWithTitleAs(String title) {
        assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
    }
}
