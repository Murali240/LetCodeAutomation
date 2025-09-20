package com.letcode.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputPage {
	
	private WebDriver driver;
	
	/* ---------------- Constructor ---------------- */

    public InputPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	

    /* ---------------- Locators ---------------- */

    /** Navigation link for Work-Space in the top menu */
    @FindBy(xpath = "//a[normalize-space()='Work-Space']")
    private WebElement workSpaceLink;

    /** Edit button inside the Work-Space section */
    @FindBy(xpath = "//a[normalize-space()='Edit']")
    private WebElement editButton;

    /** Page heading for Input page */
    @FindBy(xpath = "//h1[normalize-space()='Input']")
    private WebElement inputHeading;

    /** Input field for entering full name */
    @FindBy(id = "fullName")
    private WebElement fullNameInput;
    
    /** Input field where text will be appended */
    @FindBy(id = "join")
    private WebElement joinInput;

    /** Next input field to validate focus after TAB */
    @FindBy(id = "getMe")
    private WebElement getMeInput;
    
    /** Input field from which text will be cleared */
    @FindBy(id = "clearMe")
    private WebElement clearTheText;

    /** Input field which should be disabled (not editable) */
    @FindBy(id = "noEdit")
    private WebElement noEditInput;
    
    /** Input field that should be read-only */
    @FindBy(id = "dontwrite")
    private WebElement confirmTextIsReadOnly;


    

    /* ---------------- Action Methods ---------------- */

    /** Clicks on the Work-Space link in the navigation bar */
    public void clickWorkSpaceLink() {
        workSpaceLink.click();
    }

    /** Clicks on the Edit button in the Work-Space section */
    public void clickEditButton() {
        editButton.click();
    }

    /** Checks if the Input page heading is displayed */
    public boolean isInputHeadingDisplayed() {
        return inputHeading.isDisplayed();
    }

    /** Enters the given name into the Full Name input field */
    public void enterFullName(String name) {
        fullNameInput.sendKeys(name);
    }
    
    /** Appends text to Join input field and presses TAB */
    public String appendTextAndPressTab(String text) {
        joinInput.sendKeys(text);                            // Append text
        joinInput.sendKeys(Keys.TAB);                        // Press TAB to move focus
        
     // Return the current full text of the input field
        return joinInput.getAttribute("value");
    }

    /** Returns the currently focused element */
    public WebElement getFocusedElement() {
        return driver.switchTo().activeElement();
    }

    /** Returns the WebElement of the next input field for validation */
    public WebElement getNextInputField() {
        return getMeInput;
    }
    
    /** Returns the text currently present in the inside input box - what is inside the text box */
    public String getTextFromInsideInputBox() {
        return getMeInput.getAttribute("value");
    }

    /** Returns the current text inside the Clear the input field */
    public String getTextFromClearTheText() {
        return clearTheText.getAttribute("value");
    }

    /** Clears the text inside the Clear the input field */
    public void clearTextFromClearTheText() {
        clearTheText.clear();
    }
    
    /** Checks whether the NoEdit input field is enabled or disabled */
    public boolean isNoEditInputEnabled() {
        return noEditInput.isEnabled();
    }
    
    /** Returns true if the DontWrite input field is read-only */
    public boolean isConfirmTextIsReadOnly() {
     // "readonly" attribute is present if field is read-only
        String readonlyAttr = confirmTextIsReadOnly.getAttribute("readonly");
        return readonlyAttr != null;                                   // returns true if readonly attribute exists
    }

    /** Attempts to enter text into the DontWrite input field */
    public void tryToEnterTextInConfirmTextIsReadOnlyInputField(String text) {
    	confirmTextIsReadOnly.sendKeys(text);
    }

    /** Returns the current value inside the DontWrite input field */
    public String getTextFromConfirmTextIsReadOnlyInputField() {
        return confirmTextIsReadOnly.getAttribute("value");
    }

    
}
