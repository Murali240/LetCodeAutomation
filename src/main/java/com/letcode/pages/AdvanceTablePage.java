package com.letcode.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvanceTablePage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public AdvanceTablePage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    } 
    
    
    /* ---------------- Locators ---------------- */
    /** Advance Table button */
    @FindBy(xpath = "//a[normalize-space()='Advance table']")
    private WebElement advanceTableButton;

    /** Search input box */
    @FindBy(id = "dt-search-0")
    private WebElement searchInputBox;

    /** Pagination info text */
    @FindBy(xpath = "//div[@id='advancedtable_info']")
    private WebElement pagination;

    /** Entries per page dropdown filter */
    @FindBy(id = "dt-length-0")
    private WebElement entriesPerPageFilter;
    
    /** Next arrow button for pagination */
    @FindBy(xpath = "//button[normalize-space()='»']")
    private WebElement nextArrowIcon;


    
    /* ---------------- Actions ---------------- */
    /** Click on Advance Table button */
    public void clickAdvanceTableButton() {
        advanceTableButton.click();
    }

    /** Enter text in search input box */
    public void enterSearchText(String text) {
        searchInputBox.sendKeys(text);
    }

    /** Get pagination info text */
    public String getPaginationText() {
        return pagination.getText();
    }
 
    /** Select an option from Entries per Page filter dropdown */
    public void selectEntriesPerPage(String value) {
        entriesPerPageFilter.click();
        org.openqa.selenium.support.ui.Select select = 
            new org.openqa.selenium.support.ui.Select(entriesPerPageFilter);
        select.selectByVisibleText(value);
    } 
    
    /** Click next arrow using JavaScriptExecutor */
    public void clickNextArrowUsingJS() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextArrowIcon);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextArrowIcon);
    }

    
}
