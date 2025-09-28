package com.letcode.table.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.TablePage;
import com.letcode.utilities.ExtentManager;

public class TotalPriceMatchesCalculatedSumTest extends BaseTest {
	
	    @Test (groups = {"sanity"})
	    public void verifyTotalPriceMatchesCalculatedSum() {
	    	
	    	TablePage tablePage = new TablePage(driver);
	        ExtentTest test = ExtentManager.getTest();
	        
	        tablePage.clickWorkSpaceLink();
	        tablePage.clickSimpleTableButton();
	        test.pass("Clicked Simple Table button");
	        test.info("Page heading after click on Simple Table button: <b>" + tablePage.getPageHeading() + "</b>");
	    	
	        int calculatedTotal = tablePage.calculateAllItemsPrice();
	        int displayedTotal = tablePage.getDisplayedTotalPrice();

	        test.info("Calculated Total: " + calculatedTotal);
	        test.info("Displayed Total: " + displayedTotal);

	        Assert.assertEquals(calculatedTotal, displayedTotal, "Total price mismatch!");
	        test.pass("✅ Total price matches! Calculated: <b>" + calculatedTotal + ", Displayed: " + displayedTotal+"</b>");
	           
	    }	    

	    
}
