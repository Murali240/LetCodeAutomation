package com.letcode.input.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.InputPage;
import com.letcode.utilities.ExtentManager;

public class InputFieldClearTest extends BaseTest {

    /** Test case: Clear the text in ClearMe input field and log existing text in Extent */
    @Test (groups = {"regression"})
    public void verifyClearingOfInputFieldText() {

        InputPage inputPage = new InputPage(driver);

        inputPage.clickWorkSpaceLink();
	    inputPage.clickEditButton();
        
        /** Step 1: Get current text from Clear Me Text */
        String existingText = inputPage.getTextFromClearTheText();
        ExtentManager.getTest().pass("ℹ️ Existing text before clearing: <b>" + existingText + "</b>");

        /** Step 2: Clear the input field */
        inputPage.clearTextFromClearTheText();
        ExtentManager.getTest().pass("✅ Cleared the text inside ClearMe input field");

        /** Optional: Verify field is empty */
        String afterClearText = inputPage.getTextFromClearTheText();
        Assert.assertEquals(afterClearText, "", "❌ ClearMe input field should be empty");
        ExtentManager.getTest().pass("✅ Verified ClearMe input field is empty after clearing");
    
    }


}
