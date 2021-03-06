package com.testIT.step_definitions;

import com.testIT.pages.MainPage;
import com.testIT.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class UITest2_CompleteStepDefs {

    MainPage main = new MainPage();

    @When("the user clicks the circle near the {string} among the {string} list")
    public void the_user_clicks_the_circle_near_the_among_the_list(String completedItem, String toDoItem) {
        main.createTodoItem(toDoItem);
        if (!completedItem.isEmpty())
            main.markCompletedItem(completedItem);

    }

    @Then("the {string} should be marked as completed")
    public void the_should_be_marked_as_completed(String item) {
        if (!item.isEmpty()){
            WebElement completedItem = Driver.get().findElement(By.xpath("//ul[@class='todo-list']/li[.='" + item + "']"));
            Assert.assertEquals("completed",completedItem.getAttribute("class"));
        }
    }

    @Then("the user should see the {string} in Completed list")
    public void the_user_should_see_the_in_Completed_list(String item) {
        if (!item.isEmpty()) {
            main.completedTabButton.click();
            main.checkItemListed(item);
        }
        main.allTabButton.click();
    }
}
