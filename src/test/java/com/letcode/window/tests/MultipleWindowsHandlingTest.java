package com.letcode.window.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.WindowPage;
import com.letcode.utilities.ExtentManager;

public class MultipleWindowsHandlingTest extends BaseTest {
	
	WindowPage windowPage;
	ExtentTest test;
	
	 @Test (priority = 0)
	    public void verifyChildWindowTitleUsingList() {
		 
		    windowPage = new WindowPage(driver);
			test = ExtentManager.getTest();
	    	
			windowPage.clickWorkSpaceLink();
	        windowPage.clickTabsButton();
	        test.pass("Clicked on Tabs button");
	        test.info("Page heading after click on Tabs button: <b>" + windowPage.getPageHeading()+"</b>");

	        test.info("Clicking on Multiple Windows button and switching using List");
	        String childTitle = windowPage.getChildWindowTitle_UsingList();
	        test.info("Captured child window title: <b>" + childTitle+"</b>");

	        /** Validation */
	        Assert.assertEquals(childTitle, "Alert | LetCode with Koushik", "Child window title did not match expected");

	        test.pass("✅ Validated child window title successfully using List: <b>" + childTitle+"</b>");
	    }

	    @Test (priority = 1)
	    public void verifyChildWindowTitleUsingLinkedHashSetLoop() {
	    	
	    	windowPage = new WindowPage(driver);
			test = ExtentManager.getTest();
		    	
		    windowPage.clickWorkSpaceLink();
		    windowPage.clickTabsButton();
		    test.pass("Clicking on Tabs button");
	    
	        test.info("Clicking on Multiple Windows button and switching using LinkedHashSet + Loop");
	        String childTitle = windowPage.getChildWindowTitle_UsingLinkedHashSetLoop();
	        test.info("Captured child window title: <b>" + childTitle+"</b>");

	        Assert.assertNotNull(childTitle, "Alert | LetCode with Koushik");
	        test.pass("✅ Validated child window title successfully using LinkedHashSet + Loop: <b>" + childTitle+"</b>");
	    }

	    @Test (priority = 2)
	    public void verifyChildWindowTitleUsingIterator() {
	    	
	    	windowPage = new WindowPage(driver);
			test = ExtentManager.getTest();
		    	
		    windowPage.clickWorkSpaceLink();
		    windowPage.clickTabsButton();
		    test.pass("Clicking on Tabs button");

	        test.info("Clicking on Multiple Windows button and switching using Iterator");
	        String childTitle = windowPage.getChildWindowTitle_UsingIterator();
	        test.info("Captured child window title: <b>" + childTitle+"</b>");

	        Assert.assertNotNull(childTitle, "Alert | LetCode with Koushik");
	        test.pass("✅ Validated child window title successfully using Iterator: <b>" + childTitle+"</b>");
	    }


}
