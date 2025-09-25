package com.letcode.radio.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.RadioPage;
import com.letcode.utilities.ExtentManager;

public class RememberMeCheckboxTest extends BaseTest {
	
	@Test
	public void testRememberMeCheckboxSelection() {
		
		RadioPage radioPage = new RadioPage(driver);
	    ExtentTest test = ExtentManager.getTest();
	    
	    radioPage.clickWorkSpaceLink();
		radioPage.clickToggleButton();
		test.info("Page heading after click Toggle button: <b>" + radioPage.getPageHeading()+"</b>");

		boolean selected = radioPage.isRememberMeSelected();
		   if (selected) {
			   test.pass("✅ Remember Me checkbox is selected by default");
		   } else {
		       test.fail("ℹ Remember Me checkbox is NOT selected");
		   }
		
	}

	
}	
	