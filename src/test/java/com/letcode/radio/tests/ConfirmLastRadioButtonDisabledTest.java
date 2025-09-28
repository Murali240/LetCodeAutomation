package com.letcode.radio.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.RadioPage;
import com.letcode.utilities.ExtentManager;

public class ConfirmLastRadioButtonDisabledTest extends BaseTest {
	
	@Test (groups = {"regression"})
	public void verifyDisabledRadioButton() {
		
		RadioPage radioPage = new RadioPage(driver);
        ExtentTest test = ExtentManager.getTest();
        
        radioPage.clickWorkSpaceLink();
		radioPage.clickToggleButton();
		test.info("Page heading after click Toggle button: <b>" + radioPage.getPageHeading()+"</b>");
		
	    String disabled = radioPage.getDisabledRadioButton();
	    test.info("Disabled radio button: <b>" + disabled+"</b>");

	    /** Validate maybe button only disbaled or not */
	    if (disabled.equals("maybe")) {
	        test.pass("✅ Last radio button ('maybe') is correctly disabled");
	    } else {
	        test.fail("❌ Expected last radio button ('maybe') to be disabled, but found: " + disabled);
	    }    
	
	}

	
}
