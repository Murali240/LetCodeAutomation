package com.letcode.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public FramePage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    }   	
    
    
    /* ---------------- Locators ---------------- */  
    /** Inner HTML button */
    @FindBy(xpath = "//a[normalize-space()='Inner HTML']")
    private WebElement innerHTMLButton;
    
    /** Enter Details heading */
    @FindBy(xpath = "//h1[normalize-space()='Enter Details']")
    private WebElement enterDetailsHeading;
    
    /** First Name input field */
    @FindBy(xpath = "//input[@placeholder='Enter name']")
    private WebElement enterFirstNameField; 

    /** Last Name input field */
    @FindBy(xpath = "//input[@placeholder='Enter email' and @name='lname']")
    private WebElement enterLastNameField;

    /** Email input field */
    @FindBy(xpath = "//input[@placeholder='Enter email' and @name='email']")
    private WebElement enterEmailField;
    
    
    /* ---------------- Frame Handling Concepts ---------------- */
    /** Switch to frame by index (Target Locator + switchTo) */
    public void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    /** Switch to frame by name or id (Target Locator + switchTo) */
    public void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    /** Switch to frame by WebElement (Target Locator + switchTo) */
    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    /** Switch to parent frame */
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    /** Switch to default content */
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }


    /** ---------------- Page Actions ---------------- */

    /** Click on Inner HTML button */
    public void clickInnerHTMLButton() {
        innerHTMLButton.click();
    }
    
    /** Verify if Enter Details heading is displayed, @return true if displayed, otherwise false */
    public boolean isEnterDetailsHeadingDisplayed() {
        return enterDetailsHeading.isDisplayed();
    }

    /** Enter First Name */
    public void enterFirstName(String firstName) {
        enterFirstNameField.sendKeys(firstName);
    }

    /** Enter Last Name */
    public void enterLastName(String lastName) {
        enterLastNameField.sendKeys(lastName);
    }

    /** Enter Email - Overloading concept (by direct String input) */
    public void enterEmail(String email) {
        enterEmailField.sendKeys(email);
    }

    /** Enter Email - Overloading concept (accept WebElement + String) */
    public void enterEmail(WebElement element, String email) {
        element.sendKeys(email);
    }
    
    public void pageRefresh() {
        driver.navigate().refresh();
    }
    
    


}
