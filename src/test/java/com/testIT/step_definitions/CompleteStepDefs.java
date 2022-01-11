package com.testIT.step_definitions;

import com.testIT.pages.MainPage;
import com.testIT.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class CompleteStepDefs {

    MainPage main = new MainPage();

    @When("the user clicks the circle near the {string}")
    public void the_user_clicks_the_circle_near_the(String todoItem) {
        main.createTodoItem(todoItem);
        main.checkCompletedItem(todoItem);

    }

    @Then("the {string} should be marked as completed")
    public void the_should_be_marked_as_completed(String todoItem) {
        WebElement completedItem = Driver.get().findElement(By.xpath("//li[.='" + todoItem + "']"));
        System.out.println("completedItem.getAttribute(\"class\") = " + completedItem.getAttribute("class"));
    }

    @Then("the user should see the {string} in Completed list")
    public void the_user_should_see_the_in_Completed_list(String string) {
        System.out.println("@WIP");
    }
}
