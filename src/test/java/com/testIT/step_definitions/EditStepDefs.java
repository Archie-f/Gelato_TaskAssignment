package com.testIT.step_definitions;

import com.testIT.pages.MainPage;
import com.testIT.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EditStepDefs {

    MainPage main = new MainPage();

    @Given("there's an {string} list with some are {string}")
    public void there_s_an_list_with_some_are(String existingItem, String completedItem) {
        main.createTodoItem(existingItem);
        if (!completedItem.isEmpty()){
            main.markCompletedItem(completedItem);
        }
    }

    @When("the user double clicks any {string} and edits {string} with the {string}")
    public void the_user_double_clicks_any_and_edits_with_the(String itemToEdit, String oldContent, String newContent) {
        if(!itemToEdit.isEmpty()){
            WebElement editItem = Driver.get().findElement(By.xpath("//li[.='" + itemToEdit + "']"));
            main.editItem(oldContent,newContent);
        }
    }

    @Then("the old {string} should be replaced with the {string}")
    public void the_old_should_be_replaced_with_the(String oldContent, String newContent) {
        if(!oldContent.isEmpty()){
            main.checkItemNotListed(oldContent);
            main.checkItemListed(newContent);
        }
    }
}
