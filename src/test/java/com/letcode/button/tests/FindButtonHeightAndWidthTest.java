package com.letcode.button.tests;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.ButtonPage;
import com.letcode.utilities.ExtentManager;

public class FindButtonHeightAndWidthTest extends BaseTest {
	
	    @Test (groups = {"regression"})
	    public void getButtonSizeTest() {
	    	
	    	ButtonPage buttonPage = new ButtonPage(driver);

			buttonPage.clickWorkSpaceLink();
			buttonPage.clickOnClickButton();
	    	
	        Dimension size = buttonPage.getButtonSize();
	        int width = size.getWidth();
	        int height = size.getHeight();

	        ExtentManager.getTest().info("Button width: <b>" + width + "</b> px");
	        ExtentManager.getTest().info("Button height: <b>" + height + "</b> px");
	        ExtentManager.getTest().pass("Fetched button size successfully");
	    
	    }

	    
}
