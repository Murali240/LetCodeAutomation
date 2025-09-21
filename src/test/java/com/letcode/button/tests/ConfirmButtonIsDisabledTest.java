package com.letcode.button.tests;

import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.ButtonPage;
import com.letcode.utilities.ExtentManager;

public class ConfirmButtonIsDisabledTest extends BaseTest {
	
	@Test
	public void checkDisabledButtonTest() {
		
	    ButtonPage buttonPage = new ButtonPage(driver);

	    buttonPage.clickWorkSpaceLink();
		buttonPage.clickOnClickButton();
		
	    boolean isEnabled = buttonPage.isDisabledButtonEnabled();
	    ExtentManager.getTest().info("Disabled button is enabled: <b>" + isEnabled+"</b>");

	    if (!isEnabled) {
	        ExtentManager.getTest().pass("Disabled button is correctly disabled");
	    } else {
	        ExtentManager.getTest().fail("Disabled button should not be enabled");
	    }
	
	}

	
}
