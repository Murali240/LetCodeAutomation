package com.letcode.forms.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.FormsPage;
import com.letcode.utilities.ExtentManager;

public class FormsPageTest extends BaseTest {
	
	@Test (groups = {"smoke"})
    public void fillAndSubmitFormTest() {
		
		 FormsPage formsPage = new FormsPage(driver);
		 ExtentTest test = ExtentManager.getTest();

		 formsPage.clickWorkSpaceLink();
		 formsPage.clickAllInOneButton();
		 test.pass("Clicked on All in One button");
		 test.info("Page heading after All in One button: <b>" + formsPage.getPageHeading() + "</b>");
       
         formsPage.enterFirstName("John");
         test.pass("Entered First Name");

         formsPage.enterLastName("Doe");
         test.pass("Entered Last Name");

         formsPage.enterEmail("john.doe@example.com");
         test.pass("Entered Email");

         formsPage.selectCountryCode("India (+91)");
         test.pass("Selected Country Code");

         formsPage.enterPhoneNumber("9876543210");
         test.pass("Entered Phone Number");

         formsPage.enterAddressLine1("123 Main Street");
         test.pass("Entered Address Line 1");

         formsPage.enterAddressLine2("Apt 4B");
         test.pass("Entered Address Line 2");

         formsPage.enterState("California");
         test.pass("Entered State");

         formsPage.enterPincode("500032");
         test.pass("Entered Pincode");

         formsPage.selectCountry("India");
         test.pass("Selected Country");
         
         /** Select your birthday in dd-mm-yyyy format */
 	     String myDOB = "10-03-1996";
 	     formsPage.selectBirthday(myDOB);
 	     test.pass("Selected birthday: <b>" + myDOB + "</b>");

         formsPage.selectGender("male");
         test.pass("Selected Gender: Male");

         formsPage.clickIAgreeCheckbox();
         test.pass("Clicked 'I Agree' checkbox");

         formsPage.clickSubmitButton();
         test.pass("Clicked Submit button");

	}

	
}
