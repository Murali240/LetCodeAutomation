package com.letcode.alert.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.AlertPage;
import com.letcode.utilities.ExtentManager;

public class SweetAlertTest extends BaseTest {
    
    @Test
    public void validateModernSweetAlert() {
    	
        AlertPage alertPage = new AlertPage(driver);
        
        alertPage.clickWorkSpaceLink();
        alertPage.clickDialogButton();
        ExtentManager.getTest().pass("Clicked on 'Dialog' button.");

        /** Log page heading */
        String heading = alertPage.getPageHeading();
        ExtentManager.getTest().info("Page heading after click on Dialog: <b>" + heading + "</b>");

        /** Step 1: Click Modern Alert button */
        alertPage.clickModernAlertButton();
        ExtentManager.getTest().info("Clicked on 'Modern Alert' button to trigger SweetAlert.");

        /** Step 2: Verify the alert is displayed */
        boolean isDisplayed = alertPage.isAlertDisplayed();
        Assert.assertTrue(isDisplayed, "SweetAlert is NOT displayed!");
        ExtentManager.getTest().pass("Verified that SweetAlert is displayed.");

        /** Step 3: Validate the alert title text */
        String alertText = alertPage.getAlertTitle();
        String expectedText = "Modern Alert - Some people address me as sweet alert as well";
        Assert.assertEquals(alertText.trim().replaceAll("\\s+", " "), expectedText);
        ExtentManager.getTest().pass("Alert title is correct: <b>" + alertText + "</b>");

        /** Step 4: Close the alert */
        alertPage.closeAlert();
        ExtentManager.getTest().info("Closed the SweetAlert.");

        /** Step 5: Verify the alert is closed */
        Assert.assertFalse(alertPage.isAlertDisplayed(), "SweetAlert did not close!");
        ExtentManager.getTest().pass("Verified that SweetAlert is closed successfully.");
    
    }


}
