package com.letcode.button.tests;

import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.ButtonPage;
import com.letcode.utilities.ExtentManager;

public class ClickButtonTest extends BaseTest {
	
	@Test
    public void verifyButtonClicksAndNavigation() {
		
		ButtonPage buttonPage = new ButtonPage(driver);

		buttonPage.clickWorkSpaceLink();
	    
        /** Click on "Click" button */
        buttonPage.clickOnClickButton();
        ExtentManager.getTest().pass("Clicked on 'Click' button.");
        ExtentManager.getTest().info("Page heading after click: <b>" + buttonPage.getPageHeading()+"</b>");

        /** Click "Goto Home" button */
        buttonPage.clickOnGotoHomeButton();
        String homeUrl = driver.getCurrentUrl();
        ExtentManager.getTest().info("Clicked on 'Goto Home' button. Current URL: " + homeUrl);

        /** Navigate back */
        driver.navigate().back();
        String backUrl = driver.getCurrentUrl();
        ExtentManager.getTest().info("After navigating back. Current URL: " + backUrl);

        /** Navigate forward */
        driver.navigate().forward();
        String forwardUrl = driver.getCurrentUrl();
        ExtentManager.getTest().info("After navigating forward. Current URL: " + forwardUrl);

        /** Refresh the page */
        driver.navigate().refresh();
        String refreshUrl = driver.getCurrentUrl();
        ExtentManager.getTest().info("After refresh. Current URL: " + refreshUrl);

        /** Optional: Log dynamic heading after refresh */
        String headingAfterRefresh = buttonPage.getPageHeading();
        ExtentManager.getTest().info("Page heading after refresh: " + headingAfterRefresh);

        /** Optional: Check LetCode logo is visible */
        boolean isLogoVisible = buttonPage.isLetCodeLogoDisplayed();
        ExtentManager.getTest().info("LetCode logo visible: " + isLogoVisible);
        if(isLogoVisible) {
            ExtentManager.getTest().pass("LetCode logo is displayed on the page");
        } else {
            ExtentManager.getTest().fail("LetCode logo is NOT displayed on the page");
        }
    
	}

	
}
