package com.letcode.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonPage extends BasePage {

    /* -------------- Constructor -------------- */
    public ButtonPage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    }   	
    
    
    /* ---------------- Locators ---------------- */   
    /** Locator for "Click" button */
    @FindBy(xpath = "//a[normalize-space()='Click']")
    private WebElement clickButton;

    /** Locator for "Goto Home" button */
    @FindBy(id = "home")
    private WebElement gotoHomeButton;
    
    /** Button whose X & Y coordinates need to be fetched */
    @FindBy(id = "position")
    private WebElement findLocationButton;
    
    /** Button to get CSS color */
    @FindBy(id = "color")
    private WebElement whatIsMyColorButton;
    
    /** Button to get size (width & height) */
    @FindBy(id = "property")
    private WebElement howTallAndFatButton;
    
    /** Disabled button to check if it is enabled */
    @FindBy(id = "isDisabled")
    private WebElement disabledButton;
    
    /** Click and Hold Button */
    @FindBy(xpath = "//h2[normalize-space()='Button Hold!']")
    private WebElement buttonHold;
    
    /** Message displayed after click and hold */
    @FindBy(xpath = "//h2[normalize-space()='Button has been long pressed']")
    private WebElement afterButtonHoldMessage;
    
    
    /* ------------ Action Methods ------------- */
    /** Method to click the "Click" button */
    public void clickOnClickButton() {
        clickButton.click();
    }

    /** Method to click the "Goto Home" button */
    public void clickOnGotoHomeButton() {
        gotoHomeButton.click();
    }
    
    /** Returns the X and Y coordinates of the button as a Point object.
     * @return Point containing X and Y coordinates */
    public Point getButtonCoordinates() {
        return findLocationButton.getLocation();
    }
    
    /** Button to get CSS color */
    public String getButtonCssValue(String cssProperty) {
        return whatIsMyColorButton.getCssValue(cssProperty);
    }
    
    /** Button to get size (width & height) */
    public Dimension getButtonSize() {
        return howTallAndFatButton.getSize();
    }
    
    /** Returns true if the 'Disabled' button is enabled, false if disabled */
    public boolean isDisabledButtonEnabled() {
        return disabledButton.isEnabled();
    }
    
    /** Clicks and holds the 'Button Hold!' button for specified seconds */
    public void clickAndHoldButton(int seconds) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(buttonHold)
               .pause(java.time.Duration.ofSeconds(seconds))
               .release()
               .perform();
    }
    
    /** Returns the message displayed after holding the button */
    public String getButtonHoldMessage() {
        return afterButtonHoldMessage.getText().trim();
    }


}
