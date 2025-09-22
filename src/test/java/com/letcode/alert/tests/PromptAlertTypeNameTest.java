package com.letcode.alert.tests;

import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.AlertPage;
import com.letcode.utilities.ExtentManager;

public class PromptAlertTypeNameTest extends BaseTest {
	
	@Test
	public void verifyTypeNameAndAcceptPromptAlert() {
		
	    AlertPage alertPage = new AlertPage(driver);

	    alertPage.clickWorkSpaceLink(); 
	    alertPage.clickDialogButton();
	    ExtentManager.getTest().pass("Clicked on 'Dialog' button.");

	    String name = "Gopi Krishna";
	    String displayedText = alertPage.handlePromptAlertAndGetText(name);
	    
	    ExtentManager.getTest().info("Entered name: <b>" + name + "</b>");
	    ExtentManager.getTest().info("Displayed text on page: <b>" + displayedText + "</b>");

	    /** Validate entered name matches displayed text */
	    if (displayedText.contains(name)) {
	        ExtentManager.getTest().pass("✅ Prompt Alert text validated successfully.");
	    } else {
	        ExtentManager.getTest().fail("❌ Prompt Alert text validation failed.");
	    }
	
	}

	
}
	
	
	    
