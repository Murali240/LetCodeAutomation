package com.letcode.advancetable.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.AdvanceTablePage;
import com.letcode.utilities.ExtentManager;
import com.letcode.utilities.WaitUtils;

public class PaginationTest extends BaseTest {
	
	    @Test (groups = {"regression"})
	    public void verifyDynamicPagination() {
		 
	        AdvanceTablePage advanceTablePage = new AdvanceTablePage(driver);
	        ExtentTest test = ExtentManager.getTest();

	        advanceTablePage.clickWorkSpaceLink();
	        advanceTablePage.clickAdvanceTableButton();
	        test.pass("Clicked on Advance Table button");
	        test.info("Page heading after Advance Table button: <b>" + advanceTablePage.getPageHeading() + "</b>");

	        /**Select entries per page */
	        String entries = "10"; // try "5", "10", "25"
	        advanceTablePage.selectEntriesPerPage(entries);
	        test.pass("Selected entries per page: " + entries);

	        /** Click next arrow using JavaScriptExecutor */
	        advanceTablePage.clickNextArrowUsingJS();
	        test.pass("Clicked on next arrow using JSExecutor");
	        WaitUtils.waitForSeconds(driver, 1);

	        /** Calculate expected last page number */
	        int expectedPages;
	        switch (entries) {
	            case "5":
	                expectedPages = 10;
	                break;
	            case "10":
	                expectedPages = 5;
	                break;
	            case "25":
	                expectedPages = 2;
	                break;
	            default:
	                throw new IllegalArgumentException("Unexpected entries value: " + entries);
	        }

	        /** Validate last page number */
	        WebElement lastPageButton = driver.findElement(By.xpath("//button[normalize-space()='" + expectedPages + "']"));
	        String actualPageText = lastPageButton.getText();
	        Assert.assertEquals(actualPageText, String.valueOf(expectedPages), 
	                "Pagination last page number mismatch");
	        test.pass("Validated last page number. <b>Expected: " + expectedPages + ", Found: " + actualPageText+"</b>");
	    
	    }
	
	    
}
