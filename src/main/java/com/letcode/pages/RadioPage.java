package com.letcode.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioPage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public RadioPage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    }   
	
    
    /* ---------------- Locators ---------------- */
    /** Toggle button element */
    @FindBy(xpath = "//a[normalize-space()='Toggle']")
    private WebElement toggleButton;

    /** Yes radio button element */
    @FindBy(id = "yes")
    private WebElement yesRadioButton;

    /** No radio button element */
    @FindBy(id = "no")
    private WebElement noRadioButton;
    
    /** Confirm Yes radio button element */
    @FindBy(id = "one")
    private WebElement confirmYesButton;

    /** Confirm No radio button element */
    @FindBy(id = "two")
    private WebElement confirmNoButton;
    
    /** Foo radio button element */
    @FindBy(id = "foo")
    private WebElement fooRadioButton;

    /** Bar radio button element */
    @FindBy(id = "notfoo")
    private WebElement barRadioButton;
    
    /** Going (first) radio button */
    @FindBy(id = "going")
    private WebElement goingFirstRadioButton;

    /** Not Going (middle) radio button */
    @FindBy(id = "notG")
    private WebElement notGoingMiddleRadioButton;

    /** Maybe (last) radio button */
    @FindBy(id = "maybe")
    private WebElement maybeLastRadioButton;

    /** Remember Me checkbox label element */
    @FindBy(xpath = "//label[normalize-space()='Remember me']/input")
    private WebElement rememberMeCheckbox;
    
    /** iAgreeT&C checkbox element */
    @FindBy(xpath = "//div[7]//label[2]//input[1]")
    private WebElement iAgreeTCCheckbox;
    
    
    
    /* -------------- Action Methods -------------- */
    /** Clicks on the Toggle button */
    public void clickToggleButton() {
        toggleButton.click();
    }
    
    /** Selects a radio button based on choice ("yes" or "no") */
    public void selectRadioButton(String choice) {
        if (choice.equalsIgnoreCase("yes")) {
            yesRadioButton.click();
        } else if (choice.equalsIgnoreCase("no")) {
            noRadioButton.click();
        } else {
            throw new IllegalArgumentException("Invalid choice: " + choice + ". Use 'yes' or 'no'.");
        }
    }
    
    /** Check if Yes radio button is selected */
    public boolean isYesSelected() {
        return yesRadioButton.isSelected();
    }

    /** Check if No radio button is selected */
    public boolean isNoSelected() {
        return noRadioButton.isSelected();
    }
    
    /** Selects confirm radio button based on choice ("yes" or "no") */
    public void selectConfirmRadioButton(String choice) {
        if (choice.equalsIgnoreCase("yes")) {
            confirmYesButton.click();
        } else if (choice.equalsIgnoreCase("no")) {
            confirmNoButton.click();
        } else {
            throw new IllegalArgumentException("Invalid choice: " + choice + ". Use 'yes' or 'no'.");
        }
    }

    /** Check if Confirm Yes radio button is selected */
    public boolean isConfirmYesSelected() {
        return confirmYesButton.isSelected();
    }

    /** Check if Confirm No radio button is selected */
    public boolean isConfirmNoSelected() {
        return confirmNoButton.isSelected();
    }
    
    /** Returns the label of the selected radio button ("foo" or "bar") */
    public String getSelectedRadioButton() {
        if (fooRadioButton.isSelected()) {
            return "foo";
        } else if (barRadioButton.isSelected()) {
            return "bar";
        }
        return "none";      // nothing selected
    }
    
    /** Checks which radio button is disabled : "going", "notG", "maybe" or "none". */
    public String getDisabledRadioButton() {
        if (!goingFirstRadioButton.isEnabled()) {
            return "going";
        } else if (!notGoingMiddleRadioButton.isEnabled()) {
            return "notG";
        } else if (!maybeLastRadioButton.isEnabled()) {
            return "maybe";
        } else {
            return "none";      // all enabled
        }
    }
    
    /** Checks if the Remember Me checkbox is selected, @return true if selected, false otherwise */
    public boolean isRememberMeSelected() {
        return rememberMeCheckbox.isSelected();
    }
    
    /** Accept Terms & Conditions, click the checkbox */
    public void clickIAgreeTC() {
        iAgreeTCCheckbox.click();
    }
    
    /**Checks whether the iAgreeT&C checkbox is selected, @return true if the checkbox is selected, false otherwise */
    public boolean isIAgreeTCSelected() {
        return iAgreeTCCheckbox.isSelected();
    }
    
    
}
