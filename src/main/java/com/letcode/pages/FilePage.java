package com.letcode.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilePage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public FilePage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    } 
    
    
    /* --------------- Locators ---------------- */
    /** File Management button on the left panel */
    @FindBy(xpath = "//a[normalize-space()='File management']")
    private WebElement fileManagementButton;

    /** Choose File button to open the file upload dialog */
    @FindBy(xpath = "//input[@type='file']")
    private WebElement chooseFileButton;

    /** Selected file type label, Used to verify which file has been selected */
    @FindBy(xpath = "//p[@class='label ng-star-inserted']")
    private WebElement selectedFileType;
    
    /** Download Excel button */
    @FindBy(id = "xls")
    private WebElement downloadExcelButton;

    /** Download PDF button */
    @FindBy(id = "pdf")
    private WebElement downloadPDFButton;

    /** Download Text button */
    @FindBy(id = "txt")
    private WebElement downloadTextButton;
    
    
    /* ---------------- Actions ----------------- */
    /** Method to click on File Management button */
    public void clickFileManagementButton() {
        fileManagementButton.click();
    }

    /** Method to upload a file using the Choose File button */
    public void uploadFile(String filePath) { 
        chooseFileButton.sendKeys(filePath);         // sendKeys works for input type="file"
    }

    /** Method to get the selected file type text */
    public String getSelectedFileType() {
        return selectedFileType.getText();
    }
    
    /** Clicks the Excel download button */
    public void clickDownloadExcel() {
        downloadExcelButton.click();
    }
    
    /** Clicks the PDF download button */
    public void clickDownloadPDF() {
        downloadPDFButton.click();
    }

    /** Clicks the Text download button */
    public void clickDownloadText() {
        downloadTextButton.click();
    }   	
    
    
}
