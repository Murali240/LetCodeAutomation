package com.letcode.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage extends BasePage {
	

	/* -------------- Constructor -------------- */
    public SliderPage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    } 
    
    
    /* ---------------- Locators ---------------- */
    /** Clickable AUI-5 button */
    @FindBy(xpath = "//a[normalize-space()='AUI - 5']")
    private WebElement aui5Button;

    /** Word limit text heading */
    @FindBy(xpath = "//h1[starts-with(normalize-space(), 'Word limit :')]")
    private WebElement wordLimitCount;

    /** Slider input element */
    @FindBy(id = "generate")
    private WebElement sliderBar;

    /** Button to get countries */
    @FindBy(xpath = "//button[normalize-space()='Get Countries']")
    private WebElement getCountriesButton;

    /** List of filtered countries */
    @FindBy(xpath = "//p[@class='has-text-primary-light']")
    private List<WebElement> filteredCountriesList;
    
    
    /* ---------------- Actions ---------------- */
    /** Click AUI-5 button */
    public void clickAUI5Button() {
        aui5Button.click();
    }

    /** Get word limit text */
    public String getWordLimitText() {
        return wordLimitCount.getText();
    }
    
    public void moveSliderTo(int value) {
        if (value < 1 || value > 50) {
            throw new IllegalArgumentException("Slider value must be between 1 and 50");
        }
        // Set value via JS
        String js = "arguments[0].value='" + value + "'; arguments[0].dispatchEvent(new Event('change'))";
        ((JavascriptExecutor) driver).executeScript(js, sliderBar);
    }

    /** Click "Get Countries" button */
    public void clickGetCountriesButton() {
        getCountriesButton.click();
    }
    
    /** Get list of coutries based on Slider bar moved */
    public List<String> getFilteredCountries() {
        List<String> countryNames = new ArrayList<>();
        for (WebElement country : filteredCountriesList) {
            String text = country.getText().trim();
            if (!text.isEmpty()) {
                countryNames.add(text);
            }
        }
        return countryNames;
    }

    
}
