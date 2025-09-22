package com.letcode.alert.tests;

import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.AlertPage;
import com.letcode.utilities.ExtentManager;


public class AcceptSimpleAlertTest extends BaseTest {

	    @Test
	    public void verifyAcceptSimpleAlert() {
	    	
	    	AlertPage alertPage = new AlertPage(driver);
	    	
	    	alertPage.clickWorkSpaceLink();
	    	alertPage.clickDialogButton();
	    	ExtentManager.getTest().pass("Clicked on 'Dialog' button.");
	    	
	        /** Navigate to the Alert section */
	        ExtentManager.getTest().info("Page heading after click on Dialog: <b>" + alertPage.getPageHeading()+"</b>");

	        /** Handle and accept the simple alert */
	        alertPage.handleSimpleAlert();
	        ExtentManager.getTest().pass("✅ Simple Alert handled successfully (Accepted OK button)");
	        
	    }


}
