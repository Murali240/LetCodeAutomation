package com.letcode.window.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.WindowPage;
import com.letcode.utilities.ExtentManager;


public class WindowHandlingTest extends BaseTest {
	
	@Test (groups = {"regression"})
    public void verifyChildWindowTitleAndClose() {
		
		WindowPage windowPage = new WindowPage(driver);
		ExtentTest test = ExtentManager.getTest();
    	
		windowPage.clickWorkSpaceLink();
        windowPage.clickTabsButton();
        test.pass("Clicked on Tabs button");
        test.info("Page heading after click on Tabs button: <b>" + windowPage.getPageHeading()+"</b>");


        String childTitle = windowPage.openHomePageAndGetTitle();
        test.pass("Clicking on <b>Open Home Page</b> button and switching to child window");

        test.info("Captured child window title: <b>" + childTitle+"</b>");

        try {
            Assert.assertEquals(childTitle, "Workspace | LetCode with Koushik", "Child window title did not match!");
            test.pass("✅ Validated child window title successfully: <b>" + childTitle+"</b>");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;                                               // rethrow so test fails in TestNG
        }
    
	}

	
}
