package com.letcode.frame.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.letcode.base.BaseTest;
import com.letcode.pages.FramePage;
import com.letcode.utilities.ExtentManager;

public class FramePageTest extends BaseTest {
	
	@Test
    public void verifyFrameHandlingConcepts() {
		
		FramePage framePage = new FramePage(driver);
		
		framePage.clickWorkSpaceLink();
		framePage.clickInnerHTMLButton();
		ExtentManager.getTest().info("Page heading after click on inner HTML: <b>" + framePage.getPageHeading()+"</b>");	
		
        try {
        	
            /** switchTo() using index */
        	ExtentManager.getTest().info("Switching to first frame using index");
            framePage.switchToFrame(0);
            ExtentManager.getTest().pass("Successfully switched to first frame");

            /** Enter First Name */
            ExtentManager.getTest().info("Entering first name");
            framePage.enterFirstName("Murali");
            ExtentManager.getTest().pass("First name entered successfully");

            /** Enter Last Name */
            ExtentManager.getTest().info("Entering last name");
            framePage.enterLastName("Krishna");
            ExtentManager.getTest().pass("Last name entered successfully");

            /** switchTo() using WebElement */
            ExtentManager.getTest().info("Switching to inner frame using WebElement");
            WebElement innerFrame = driver.findElement(By.xpath("//iframe[@src='innerframe']"));
            framePage.switchToFrame(innerFrame);
            ExtentManager.getTest().pass("Successfully switched to inner frame");

            /** Enter Email - Overloading concept (method 1) */
            ExtentManager.getTest().info("Entering email using String input");
            framePage.enterEmail("murali@test.com");
            ExtentManager.getTest().pass("Email entered successfully using String input");

            /** Enter Email - Overloading concept (method 2 with WebElement) */
            ExtentManager.getTest().info("Entering email using WebElement + String");
            WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Enter email' and @name='email']"));
            framePage.enterEmail(emailField, "krishna@test.com");
            ExtentManager.getTest().pass("Email entered successfully using WebElement + String");
            
            /** Switch back to parent frame (from inner → outer) */
            ExtentManager.getTest().info("Switching back to parent frame");
            framePage.switchToParentFrame();
            ExtentManager.getTest().pass("Switched back to parent frame successfully");

            /** Switch back to default content (from outer → main page) */
            ExtentManager.getTest().info("Switching back to default content");
            ExtentManager.getTest().info("Verifying Enter Details heading visibility");
            boolean headingDisplayed = framePage.isEnterDetailsHeadingDisplayed();

            if (headingDisplayed) {
                ExtentManager.getTest().pass("Enter Details heading is displayed successfully");
            } else {
                ExtentManager.getTest().fail("Enter Details heading is NOT displayed");
            }
            
            framePage.switchToDefaultContent();
            ExtentManager.getTest().pass("Switched back to default content successfully");

            ExtentManager.getTest().pass("Page heading: <b>" + framePage.getPageHeading()+"</b>");
            
        } catch (Exception e) {
        	ExtentManager.getTest().fail("Test failed due to exception: " + e.getMessage());
        }
    
	}

	
}
