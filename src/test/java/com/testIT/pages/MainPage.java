package com.testIT.pages;

import com.testIT.utilities.BrowserUtils;
import com.testIT.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//a[.='All']")
    public WebElement allTabButton;

    @FindBy(xpath = "//a[.='Active']")
    public WebElement activeTabButton;

    @FindBy(xpath = "//a[.='Completed']")
    public WebElement completedTabButton;

    public void createTodoItem(String item){
        inputBox.click();
        inputBox.sendKeys(item + Keys.ENTER);
    }

    public void checkItemListed(String item){
        try {
            WebElement toDoItem = Driver.get().findElement(By.xpath("//li[.='" + item + "']"));
            Assert.assertTrue(toDoItem.isDisplayed());
        }catch (NoSuchElementException e){
            System.err.println("ITEM IS NOT DISPLAYED - NOT SUPPOSED TO" + e.getMessage());
        }
    }

    public void checkItemNotListed(String item){
        try {
            WebElement toDoItem = Driver.get().findElement(By.xpath("//li[.='" + item + "']"));
            Assert.assertFalse(toDoItem.isDisplayed());
        }catch (NoSuchElementException e){
            System.err.println("ITEM IS DISPLAYED - NOT SUPPOSED TO" + e.getMessage());
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

    public void markCompletedItem(String item){
            WebElement itemCheckBox = Driver.get().findElement(By.xpath("//li[.='" + item + "']//input[@class='toggle']"));
            JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
            executor.executeScript("arguments[0].click();", itemCheckBox);
    }

    public void editItem2(String oldContent, String newContent){
        WebElement editItem = Driver.get().findElement(By.xpath("//label[.='" + oldContent + "']"));
        JavascriptExecutor execute = (JavascriptExecutor) Driver.get();
        execute.executeScript("document.getElementsByClassName('edit')[0].setAttribute('value','DENEME')");
        Driver.get().navigate().refresh();

    }

    public void editItem(String oldContent, String newContent){
        WebElement edit = Driver.get().findElement(By.xpath("//label[.='" + oldContent + "']/../.."));
        BrowserUtils.waitFor(3);
        Actions actions = new Actions(Driver.get());
        actions.doubleClick(edit).click().sendKeys(newContent + Keys.ENTER).perform();
    }

    public void deleteItem(String itemToDelete){
        WebElement delete = Driver.get().findElement(By.xpath("//label[.='" + itemToDelete + "']/following-sibling::button"));
        JavascriptExecutor execute = (JavascriptExecutor) Driver.get();
        execute.executeScript("arguments[0].click()", delete);
    }



}
