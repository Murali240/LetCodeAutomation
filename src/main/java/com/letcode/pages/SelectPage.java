package com.letcode.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.letcode.utilities.ExtentManager;

public class SelectPage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public SelectPage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    }   
	
    
    /* ---------------- Locators ---------------- */  
    /** Dropdown button to open drop-down section */
    @FindBy(xpath = "//a[normalize-space()='Drop-Down']")
    private WebElement dropdownButton;

    /** Fruits select dropdown */
    @FindBy(id = "fruits")
    private WebElement selectFruitDropdown;
    
    /** Superheros multi-select dropdown */
    @FindBy(id = "superheros")
    private WebElement superHerosDropdown;
    
    /** Programming language dropdown */
    @FindBy(xpath = "//body[1]/app-root[1]/app-dropdown[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/select[1]")
    private WebElement programmingLanguageDropdown;
    
    /** Country dropdown */
    @FindBy(id = "country")
    private WebElement countryDropdown;
    
    
    
    /* ------------ Action Methods ------------- */
    /** Clicks on the drop-down button */
    public void clickDropdownButton() {
        dropdownButton.click();
    }
    
    /** Selects a fruit from the fruits dropdown by visible text */
    public void selectFruitByVisibleText(String fruitName) {
        Select select = new Select(selectFruitDropdown);
        select.selectByVisibleText(fruitName);
    }
    
    /** Getter for fruits dropdown WebElement for assertion */
    public WebElement getSelectFruitDropdown() {
        return selectFruitDropdown;
    }

    /** Check if the superheros dropdown allows multiple selections (Otherwise false) */
    public boolean isSuperHerosMultiple() {
        Select select = new Select(superHerosDropdown);
        return select.isMultiple();
    }
    
    /** Select multiple superheros by visible text, @param heros - array of superhero names  */
    public void selectMultipleSuperHeros(String... heros) {
        Select select = new Select(superHerosDropdown);
        for (String hero : heros) {
            select.selectByVisibleText(hero);
        }
    }

    /** Getter for superheros dropdown (for assertions if needed) */
    public WebElement getSuperHerosDropdown() {
        return superHerosDropdown;
    }
    
    /** Select the last programming language by index */
    public void selectLastProgrammingLanguage() {
        Select select = new Select(programmingLanguageDropdown);

        /** Get total number of options */
        int totalOptions = select.getOptions().size();

        /** Select last option (index starts from 0) */
        select.selectByIndex(totalOptions - 1);
    }
    
    /** Print all available programming languages */
    public void printAllProgrammingLanguages() {
        Select select = new Select(programmingLanguageDropdown);
        List<WebElement> options = select.getOptions();

        ExtentManager.getTest().info("Available programming languages:");
        for (WebElement option : options) {
        	System.out.println(option.getText());
        }
    }
    
    /** Getter for programming language dropdown */
    public WebElement getProgrammingLanguageDropdown() {
        return programmingLanguageDropdown;
    }
    
    /** Select India from country dropdown using value */
    public void selectCountryByValue(String value) {
        Select select = new Select(countryDropdown);
        select.selectByValue(value);
    }

    /** Get the selected country text */
    public String getSelectedCountry() {
        Select select = new Select(countryDropdown);
        return select.getFirstSelectedOption().getText();
    }

    /** Getter for country dropdown (if needed outside) */
    public WebElement getCountryDropdown() {
        return countryDropdown;
    }
  
    
}
