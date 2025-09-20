package com.letcode.input.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.InputPage;
import com.letcode.utilities.ExtentManager;

public class InputFieldGetAttributeTest extends BaseTest {
	
	@Test
	public void verifyInputFieldValue() {
	
		InputPage inputPage = new InputPage(driver);
	    
	    inputPage.clickWorkSpaceLink();
	    inputPage.clickEditButton();

	    /** Example: After TAB or any input */
	    String textInGetMe = inputPage.getTextFromInsideInputBox();
	    ExtentManager.getTest().pass("✅ What is inside the text box: <b>" + textInGetMe + "</b>");

	    /** Optional assertion */
	    Assert.assertEquals(textInGetMe, "ortonikc", "❌ Text mismatch in GetMe input field");
	    
	}


}
