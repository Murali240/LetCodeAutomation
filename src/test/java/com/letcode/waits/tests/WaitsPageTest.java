package com.letcode.waits.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.WaitsPage;
import com.letcode.utilities.ExtentManager;

public class WaitsPageTest extends BaseTest {
	
	    @Test (groups = {"regression"})
	    public void testClickTimeoutAndSimpleAlert() {
		 
		    WaitsPage waitsPage = new WaitsPage(driver);
	        ExtentTest test = ExtentManager.getTest();
	        
	        waitsPage.clickWorkSpaceLink();
	        waitsPage.clickTimeoutButton();
	        test.pass("Clicked Timeout button");
	        test.info("Page heading after click on Timeout button: <b>" + waitsPage.getPageHeading() + "</b>");

	        /** Click the Simple Alert button and accept the alert */
	        waitsPage.clickSimpleAlertAndAccept();
	        test.pass("Clicked Simple Alert button and accepted the alert");

	        // Optional: you can add assertions if page changes after alert
	        test.info("Alert accepted successfully");
	    
	    }

	    
}
