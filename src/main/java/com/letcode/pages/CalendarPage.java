package com.letcode.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public CalendarPage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    } 
    
    
    /* ---------------- Locators ---------------- */
    /** Date & Time button on the page */
    @FindBy(xpath = "//a[normalize-space()='Date & Time']")
    private WebElement dateAndTimeButton;

    /** Birthday input field where DOB is selected in dd-mm-yyyy format */
    @FindBy(id = "birthday")
    private WebElement birthdayInput;

    
    /* ---------------- Actions ---------------- */
    /** Clicks on the Date & Time button */
    public void clickDateAndTimeButton() {
        dateAndTimeButton.click();
    }

    /** Selects your Date of Birth, @param dob Date of Birth in dd-mm-yyyy format */  
    public void selectBirthday(String dob) {
        birthdayInput.sendKeys(dob);               // ❌ input field does not accept typing
    }

    
}
