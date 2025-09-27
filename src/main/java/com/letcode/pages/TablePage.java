package com.letcode.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TablePage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public TablePage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    } 
    
    
    /* ---------------- Locators ---------------- */
    /** Locator for the "Simple table" button link. */
    @FindBy(xpath = "//a[normalize-space()='Simple table']")
    private WebElement simpleTableButton;
    
    /** Individual product prices */
    @FindBy(xpath = "//td[normalize-space()='150']")
    private WebElement chocolatePrice;

    @FindBy(xpath = "//td[normalize-space()='180']")
    private WebElement applePrice;

    @FindBy(xpath = "//td[normalize-space()='48']")
    private WebElement eggsPrice;

    @FindBy(xpath = "//td[normalize-space()='480']")
    private WebElement cornPrice;

    /** Displayed total price */
    @FindBy(xpath = "//b[normalize-space()='858']")
    private WebElement totalPrice;
    
    /** List of all rows in the attendance table. */
    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> rows;
    
    
    /* ---------------- Actions ---------------- */
    /** Clicks on the "Simple table" button and waits until it is clickable. */
    public void clickSimpleTableButton() {
       simpleTableButton.click();
    }
    
    /** Calculates the sum of all individual product prices and returns the total */
    public int calculateAllItemsPrice() {
        int sum = 0;
 
        /** Add each price one by one */
        sum += Integer.parseInt(chocolatePrice.getText().trim());
        sum += Integer.parseInt(applePrice.getText().trim());
        sum += Integer.parseInt(eggsPrice.getText().trim());
        sum += Integer.parseInt(cornPrice.getText().trim());

        return sum;
    }
    
    /** Returns the displayed total price from the table. */
    public int getDisplayedTotalPrice() {
        return Integer.parseInt(totalPrice.getText().trim());
    }
    
    /** Marks a student as present based on first name and last name. */
    public void markStudentPresent(String firstName, String lastName) {
        for (WebElement row : rows) {
            String fName = row.findElement(By.xpath("td[1]")).getText().trim();
            String lName = row.findElement(By.xpath("td[2]")).getText().trim();

            if (fName.equals(firstName) && lName.equals(lastName)) {
                WebElement checkbox = row.findElement(By.xpath("td[4]//input[@type='checkbox']"));
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
                System.out.println("Marked " + firstName + " " + lastName + " as Present");
                break;
            }
        }
    }
    
    /** Checks if a student is marked present based on first name and last name.
     * @return true if Present checkbox is selected, false otherwise */
    public boolean isStudentPresent(String firstName, String lastName) {
        for (WebElement row : rows) {
            String fName = row.findElement(By.xpath("td[1]")).getText().trim();
            String lName = row.findElement(By.xpath("td[2]")).getText().trim();

            if (fName.equals(firstName) && lName.equals(lastName)) {
                WebElement checkbox = row.findElement(By.xpath("td[4]//input[@type='checkbox']"));
                return checkbox.isSelected();
            }
        }
        return false; // student not found or checkbox not selected
    }


}


