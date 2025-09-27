package com.letcode.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultiSelectPage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public MultiSelectPage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    } 
    
    
    /* ---------------- Locators ---------------- */
    /** Click on WorkSpace link - assumed common */
    @FindBy(xpath = "//a[normalize-space()='WorkSpace']")
    private WebElement workSpaceLink;

    /** Click on AUI-4 button */
    @FindBy(xpath = "//a[normalize-space()='AUI - 4']")
    private WebElement aui4Button;

    /** Multi-select items */
    @FindBy(xpath = "//div[normalize-space()='Playwright']")
    private WebElement playWrite;

    @FindBy(xpath = "//div[normalize-space()='Kurimurai']")
    private WebElement kuriMurai;

    @FindBy(xpath = "//div[normalize-space()='Selenium']")
    private WebElement selenium;

    @FindBy(xpath = "//div[normalize-space()='Protractor']")
    private WebElement protractor;

    @FindBy(xpath = "//div[normalize-space()='Appium']")
    private WebElement appium;

    @FindBy(xpath = "//div[normalize-space()='TestNg']")
    private WebElement testNG;

    @FindBy(xpath = "//div[normalize-space()='Postman']")
    private WebElement postman;

    @FindBy(xpath = "//div[normalize-space()='Cypress']")
    private WebElement cypress;

    @FindBy(xpath = "//div[normalize-space()='Webdriver.io']")
    private WebElement webdriverIO;

    @FindBy(xpath = "//div[normalize-space()='LetCode']")
    private WebElement letCode;
    
    
    /* ---------------- Actions ---------------- */
    /** Click on AUI-4 button */
    public void clickAUI4Button() {
        aui4Button.click();
    }

    /** Select all items using CTRL + Mouse Actions */
    public void selectAllItems() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)  // Hold CTRL key
               .click(playWrite)
               .click(kuriMurai)
               .click(selenium)
               .click(protractor)
               .click(appium)
               .click(testNG)
               .click(postman)
               .click(cypress)
               .click(webdriverIO)
               .click(letCode)
               .keyUp(Keys.CONTROL)  // Release CTRL key
               .build()
               .perform();
    }
    
    /** Returns true if all items are selected, false otherwise 
     * Assumes selected items have 'selected' CSS class */
    public boolean areAllItemsSelected() {
        return playWrite.getAttribute("class").contains("selected") &&
               kuriMurai.getAttribute("class").contains("selected") &&
               selenium.getAttribute("class").contains("selected") &&
               protractor.getAttribute("class").contains("selected") &&
               appium.getAttribute("class").contains("selected") &&
               testNG.getAttribute("class").contains("selected") &&
               postman.getAttribute("class").contains("selected") &&
               cypress.getAttribute("class").contains("selected") &&
               webdriverIO.getAttribute("class").contains("selected") &&
               letCode.getAttribute("class").contains("selected");
    }

    
}
