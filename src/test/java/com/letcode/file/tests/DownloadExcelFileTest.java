package com.letcode.file.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import com.letcode.base.BaseTest;
import com.letcode.pages.FilePage;
import com.letcode.utilities.ExtentManager;
import com.letcode.utilities.FileDownloadUtils;
import com.letcode.utilities.WaitUtils;

public class DownloadExcelFileTest extends BaseTest {
	
	@Test (groups = {"sanity"})
    public void verifyDownloadExcelFile() {
    	
        FilePage filePage = new FilePage(driver);
        ExtentTest test = ExtentManager.getTest();

        filePage.clickWorkSpaceLink();
        filePage.clickFileManagementButton();
        test.pass("Clicked on File Management button");
		test.info("Page heading after File Management button: <b>" + filePage.getPageHeading() + "</b>");

		 /** Verify sample file is downloaded */
		filePage.clickDownloadExcel();
	    WaitUtils.waitForSeconds(driver, 2); 
		test.pass("Clicked on Download Excel button");
		
		/** Download path for file verification */
        String downloadPath = "C:\\Users\\mural\\Downloads";                // adjust path
        boolean isDownloaded = FileDownloadUtils.isFileDownloaded(downloadPath, "sample");

        if (isDownloaded) {
            ExtentManager.getTest().pass("sample was successfully downloaded and verified in <b>Downloads folder</b>");
        } else {
            ExtentManager.getTest().fail("sample download verification failed. File not found in Downloads folder");
        }

        Assert.assertTrue(isDownloaded, "sample file was not downloaded successfully");
        
	}


}
