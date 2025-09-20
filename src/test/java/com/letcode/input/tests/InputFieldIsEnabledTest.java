package com.letcode.input.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.InputPage;
import com.letcode.utilities.ExtentManager;

public class InputFieldIsEnabledTest extends BaseTest {

    /** Test case: Verify that the NoEdit input field is disabled */
    @Test
    public void verifyConfirmEditFieldIsDisabled() {

        InputPage inputPage = new InputPage(driver);

        inputPage.clickWorkSpaceLink();
	    inputPage.clickEditButton();
        
        /** Step 1: Check if the field is enabled */
        boolean isEnabled = inputPage.isNoEditInputEnabled();

        /** Step 2: Verify it is disabled */
        Assert.assertFalse(isEnabled, "❌ NoEdit input field should be disabled");
        
        ExtentManager.getTest().pass("✅ Confirmed that <b>NoEdit input field is disabled</b> (not editable)");
    
    }


}
