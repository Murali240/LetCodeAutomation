package com.letcode.select.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.SelectPage;
import com.letcode.utilities.ExtentManager;

public class CountrySelectionFromDropdownTest extends BaseTest {
	
	    @Test (groups = {"sanity"})
	    public void selectCountryAndVerifySelection() {
	    	
            SelectPage selectPage = new SelectPage(driver);
	 	    
	 	    selectPage.clickWorkSpaceLink();
	     	selectPage.clickDropdownButton();
	     	
	        /** Step 1: Select India using value */
	        selectPage.selectCountryByValue("India");
 
	        /** Step 2: Get and print selected country */
	        String selectedCountry = selectPage.getSelectedCountry();
	        ExtentManager.getTest().pass("Selected Country: <b>" + selectedCountry+"</b>");

	        /** Step 3: Assertion */
	        Assert.assertEquals(selectedCountry, "India", "Country selected is not India");
	    
	    }
	
	    
}
