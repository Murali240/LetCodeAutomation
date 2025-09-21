package com.letcode.select.tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.SelectPage;
import com.letcode.utilities.ExtentManager;

public class SelectFruitByVisibleTextTest extends BaseTest {
	
	    @Test
	    public void selectAppleTest() {
		 
	    	SelectPage selectPage = new SelectPage(driver);
	    	
	    	selectPage.clickWorkSpaceLink();
	    	selectPage.clickDropdownButton();

	        /** Select "Apple" from the fruits dropdown */
	        selectPage.selectFruitByVisibleText("Apple");
	    
	        /** Assertion: verify selected fruit */
	        Select select = new Select(selectPage.getSelectFruitDropdown());
	        String selectedFruit = select.getFirstSelectedOption().getText();
	        Assert.assertEquals(selectedFruit, "Apple", "Selected fruit is not Apple");
	        ExtentManager.getTest().pass("Assertion Passed: <b>"+selectedFruit+"</b> is selected successfully");
	    
	    }


}