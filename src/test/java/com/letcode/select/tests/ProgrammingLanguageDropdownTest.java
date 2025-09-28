package com.letcode.select.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.SelectPage;
import com.letcode.utilities.ExtentManager;

public class ProgrammingLanguageDropdownTest extends BaseTest {
	
	    @Test (groups = {"sanity"})
	    public void selectLastProgrammingLanguageTest() {
		 
	    	SelectPage selectPage = new SelectPage(driver);
	 	    
	 	    selectPage.clickWorkSpaceLink();
	     	selectPage.clickDropdownButton();

	        /** Step 1: Select last programming language */
	        selectPage.selectLastProgrammingLanguage();
	        ExtentManager.getTest().info("Selected last programming language from dropdown");

	        /** Step 2: Print all programming languages */
	        ExtentManager.getTest().info("Printing all available programming languages:");
	        Select select = new Select(selectPage.getProgrammingLanguageDropdown());
	        List<WebElement> options = select.getOptions();

	        for (WebElement option : options) {
	          	ExtentManager.getTest().info("Option: <b>" + option.getText()+"</b");
	        }

	        /** Step 3: Verify last programming language was selected */
	        String lastOption = options.get(options.size() - 1).getText();
	        String selectedOption = select.getFirstSelectedOption().getText();

	        Assert.assertEquals(selectedOption, lastOption, "Last programming language was not selected");
	        ExtentManager.getTest().pass("Assertion Passed: <b>" + selectedOption + "</b> is the last programming language selected");
	    
	    }


}