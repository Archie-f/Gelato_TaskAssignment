package com.testIT.step_definitions;

import com.testIT.pages.MainApi;
import io.cucumber.java.en.*;


public class ApiTest3_PutStepDefs {

    int userID;

    @Given("the userId of the response payload is kept")
    public void the_userId_of_the_response_payload_is_kept() {
        userID = MainApi.getResponse().body().path("userId");
        System.out.println("UserID = " + userID);
    }

    @Given("the request body contains userId: keptId title:{string} and completed:{string}")
    public void the_request_body_contains_userId_title_and_completed(String title, String completed) {
        System.out.println("Downside UserID = " + userID);
        System.out.println("Title = " + title);
        System.out.println("Completed = " + Boolean.parseBoolean(completed));

        MainApi.createToDo(userID,title,Boolean.parseBoolean(completed));
        System.out.println("TODO = " + MainApi.getToDo().toString());
    }

    @When("the user sends a put request to {string} end point with the userId")
    public void the_user_sends_a_put_request_to_end_point_with_the_userId(String endPoint) {
        String finalEndPoint = endPoint + userID;
        MainApi.sendPutRequest(MainApi.getToDo(),finalEndPoint);
        MainApi.verifyStatusAndContent(200,"application/json; charset=utf-8",MainApi.getResponse());
    }

}
