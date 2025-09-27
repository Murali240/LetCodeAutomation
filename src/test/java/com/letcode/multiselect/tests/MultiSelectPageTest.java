package com.letcode.multiselect.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.MultiSelectPage;
import com.letcode.utilities.ExtentManager;
import com.letcode.utilities.WaitUtils;

public class MultiSelectPageTest extends BaseTest {
	
	@Test
    public void verifySelectAllItems() {
		
        MultiSelectPage multiSelectPage = new MultiSelectPage(driver);
        ExtentTest test = ExtentManager.getTest();
       
        multiSelectPage.clickWorkSpaceLink();       
        multiSelectPage.clickAUI4Button();
        test.pass("Clicked on AUI-4 button");
        test.info("Page heading after click on AUI-4 button: <b>" + multiSelectPage.getPageHeading() + "</b>");

        /** Select all items using CTRL + Actions */
        multiSelectPage.selectAllItems();
        test.pass("Selected all items using CTRL + mouse actions successfully");
        WaitUtils.waitForSeconds(driver, 1);

        /** Validate all items are selected */
        boolean allSelected = multiSelectPage.areAllItemsSelected();
        if (allSelected) {
            test.pass("All items are selected successfully.");
        } else {
            test.fail("Some items were not selected.");
            throw new AssertionError("Multi-select failed: not all items selected.");
        }
    
	}

	
}
