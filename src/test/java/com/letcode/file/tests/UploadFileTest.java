package com.letcode.file.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.FilePage;
import com.letcode.utilities.ExtentManager;
import com.letcode.utilities.WaitUtils;

public class UploadFileTest extends BaseTest {
	
	    @Test (groups = {"sanity"})
	    public void verifyUploadFile() {
	    	
	        FilePage filePage = new FilePage(driver);
	        ExtentTest test = ExtentManager.getTest();

	        filePage.clickWorkSpaceLink();
	        filePage.clickFileManagementButton();
	        
	        /** Uploading file */
	        filePage.uploadFile("C:\\Users\\mural\\Downloads\\LoginCredentials.xlsx");
	        test.pass("File uploaded successfully");
	        WaitUtils.waitForSeconds(driver, 1);
	       
	        /** Get uploaded file type */
	        String fileType = filePage.getSelectedFileType();
	        test.info("Selected File Type: <b>" + fileType+"</b>");
	        
	    }

	    
}
