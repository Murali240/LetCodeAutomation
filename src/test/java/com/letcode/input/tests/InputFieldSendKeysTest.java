package com.letcode.input.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.InputPage;
import com.letcode.utilities.ExtentManager;

public class InputFieldSendKeysTest extends BaseTest {	
	
	@Test (groups = {"smoke"})
    public void verifyFullNameEnteredUsingSendKeys() {
		
        /** Create Page Object */
        InputPage inputPage = new InputPage(driver);

        /** Step 1: Click Work-Space link in navbar */
        inputPage.clickWorkSpaceLink();

        /** Step 2: Click Edit button */
        inputPage.clickEditButton();

        /** Step 3: Fetch dynamic heading from page & Verify Input heading is displayed */
        String heading = inputPage.getPageHeading();
        ExtentManager.getTest().info("Verifying page heading dynamically: <b>" + heading+"</b>");
        
        try {
         // Example assertion (if you have an expected heading for this test)
            Assert.assertEquals(heading, "Input", "❌ Page heading does not match");
            test.pass("Page heading verified successfully: " + heading);
        } catch (AssertionError e) {
            test.fail("Page heading verification failed! Found: " + heading);
            throw e;         // rethrow to fail the test
        }
               
        /** Step 4: Enter name into Full Name input field */
        String expectedName = "Gopi Krishna";
        inputPage.enterFullName(expectedName);

        /** Step 5 (Optional): Validate if value was entered correctly */
        String actualName = driver.findElement
                                   (org.openqa.selenium.By.id("fullName")).getAttribute("value");
        
        Assert.assertEquals(actualName, expectedName, 
                "❌ Full Name input value mismatch");

        ExtentManager.getTest().pass("✅ Successfully entered full name using <b>sendKeys</b> method");
   
    }

	
}
