package com.letcode.calender.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.CalendarPage;
import com.letcode.utilities.ExtentManager;
import com.letcode.utilities.WaitUtils;

public class CalendarBirthdayTest extends BaseTest {
	
	@Test (groups = {"sanity"})
	public void selectBirthdayTest() {
		
	    CalendarPage calendarPage = new CalendarPage(driver);
	    ExtentTest test = ExtentManager.getTest();

	    calendarPage.clickWorkSpaceLink();
	    calendarPage.clickDateAndTimeButton();
	    test.pass("Clicked on Date&Time button");
	    test.info("Page heading after Date&Time button: <b>" + calendarPage.getPageHeading() + "</b>");

	    /** Select your birthday in dd-mm-yyyy format */
	    String myDOB = "15-03-1995";
	    calendarPage.selectBirthday(myDOB);
	    test.pass("Selected birthday: <b>" + myDOB + "</b>");

	    WaitUtils.waitForSeconds(driver, 1);
	
	}


}
