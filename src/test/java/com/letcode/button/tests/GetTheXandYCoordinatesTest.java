package com.letcode.button.tests;

import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.ButtonPage;
import com.letcode.utilities.ExtentManager;

public class GetTheXandYCoordinatesTest extends BaseTest {
	
	    @Test (groups = {"regression"})
	    public void verifyGetButtonCoordinatesTest() {
	    	
	    	ButtonPage buttonPage = new ButtonPage(driver);

			buttonPage.clickWorkSpaceLink();
			buttonPage.clickOnClickButton();
			
	        Point coordinates = buttonPage.getButtonCoordinates();
	        int x = coordinates.getX();
	        int y = coordinates.getY();

	        ExtentManager.getTest().info("Button X coordinate: <b>" + x+"</b>");
	        ExtentManager.getTest().info("Button Y coordinate: <b>" + y+"</b>");
	        ExtentManager.getTest().pass("Fetched X & Y coordinates successfully");
	    
	    }


}
