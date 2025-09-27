package com.letcode.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.letcode.utilities.WaitUtils;

public class WaitsPage extends BasePage {

		/* -------------- Constructor -------------- */
	    public WaitsPage(WebDriver driver) {
	        super(driver);                              // Call BasePage constructor
	        PageFactory.initElements(driver, this);     // Initialize InputPage elements
	    } 
	    
	    
	    /* ---------------- Locators ---------------- */
	    /** Timeout Button that triggers the alert */
	    @FindBy(xpath = "//a[normalize-space()='Timeout']")
	    private WebElement timeoutButton;

	    /** Simple Alert Button to accept the alert */
	    @FindBy(id = "accept")
	    private WebElement simpleAlertButton;
	  
	    
	    
	    /* ---------------- Actions ---------------- */
	    /** Clicks on the Timeout button */
	    public void clickTimeoutButton() {
	        timeoutButton.click();
	    }

	    /** Clicks on the Simple Alert button and accepts the alert using ExpectedConditions */
	    public void clickSimpleAlertAndAccept() {
	        simpleAlertButton.click();

	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        WaitUtils.waitForSeconds(driver, 1);
	        alert.accept();
	    }


}
