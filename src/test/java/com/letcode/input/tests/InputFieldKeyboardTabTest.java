package com.letcode.input.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.InputPage;
import com.letcode.utilities.ExtentManager;

public class InputFieldKeyboardTabTest extends BaseTest {

    /** Test case: Append text in Join field and verify cursor moves to GetMe field using TAB */
    @Test
    public void verifyAppendTextAndKeyboardTab() {

        InputPage inputPage = new InputPage(driver);
        
        inputPage.clickWorkSpaceLink();
        inputPage.clickEditButton();

        /** Step 1: Append text and press TAB */
        String textToAppend = " automation tester";
        String fullText = inputPage.appendTextAndPressTab(textToAppend);
        ExtentManager.getTest().pass("✅ Appended text to Join field: <b>" + textToAppend + "</b> and pressed Keyboard TAB");
        ExtentManager.getTest().pass("✅ Full text in Join field after append: <b>" + fullText + "</b>");
        
        /** Step 2: Validate focus moved to the next input field */
        WebElement focusedElement = inputPage.getFocusedElement();
        WebElement expectedElement = inputPage.getNextInputField();

        Assert.assertEquals(focusedElement, expectedElement,
                "❌ Cursor should focus on GetMe input field after pressing TAB");
        ExtentManager.getTest().pass("✅ Cursor successfully moved to <b>GetMe input field</b> after pressing Keyboard TAB");
    
    }


}
