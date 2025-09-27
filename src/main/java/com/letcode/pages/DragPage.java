package com.letcode.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragPage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public DragPage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    } 
    
    
    /* ---------------- Locators ---------------- */
    /** AUI - 1 link on the page */
    @FindBy(xpath = "//a[normalize-space()='AUI - 1']")
    private WebElement aui1Button;

    /** Sample box element to be dragged */
    @FindBy(xpath = "//div[@id='sample-box']")
    private WebElement dragSampleBox;
    
    
    
    /* ---------------- Actions ---------------- */
    /** Click on the AUI - 1 link */
    public void clickAUI1Button() {
        aui1Button.click();
    }
    
    /** Drag the sample box by given x and y offsets using simple JS */
    public void dragSampleBoxByJS(int xOffset, int yOffset) {
        String js = "arguments[0].style.transform = 'translate(" + xOffset + "px," + yOffset + "px)';";
        ((JavascriptExecutor) driver).executeScript(js, dragSampleBox);
    }

    /** Returns the WebElement of the sample box */
    public WebElement getDragSampleBox() {
        return dragSampleBox;
    }
    
    
    
}
