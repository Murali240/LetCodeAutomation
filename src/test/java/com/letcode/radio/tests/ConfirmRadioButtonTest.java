package com.letcode.radio.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.RadioPage;
import com.letcode.utilities.ExtentManager;

public class ConfirmRadioButtonTest extends BaseTest {
	
	/** Verify selecting Confirm Yes and No radio buttons */
	@Test
	public void testSelectConfirmRadioButtons() {
		
		RadioPage radioPage = new RadioPage(driver);
		ExtentTest test = ExtentManager.getTest();       // Get current test instance

		radioPage.clickWorkSpaceLink();
		radioPage.clickToggleButton();
		test.info("Page heading after click Toggle button: <b>" + radioPage.getPageHeading()+"</b>");

	
	 // Step 1: Select Confirm Yes
	    radioPage.selectConfirmRadioButton("yes");
	    if (radioPage.isConfirmYesSelected() && !radioPage.isConfirmNoSelected()) {
	        test.pass("✅ Confirm Yes selected successfully and Confirm No is not selected.");
	    } else {
	        test.fail("❌ Failed: Confirm Yes should be selected and Confirm No should NOT be selected.");
	        Assert.fail("Confirm Yes test failed.");
	    }

	 // Step 2: Select Confirm No
	    radioPage.selectConfirmRadioButton("no");
	    if (radioPage.isConfirmNoSelected() && !radioPage.isConfirmYesSelected()) {
	        test.pass("✅ Confirm No selected successfully and Confirm Yes is not selected.");
	    } else {
	        test.fail("❌ Failed: Confirm No should be selected and Confirm Yes should NOT be selected.");
	        Assert.fail("Confirm No test failed.");
	    }

	    test.info("Test completed: Confirm radio buttons behave as mutually exclusive.");
	}


}
