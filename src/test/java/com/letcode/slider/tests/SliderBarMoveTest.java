package com.letcode.slider.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.letcode.base.BaseTest;
import com.letcode.pages.SliderPage;
import com.letcode.utilities.ExtentManager;

public class SliderBarMoveTest extends BaseTest {

    @Test
    public void verifySliderBarMoveAndCountries() {

        SliderPage sliderPage = new SliderPage(driver);
        ExtentTest test = ExtentManager.getTest();

        /** Click WorkSpace link and AUI-5 button */
        sliderPage.clickWorkSpaceLink();
        sliderPage.clickAUI5Button();
        test.pass("Clicked on AUI-5 button");
        test.info("Page heading after click on AUI-5 button: <b>" + sliderPage.getPageHeading() + "</b>");
       
        /** Move Slider to a value (e.g., 25) */
        int sliderValue = 25;                     // Can be randomized if needed
        sliderPage.moveSliderTo(sliderValue);
        test.info("Moved slider to value: " + sliderValue);
        
        /** Get Word Limit Text */
        String wordLimit = sliderPage.getWordLimitText();
        test.info("Word limit text: " + wordLimit);

        /** Click Get Countries button */
        sliderPage.clickGetCountriesButton();
        test.pass("Clicked 'Get Countries' button");

        /** Get filtered countries from page */
        List<String> countriesList = sliderPage.getFilteredCountries();
        test.info("Filtered countries (raw list): " + countriesList);

        /** Count total countries using split if necessary */
        int countriesCount = 0;
        for (String countryText : countriesList) {
            if (countryText.contains(" - ")) {
                countriesCount += countryText.split(" - ").length;
            } else if (!countryText.isEmpty()) {
                countriesCount += 1;
            }
        }

        // Log count in ExtentReport
        test.info("Number of filtered countries: " + countriesCount);

        /** Validate countries count matches slider value */
        Assert.assertEquals(countriesCount, sliderValue, "Countries count does not match slider value");
        test.pass("Validated countries count matches slider value: <b>" + sliderValue + "</b>");
    }


}

