package com.letcode.radio.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.RadioPage;
import com.letcode.utilities.ExtentManager;
import com.letcode.utilities.WaitUtils;

public class YesNoRadioButtonTest extends BaseTest {
	
	@Test
	public void verifySelectRadioButtonByChoice() {
	   
		RadioPage radioPage = new RadioPage(driver);
		ExtentTest test = ExtentManager.getTest(); 

		radioPage.clickWorkSpaceLink();

	    radioPage.clickToggleButton();
	    test.info("Page heading after click Toggle button: <b>" + radioPage.getPageHeading()+"</b>");
	    

	    radioPage.selectRadioButton("yes");
	    if (radioPage.isYesSelected()) {
	    	test.pass("✅ Yes radio button selected successfully");
	    } else {
	    	test.fail("❌ Failed to select Yes radio button");
	    }
	    
	    WaitUtils.waitForSeconds(driver, 1);

	    radioPage.selectRadioButton("no");
	    if (radioPage.isNoSelected()) {
	    	test.pass("✅ No radio button selected successfully");
	    } else {
	    	test.fail("❌ Failed to select No radio button");
	    }
	    WaitUtils.waitForSeconds(driver, 1);

	}

	
}
