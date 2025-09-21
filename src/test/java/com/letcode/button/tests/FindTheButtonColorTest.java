package com.letcode.button.tests;

import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.ButtonPage;
import com.letcode.utilities.ExtentManager;

public class FindTheButtonColorTest extends BaseTest {
	
	    @Test
	    public void findButtonColorTest() {
	    	
	    	ButtonPage buttonPage = new ButtonPage(driver);

			buttonPage.clickWorkSpaceLink();
			buttonPage.clickOnClickButton();
			
	        /** Get background color of the button */
	        String backgroundColor = buttonPage.getButtonCssValue("background-color");
	        ExtentManager.getTest().info("Background color of button: <b>" + backgroundColor+"</b>");

	        /** Get text color of the button */
	        String textColor = buttonPage.getButtonCssValue("color");
	        ExtentManager.getTest().info("Text color of button: <b>" + textColor+"</b>");

	        /** Mark as passed */
	        ExtentManager.getTest().pass("Fetched button CSS colors successfully");
	    }


}
