package com.letcode.radio.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.RadioPage;
import com.letcode.utilities.ExtentManager;

public class PreSelectedRadioButtonTest extends BaseTest {
	
	@Test
    public void verifyBydefaultSelectedRadioButton() {
		
		RadioPage radioPage = new RadioPage(driver);
        ExtentTest test = ExtentManager.getTest();
        
        radioPage.clickWorkSpaceLink();
		radioPage.clickToggleButton();
		test.info("Page heading after click Toggle button: <b>" + radioPage.getPageHeading()+"</b>");

        /** Get currently selected radio button */
        String selected = radioPage.getSelectedRadioButton();
        test.info("Checked which radio button is selected");
        test.pass("Currently selected radio button: " + selected);

        /** Validate that 'bar' is selected by default */
        Assert.assertEquals(selected, "bar", "By default, 'bar' radio button should be selected");

	}	


}
