package com.testIT.step_definitions;

import com.testIT.pages.MainPage;
import com.testIT.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;

public class UITest4_DeleteStepDefs {

    @When("the user clicks on the x button on the right side of the {string}")
    public void the_user_clicks_on_the_x_button_on_the_right_side_of_the(String itemToDelete) {
        if(!itemToDelete.isEmpty()) {
            new MainPage().deleteItem(itemToDelete);
        }
    }

    @Then("the {string} should disappear from the list")
    public void the_should_disappear_from_the_list(String deletedItem) {
        new MainPage().checkItemNotListed(deletedItem);
    }
}
