package com.testIT.step_definitions;

import com.testIT.pages.MainPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class UITest5_ClearCompletedStepDefs {

    MainPage main = new MainPage();

    @When("the user clicks on the Clear completed button")
    public void the_user_clicks_on_the_Clear_completed_button() {
        if (main.countCompletedItems()>0){
            main.clearCompletedButton.click();
        }
    }

    @Then("the completed buttons are cleared from the list")
    public void the_completed_buttons_are_cleared_from_the_list() {
        for (WebElement item : main.getItems()) {
            Assert.assertFalse("ALL THE COMPLETED ITEMS ARE NOT CLEARED",item.getAttribute("class").equalsIgnoreCase("completed"));
            break;
        }
    }
}
