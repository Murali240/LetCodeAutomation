package com.letcode.elements.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.ElementsPage;
import com.letcode.utilities.ExtentManager;

public class ElementsPageTest extends BaseTest {
	
	@Test
    public void validateElementsPage() {
		
		ElementsPage elementsPage = new ElementsPage(driver);
		ExtentTest test = ExtentManager.getTest();
    	
		elementsPage.clickWorkSpaceLink();
		elementsPage.clickFindElementsButton();
        test.pass("Clicked on Find Elements button");
        test.info("Page heading after click on Find Elements button: <b>" + elementsPage.getPageHeading()+"</b>");
           
        /** Enter Git username */
        elementsPage.enterGitUserName("Gopi krishna");
        test.info("Entered Git username");

          
    }

	
}
