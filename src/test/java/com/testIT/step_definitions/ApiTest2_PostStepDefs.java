package com.testIT.step_definitions;

import com.testIT.pages.MainApi;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class ApiTest2_PostStepDefs {

    @Given("the request body contains userId:{int} title:{string} and completed:{string}")
    public void the_request_body_contains_userId_title_and_completed(int userId, String title, String completed) {
        MainApi.createToDo(userId,title,Boolean.parseBoolean(completed));

    }

    @When("the user sends a post request to {string} end point for a new user")
    public void the_user_sends_a_post_request_to_end_point_for_a_new_user(String endPoint) {
        MainApi.sendPostRequest(MainApi.getToDo(),endPoint);
        MainApi.verifyStatusAndContent(201,"application/json; charset=utf-8",MainApi.getResponse());
    }

    @Then("the response payload data should match with the request body")
    public void the_resonse_payload_data_should_match_with_the_request_body() {
        System.out.println("ToDo: " + MainApi.getToDo().toString());
        System.out.println("Response: " + MainApi.getResponse().body().asString());

        assertEquals("UserId does not match",MainApi.getToDo().getUserId(),(int)MainApi.getResponse().path("userId"));
        assertEquals("Title does not match",MainApi.getToDo().getTitle(),MainApi.getResponse().path("title"));
        assertEquals("Completed does not match",MainApi.getToDo().isCompleted(),MainApi.getResponse().path("completed"));

    }
}
