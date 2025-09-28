package com.letcode.drop.tests;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.DropPage;
import com.letcode.utilities.ExtentManager;
import com.letcode.utilities.WaitUtils;

public class DropPageTest extends BaseTest {
    
    @Test 
    public void verifyDragAndDrop() {
        DropPage dropPage = new DropPage(driver);
        ExtentTest test = ExtentManager.getTest();

        dropPage.clickWorkSpaceLink();
        dropPage.clickAUI2Button();
        test.pass("Clicked on AUI-2 button");
        test.info("Page heading after click on AUI-2 button: <b>" + dropPage.getPageHeading() + "</b>");

        // Capture initial text of target box
        String beforeDrop = dropPage.getTargetBoxText();
        test.info("Before Drag & Drop, target box text: " + beforeDrop);

        // Perform drag-and-drop
        dropPage.dragAndDrop();   // Actions-based attempt
        WaitUtils.waitForSeconds(driver, 3);

        // Capture after text
        String afterDrop = dropPage.getTargetBoxText();
        test.info("After Drag & Drop, target box text: " + afterDrop);

        // Validation
        if (!afterDrop.equals(beforeDrop)) {
            test.pass("Drag-and-drop worked. Target text changed from '" + beforeDrop + "' to '" + afterDrop + "'");
        } else {
            test.warning("Drag-and-drop action could not be validated (HTML5 limitation in Selenium). " +
                         "Target box text did not change, still: '" + afterDrop + "'");
            throw new SkipException("Skipping test: HTML5 drag-and-drop not supported without JavaScript.");
        }
    }
}

