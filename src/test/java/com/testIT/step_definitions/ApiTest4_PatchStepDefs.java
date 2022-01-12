package com.testIT.step_definitions;

import com.testIT.pages.MainApi;
import io.cucumber.java.en.*;

public class ApiTest4_PatchStepDefs {

    @When("the user sends a patch request to {string} end point with the userId {int}")
    public void the_user_sends_a_patch_request_to_end_point_with_the_userId(String endPoint, int userId) {
        String finalEndPoint = endPoint + userId;
        String patch = "{\n" +
                "    \"completed\": false\n" +
                "}";
        MainApi.sendPatchRequest(patch,finalEndPoint);
        int uID = MainApi.getResponse().path("userId");
        String title = MainApi.getResponse().path("title");
        MainApi.createToDo(uID,title,false);

    }

}
