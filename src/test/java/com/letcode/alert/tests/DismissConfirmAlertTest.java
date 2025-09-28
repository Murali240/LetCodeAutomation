package com.letcode.alert.tests;

import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.AlertPage;
import com.letcode.utilities.ExtentManager;

public class DismissConfirmAlertTest extends BaseTest {
	
	    @Test (groups = {"smoke"})
	    public void verifyDismissConfirmAlert() {
	    	
            AlertPage alertPage = new AlertPage(driver);
	    	
	    	alertPage.clickWorkSpaceLink();
	    	alertPage.clickDialogButton();
	    	ExtentManager.getTest().pass("Clicked on 'Dialog' button.");
	    	
	        /** Navigate to the Alert section */
	        ExtentManager.getTest().info("Page heading after click on Dialog: <b>" + alertPage.getPageHeading()+"</b>");

	        /** Handle Confirm Alert, get text, and dismiss */
	        String alertText = alertPage.handleConfirmAlertAndDismiss();
	        System.out.println("Alert Text: " + alertText);

	        ExtentManager.getTest().info("Alert text before dismiss: <b>" + alertText + "</b>");
	        ExtentManager.getTest().pass("✅ Confirm Alert dismissed successfully (Clicked Cancel)");
	    
	    }

	    
}
