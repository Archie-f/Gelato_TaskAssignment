package com.testIT.step_definitions;

import com.testIT.pages.MainApi;
import com.testIT.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

public class ApiTest1_GetStepDefs {

    Response response;
    String baseURI = ConfigurationReader.get("urI");

    @Given("the baseURI is set")
    public void the_baseURI_is_set() {
        RestAssured.baseURI = baseURI;
    }

    @When("the user sends a get request to {string} end point")
    public void the_user_sends_a_get_request_to_end_point(String endPoint) {
        response = MainApi.sendGetRequest(endPoint);
        MainApi.verifyStatusAndContent(200,"application/json; charset=utf-8", this.response);
    }

    @Then("there should be total {int} todos in the response payload")
    public void there_should_be_total_todos_in_the_response_payload(int todoNum) {
        List<Map<String,Object>> allTodosList = response.body().as(List.class);
        assertEquals(todoNum,allTodosList.size());
        System.out.println("allTodosList.size() = " + allTodosList.size());
    }

    @Then("the id of the response payload matches with the request id {int}")
    public void the_id_of_the_response_payload_matches_with_the_request_id(int requestId) {
        assertEquals(requestId,(int)response.body().path("id"));
        System.out.println("Response ID = " + response.body().path("id"));
    }

    @Then("the number of uncompleted todos of user should match with the expected number {int}")
    public void the_number_of_uncompleted_todos_of_user_should_match_with_the_expected_number(int uncompletedExp) {
        List<Map<String,Object>> userTodos = response.body().as(List.class);
        int uncompletedAct = 0;
        for (Map<String, Object> eachTodo : userTodos) {
            boolean completed = (boolean) eachTodo.get("completed");
            if (!completed){
                uncompletedAct++;
            }
        }
        assertEquals(uncompletedExp,uncompletedAct);
        System.out.println("Number of Uncompleted Todos = " + uncompletedAct);
    }

}
