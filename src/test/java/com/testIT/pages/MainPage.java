package com.testIT.pages;

import com.testIT.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(className = "new-todo")
    public WebElement inputBox;

    @FindBy(xpath = "//span//strong")
    public WebElement activeItemNum;

    @FindBy(xpath = "//a[.='All']")
    public WebElement allTabButton;

    @FindBy(xpath = "//a[.='Active']")
    public WebElement activeTabButton;

    @FindBy(xpath = "//a[.='Completed']")
    public WebElement completedTabButton;

    @FindBy(css = ".clear-completed")
    public WebElement clearCompletedButton;

    public void createTodoItem(String item){
        inputBox.click();
        inputBox.sendKeys(item + Keys.ENTER);
    }

    /**
     * Verifies if the item requested is listed
     *
     * @param item
     */
    public void checkItemListed(String item){
        try {
            WebElement toDoItem = Driver.get().findElement(By.xpath("//li[.='" + item + "']"));
            Assert.assertTrue(toDoItem.isDisplayed());
        }catch (NoSuchElementException e){
            System.err.println("ITEM IS NOT DISPLAYED - NOT SUPPOSED TO" + e.getMessage());
        }
    }

    /**
     * Verifies if the item requested is NOT listed
     *
     * @param item
     */
    public void checkItemNotListed(String item){
        try {
            WebElement toDoItem = Driver.get().findElement(By.xpath("//li[.='" + item + "']"));
            Assert.assertFalse(toDoItem.isDisplayed());
        }catch (NoSuchElementException e){
            System.err.println("ITEM IS DISPLAYED - NOT SUPPOSED TO" + e.getMessage());
        }
    }

    /**
     * Gets all of the listed items and returns as List of WebElement
     *
     * @return itemList
     */
    public List<WebElement> getItems(){
        List<WebElement> itemList = Driver.get().findElements(By.cssSelector("ul.todo-list>li"));
        return itemList;
    }

    /**
     * Counts all of the ACTIVE items and returns the total number as int
     *
     * @return #ActiveItems
     */
    public int countActiveItems(){
        int i=0;
        for (WebElement element : getItems()) {
            if(!element.getAttribute("class").equalsIgnoreCase("completed")){
                i++;
            }
        }
        return i;
    }

    /**
     * Counts all of the COMPLETED items and returns the total number as int
     *
     * @return #CompletedItems
     */
    public int countCompletedItems(){
        int i=0;
        for (WebElement element : getItems()) {
            if(element.getAttribute("class").equalsIgnoreCase("completed")){
                i++;
            }
        }
        return i;
    }

    /**
     * Counts all of the UNCOMPLETED items and returns the total number as int
     *
     * @return #UncompletedItems
     */
    public void markCompletedItem(String item){
        WebElement itemCheckBox = Driver.get().findElement(By.xpath("//li[.='" + item + "']//input[@class='toggle']"));
        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("arguments[0].click();", itemCheckBox);
    }

    /**
     * Edits the item by;
     * Deleting the old content of the requested item and writing the new content
     *
     * @param oldContent
     * @param newContent
     */
    public void editItem(String oldContent, String newContent){
        WebElement edit = Driver.get().findElement(By.xpath("//label[.='" + oldContent + "']/../.."));
        Actions actions = new Actions(Driver.get());
        actions.doubleClick(edit).click().sendKeys(newContent + Keys.ENTER).perform();
    }

    /**
     * Deletes the requested item
     *
     * @param itemToDelete
     */
    public void deleteItem(String itemToDelete){
        WebElement delete = Driver.get().findElement(By.xpath("//label[.='" + itemToDelete + "']/following-sibling::button"));
        JavascriptExecutor execute = (JavascriptExecutor) Driver.get();
        execute.executeScript("arguments[0].click()", delete);
    }



}
