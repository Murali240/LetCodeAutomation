package com.letcode.button.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.ButtonPage;
import com.letcode.utilities.ExtentManager;

public class ClickAndHoldButtonTest extends BaseTest {
	
	@Test
	public void clickAndHoldButtonTest() {
	    
	    ButtonPage buttonPage = new ButtonPage(driver);
	    
	    buttonPage.clickWorkSpaceLink();
	    buttonPage.clickOnClickButton();

	    buttonPage.clickAndHoldButton(1);    // hold for 1 seconds

	    String message = buttonPage.getButtonHoldMessage();
	    ExtentManager.getTest().info("Message after button hold: <b>" + message + "</b>");

	    Assert.assertEquals(message, "Button has been long pressed");
	    ExtentManager.getTest().pass("Click and Hold functionality validated successfully");
	
	}

	
}
