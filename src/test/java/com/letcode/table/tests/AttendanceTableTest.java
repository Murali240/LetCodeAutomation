package com.letcode.table.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.TablePage;
import com.letcode.utilities.ExtentManager;
import com.letcode.utilities.WaitUtils;

public class AttendanceTableTest extends BaseTest {
	
	    @Test (groups = {"sanity"})
	    public void markRajAsPresent() {
	    	
	    	TablePage tablePage = new TablePage(driver);
	        ExtentTest test = ExtentManager.getTest();
	        
	        tablePage.clickWorkSpaceLink();
	        tablePage.clickSimpleTableButton();
	        test.pass("Clicked Simple Table button");
	        test.info("Page heading after click on Simple Table button: <b>" + tablePage.getPageHeading() + "</b>");

	        /** Mark Yashwanth Raj as present */
	        tablePage.markStudentPresent("Yashwanth", "Raj");
	        WaitUtils.waitForSeconds(driver, 1);

	        /** Assert that the student is actually marked present */
	        Assert.assertTrue(tablePage.isStudentPresent("Yashwanth", "Raj"), "❌ Yashwanth Raj was not marked present!");

	        test.pass("✅ Assertion passed: Yashwanth Raj is marked present");
	    
	    }
	    

}
