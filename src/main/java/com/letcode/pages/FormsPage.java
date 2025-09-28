package com.letcode.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FormsPage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public FormsPage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    } 
    
    
    /* ---------------- Locators ---------------- */
    /** 'All in One' button to open the form */
    @FindBy(xpath = "//a[normalize-space()='All in One']")
    private WebElement allInOneButton;

    /** First name input field */
    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    /** Last name input field */
    @FindBy(id = "lasttname")
    private WebElement lastNameInput;

    /** Email input field */
    @FindBy(id = "email")
    private WebElement emailInput;

    /** Country code dropdown */
    @FindBy(xpath = "//div[2]//div[2]//div[1]//div[1]//div[1]//select[1]")
    private WebElement countryCodeDropdown;

    /** Phone number input field */
    @FindBy(id = "Phno")
    private WebElement phoneNumberInput;

    /** Address Line 1 input field */
    @FindBy(id = "Addl1")
    private WebElement addressLine1;

    /** Address Line 2 input field */
    @FindBy(id = "Addl2")
    private WebElement addressLine2;

    /** State input field */
    @FindBy(id = "state")
    private WebElement stateInput;

    /** Pincode input field */
    @FindBy(id = "postalcode")
    private WebElement pincodeInput;

    /** Country dropdown */
    @FindBy(xpath = "//div[5]//div[2]//div[1]//div[1]//div[1]//select[1]")
    private WebElement countryDropdown;

    /** DOB input field (opens datepicker) */
    @FindBy(id = "Date")
    private WebElement dobButton;

    /** Gender radio buttons */
    @FindBy(id = "male")
    private WebElement genderMaleRadioButton;

    @FindBy(id = "female")
    private WebElement genderFemaleRadioButton;

    @FindBy(id = "trans")
    private WebElement transgenderRadioButton;

    /** 'I Agree' checkbox */
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement iAgreeCheckbox;

    /** Submit button */
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;
    
    
    
    /* ---------------- Actions ---------------- */
    public void clickAllInOneButton() {
        allInOneButton.click();
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void selectCountryCode(String countryCode) {
        Select select = new Select(countryCodeDropdown);
        select.selectByVisibleText(countryCode);
    }

    public void enterPhoneNumber(String phone) {
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phone);
    }

    public void enterAddressLine1(String address1) {
        addressLine1.clear();
        addressLine1.sendKeys(address1);
    }

    public void enterAddressLine2(String address2) {
        addressLine2.clear();
        addressLine2.sendKeys(address2);
    }

    public void enterState(String state) {
        stateInput.clear();
        stateInput.sendKeys(state);
    }

    public void enterPincode(String pincode) {
        pincodeInput.clear();
        pincodeInput.sendKeys(pincode);
    }

    public void selectCountry(String country) {
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
    }
    
    /** Selects your Date of Birth, @param dob Date of Birth in dd-mm-yyyy format */  
    public void selectBirthday(String dob) {
    	dobButton.sendKeys(dob);               // ❌ input field does not accept typing
    }
    
    /** Selects gender (only one), @param gender "male", "female", or "trans" */
    public void selectGender(String gender) {
        switch (gender.toLowerCase()) {
            case "male":
                genderMaleRadioButton.click();
                break;
            case "female":
                genderFemaleRadioButton.click();
                break;
            case "trans":
                transgenderRadioButton.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid gender: " + gender);
        }
    }

    /** Click Terms & Conditions agree checkbox */
    public void clickIAgreeCheckbox() {
        if (!iAgreeCheckbox.isSelected()) {
            iAgreeCheckbox.click();
        }
    }

    /** Click Submit button */
    public void clickSubmitButton() {
        submitButton.click();
    }

    
}
