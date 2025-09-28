package com.letcode.advancetable.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.AdvanceTablePage;
import com.letcode.utilities.ExtentManager;

public class AdvanceTableSearchTest extends BaseTest {
	
	@Test (groups = {"regression"})
    public void verifyAdvanceTableSearchAndFilter() {
		
		AdvanceTablePage advanceTablePage = new AdvanceTablePage(driver);
        ExtentTest test = ExtentManager.getTest();

        advanceTablePage.clickWorkSpaceLink();
        advanceTablePage.clickAdvanceTableButton();
        test.pass("Clicked on Advance Table button");
        test.info("Page heading after Advance Table button: <b>" + advanceTablePage.getPageHeading() + "</b>");

        /** Enter search text */
        String searchText = "Oxford";
        advanceTablePage.enterSearchText(searchText);
        test.pass("Entered search text: " + searchText);

        /** Get pagination info text */
        String paginationText = advanceTablePage.getPaginationText();
        test.pass("Pagination info text: <b>" + paginationText+"</b>");
        Assert.assertNotNull(paginationText, "Pagination text should not be null");
   
	}

}
