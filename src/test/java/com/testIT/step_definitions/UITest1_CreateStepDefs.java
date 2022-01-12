package com.testIT.step_definitions;

import com.testIT.pages.MainPage;
import com.testIT.utilities.ConfigurationReader;
import com.testIT.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class UITest1_CreateStepDefs {

    MainPage main = new MainPage();

    @Given("the user is on the todos page")
    public void the_user_is_on_the_todos_page() {
        Driver.get().get(ConfigurationReader.get("urL"));
    }

    @When("the user creates a new {string}")
    public void the_user_creates_a_new(String todoItem) {
        main.createTodoItem(todoItem);
    }

    @Then("the {string} should be listed below")
    public void the_should_be_listed_below(String todoItem) {
        main.checkItemListed(todoItem);
    }

    @Then("todo-count should be seen as the number of active toDos")
    public void todo_count_should_be_seen_as_the_number_of_active_toDos() {
        int actives = Integer.parseInt(main.activeItemNum.getText());
        System.out.println("actives = " + actives);
        Assert.assertEquals(main.countActiveItems(),actives);
    }


}
