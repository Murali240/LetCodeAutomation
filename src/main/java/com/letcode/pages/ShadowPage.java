package com.letcode.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShadowPage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public ShadowPage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    } 
    
    
    /* --------------- Locators ---------------- */
    /** DOM Button - Click to navigate or interact with DOM section */
    @FindBy(xpath = "//a[normalize-space()='DOM']")
    private WebElement domButton;

    /** First Name Input Box - Enter the first name */
    @FindBy(css = "#fname")
    private WebElement firstNameInputBox;

    /** Last Name Input Box - Enter the last name */
    @FindBy(css = "#lname")
    private WebElement lastNameInputBox;

    /** Email Input Box - Enter the email address */
    @FindBy(css = "#email")
    private WebElement emailInputBox;
    
    
    
    /* ---------------- Actions ----------------- */
    /** Clicks on the DOM button */
    public void clickDomButton() {
        domButton.click();
    }

    /** Enters the first name */
    public void enterFirstName(String firstName) {
        firstNameInputBox.sendKeys(firstName);
    }

    /** Enters the last name */
    public void enterLastName(String lastName) {
        lastNameInputBox.sendKeys(lastName);
    }

    /** Enters the email address */ 
    public void enterEmail(String email) {
        emailInputBox.sendKeys(email);
    }
    
    
}
