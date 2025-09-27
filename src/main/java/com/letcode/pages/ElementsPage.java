package com.letcode.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public ElementsPage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    } 
    
    
    /* ---------------- Locators ---------------- */
    /** Find Elements button */
    @FindBy(xpath = "//a[normalize-space()='Find Elements']")
    private WebElement findElementsButton;

    /** Enter your git user name input field */
    @FindBy(xpath = "//input[@placeholder='Enter your git user name eg., ortonikc']")
    private WebElement enterYourGitUserNameField;
    
    
   
    /* ---------------- Actions ---------------- */
    /** Click on the "Find Elements" button */
    public void clickFindElementsButton() {
        findElementsButton.click();
    }

    /** Enter a git user name into the input field */
    public void enterGitUserName(String gitUserName) {
        enterYourGitUserNameField.sendKeys(gitUserName);
    }

    
}
