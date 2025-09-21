package com.letcode.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Base class for common page elements and actions */
public class BasePage {
	
	/** Make driver visible to methods in this class and child classes */
	protected WebDriver driver;
	
	/* -------------- Constructor -------------- */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

 
    /* --------------- Common Locators --------------- */
    /** Navigation link for Work-Space in the top menu */
    @FindBy(xpath = "//a[normalize-space()='Work-Space']")
    private WebElement workSpaceLink;
    
    /** LetCode logo in the header */
    @FindBy(xpath = "//img[@alt='letcode']")
    private WebElement letCodeLogo;
    
    

    /* -------------- Common Action Methods --------------- */
    /** Clicks on the Work-Space link in the navigation bar */
    public void clickWorkSpaceLink() {
        workSpaceLink.click();
    }  

    /** Returns the current page heading text */
    public String getPageHeading() {
        /** Use the driver that is initialized in the constructor */
        WebElement heading = driver.findElement(By.xpath("//h1[contains(normalize-space(), '')]"));
        return heading.getText().trim();
    }
    
    /** Returns true if LetCode logo is displayed on the page */
    public boolean isLetCodeLogoDisplayed() {
        return letCodeLogo.isDisplayed();
    }


}