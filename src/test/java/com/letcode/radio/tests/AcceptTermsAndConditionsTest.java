package com.letcode.radio.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.RadioPage;
import com.letcode.utilities.ExtentManager;
import com.letcode.utilities.WaitUtils;

public class AcceptTermsAndConditionsTest extends BaseTest {
	
	    @Test
	    public void VerifyIAgreeCheckboxClick() {
	    	
	    	RadioPage radioPage = new RadioPage(driver);
		    ExtentTest test = ExtentManager.getTest();
		    
		    radioPage.clickWorkSpaceLink();
			radioPage.clickToggleButton();
			test.info("Page heading after click Toggle button: <b>" + radioPage.getPageHeading()+"</b>");
			
			
	        /** Click the i Agree T&C checkbox */
			radioPage.clickIAgreeTC();
			test.info("Clicked on i Agree T&C checkbox");

			/** Validate after Accepted Terms & Conditions */
			Assert.assertTrue(radioPage.isIAgreeTCSelected(), "iAgreeT&C checkbox should be selected");
			test.pass("i Agree T&C checkbox is selected successfully");
			WaitUtils.waitForSeconds(driver, 1);
	    
	    }


}
