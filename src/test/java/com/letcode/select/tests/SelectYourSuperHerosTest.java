package com.letcode.select.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.SelectPage;
import com.letcode.utilities.ExtentManager;

public class SelectYourSuperHerosTest extends BaseTest {
	
	@Test (groups = {"regression"})
	public void selectMultipleSuperHerosTest() {
		
	    SelectPage selectPage = new SelectPage(driver);
	    
	    selectPage.clickWorkSpaceLink();
    	selectPage.clickDropdownButton();

    	/** Verify if multi-select is allowed */
    	boolean isMultiple = selectPage.isSuperHerosMultiple();
    	Assert.assertTrue(isMultiple, "Superheros dropdown is not multi-select");

    	/** Log result in ExtentReports if assertion passes */
    	if (isMultiple) {
    	    ExtentManager.getTest().pass("Assertion Passed: <b>Superheros dropdown allows multiple selection</b>");
    	}

	    /** Select multiple options */
	    selectPage.selectMultipleSuperHeros("Batman", "Superman", "Spider-Man");

	    /** Verification: print all selected options */
	    Select select = new Select(selectPage.getSuperHerosDropdown());
	    for (WebElement option : select.getAllSelectedOptions()) {
	    ExtentManager.getTest().pass("Selected: <b>" + option.getText()+"</b>");
	    }
	
	}


}
