package com.letcode.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letcode.utilities.WaitUtils;

public class AlertPage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public AlertPage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    } 
    
    
    /* ---------------- Locators ---------------- */ 
    /** The "Dialog" button that navigates to the Alert section */
    @FindBy(xpath = "//a[normalize-space()='Dialog']")
    private WebElement dialogButton;

    /** The button that triggers a simple alert */
    @FindBy(id = "accept")
    private WebElement simpleAlertButton;
    
    /** The "Confirm Alert" button that triggers a confirm alert */
    @FindBy(id = "confirm")
    private WebElement confirmAlertButton;
    
    /** The "Prompt Alert" button that triggers a prompt alert */
    @FindBy(id = "prompt")
    private WebElement promptAlertButton;
    
    /** Element displaying entered name after prompt */
    @FindBy(xpath = "//p[@id='myName']")
    private WebElement enteredNameText;
    
    /** Button that triggers the modern SweetAlert */
    @FindBy(id = "modern")
    private WebElement modernAlertButton;

    /** The title text displayed in the modern SweetAlert popup */
    @FindBy(xpath = "//p[@class='title']")
    private WebElement modernAlertTitle;

    /** The close button to dismiss the modern SweetAlert popup */
    @FindBy(xpath = "//button[@aria-label='close']")
    private WebElement modernAlertCloseButton;
   
    
    
    
    /* ------------ Action Methods ------------- */
    /** Clicks on the "Dialog" button to open the alert section. */
    public void clickDialogButton() {
        dialogButton.click();
    }

    /** Clicks on the "Simple Alert" button, switches to the alert, and accepts it (clicks OK). */
    public void handleSimpleAlert() {
        simpleAlertButton.click();
        WaitUtils.waitForSeconds(driver, 1);
        driver.switchTo().alert().accept();
    }
    
    /** Clicks the "Confirm Alert" button, gets the alert text, and dismisses it (Cancel). */ 
    public String handleConfirmAlertAndDismiss() { 
        confirmAlertButton.click();
        Alert alert = driver.switchTo().alert();
        
        String alertText = alert.getText();
        WaitUtils.waitForSeconds(driver, 1);
        
        alert.dismiss();
       
        return alertText;
    }
    
    /** Clicks the Prompt Alert button, types the given name, accepts it, and returns the displayed text from the page. */
    public String handlePromptAlertAndGetText(String name) {
        promptAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(name);
        alert.accept();
        WaitUtils.waitForSeconds(driver, 1);
        
        return enteredNameText.getText();
    }
    
    /** Clicks the button to trigger the modern SweetAlert */
    public void clickModernAlertButton() {
        modernAlertButton.click();
    }

    /** Returns the text of the modern SweetAlert title */
    public String getAlertTitle() {
        return modernAlertTitle.getText();
    }

    /** Clicks the close button to dismiss the modern SweetAlert */
    public void closeAlert() {
        modernAlertCloseButton.click();
    }

    /** Checks if the modern SweetAlert is currently displayed */
    public boolean isAlertDisplayed() {
        try {
            return modernAlertTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }




}

    
    

