package com.letcode.drag.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.DragPage;
import com.letcode.utilities.ExtentManager;
import com.letcode.utilities.WaitUtils;

public class DragPageTest extends BaseTest {

    @Test (groups = {"regression"})
    public void verifyDragSampleBox() {

	        DragPage dragPage = new DragPage(driver);
	        ExtentTest test = ExtentManager.getTest();
	
	        dragPage.clickWorkSpaceLink();
	        dragPage.clickAUI1Button();
	        test.pass("Clicked on AUI-1 button");
	        test.info("Page heading after click on AUI-1 button: <b>" + dragPage.getPageHeading() + "</b>");

            /** Perform drag using simple JS method */
            dragPage.dragSampleBoxByJS(90, 90);
            WaitUtils.waitForSeconds(driver, 1);
            test.info("Dragged the sample box by (90,90) using simple JS");

            /** Validate movement using CSS transform */
            String transformValue = dragPage.getDragSampleBox().getCssValue("transform");
            test.info("Transform CSS value after drag: <b>" + transformValue+"</b>");

            if (!transformValue.equals("none")) {
                test.pass("Sample box moved successfully using simple JS drag");
            } else {
                test.fail("Sample box did not move");
            }       
    
    }


}
