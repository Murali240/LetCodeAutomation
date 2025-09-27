package com.letcode.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropPage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public DropPage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    } 
    
    
    /* ---------------- Locators ---------------- */
    /** AUI - 2 Button */
    @FindBy(xpath = "//a[normalize-space()='AUI - 2']")
    private WebElement aui2Button;

    /** Source box for drag-and-drop action */
    @FindBy(id = "draggable")
    private WebElement sourceBox;

    /** Target box for drag-and-drop action */
    @FindBy(id = "droppable")
    private WebElement targetBox;    
    
    
    /* ---------------- Actions ---------------- */
    /** Clicks on AUI-2 button to navigate to Drag & Drop section */
    public void clickAUI2Button() {
        aui2Button.click();
    }

    /** Performs drag-and-drop action from sourceBox to targetBox */
    public void dragAndDrop() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceBox, targetBox).perform();
    }
	
    /** Gets the text of the target box for validation */
    public String getTargetBoxText() {
        return targetBox.getText();
    }

}
