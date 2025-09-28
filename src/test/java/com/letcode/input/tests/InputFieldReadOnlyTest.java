package com.letcode.input.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.InputPage;
import com.letcode.utilities.ExtentManager;

public class InputFieldReadOnlyTest extends BaseTest {

    /** Test case: Verify that the DontWrite input field is read-only and does not accept text */
    @Test (groups = {"regression"})
    public void verifyConfirmTextIsReadOnly() {

        InputPage inputPage = new InputPage(driver);

        inputPage.clickWorkSpaceLink();
	    inputPage.clickEditButton();
         
	    /** Step 1: Verify the field is read-only */
	    boolean isReadOnly = inputPage.isConfirmTextIsReadOnly();
	    Assert.assertTrue(isReadOnly, "❌ DontWrite input field should be read-only");
	    ExtentManager.getTest().pass("✅ Confirmed that DontWrite input field is read-only");

        /** Step 2: Try to enter text */
        String textToEnter = "Trying to write text";
        inputPage.tryToEnterTextInConfirmTextIsReadOnlyInputField(textToEnter);

        /** Step 3: Get current value and validate it did not change */
        String currentValue = inputPage.getTextFromConfirmTextIsReadOnlyInputField();
        Assert.assertNotEquals(currentValue, textToEnter, "❌ Read-only field should not accept input");
        ExtentManager.getTest().pass("✅ Attempted to enter text but field remained read-only: <b>" + currentValue + "</b>");
    
    }


}