package com.testIT.step_definitions;

import com.testIT.pages.MainApi;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class ApiTest5_DeleteDefs {

    @When("the user sends a delete request to {string} end point with the userId {int}")
    public void the_user_sends_a_delete_request_to_end_point_with_the_userId(String endPoint, Integer uId) {
        String finalEndPoint = endPoint + uId;
        MainApi.sendDeleteRequest(finalEndPoint);
    }

    @Then("the response payload data should be empty")
    public void the_response_payload_data_should_be_empty() {
        Assert.assertFalse(MainApi.getResponse().body().asString().contains("id"));
    }
}
