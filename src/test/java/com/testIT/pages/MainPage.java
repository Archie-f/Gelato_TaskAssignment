package com.testIT.pages;

import com.testIT.utilities.BrowserUtils;
import com.testIT.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(className = "new-todo")
    public WebElement inputBox;

    @FindBy(xpath = "//span//strong")
    public WebElement activeItemNum;

    public WebElement toDoItem;



    public void createTodoItem(String item){
        inputBox.click();
        inputBox.sendKeys(item + Keys.ENTER);
    }

    public void checkItemListed(String item){
        try {
            toDoItem = Driver.get().findElement(By.xpath("//li[.='" + item + "']"));
            Assert.assertTrue(toDoItem.isDisplayed());
        }catch (NoSuchElementException e){
            System.err.println("ITEM IS NOT DISPLAYED" + e.getMessage());
        }
    }

    public int countActiveItems(){
        List<WebElement> itemList = Driver.get().findElements(By.cssSelector("ul.todo-list>li"));
        int i=0;
        for (WebElement element : itemList) {
            if(!element.getAttribute("class").equalsIgnoreCase("completed")){
                i++;
            }
        }
        return i;
    }

    public void checkCompletedItem(String item){
        WebElement itemCheckBox = Driver.get().findElement(By.xpath("//li[.='" + item + "']//input[@class='toggle']"));
        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("arguments[0].click();", itemCheckBox);
    }




}
