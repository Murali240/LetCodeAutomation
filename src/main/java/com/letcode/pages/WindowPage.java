package com.letcode.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowPage extends BasePage {
	
	/* -------------- Constructor -------------- */
    public WindowPage(WebDriver driver) {
        super(driver);                              // Call BasePage constructor
        PageFactory.initElements(driver, this);     // Initialize InputPage elements
    } 
    
    
    /* ---------------- Locators ---------------- */

    /** Tabs button */
    @FindBy(xpath = "//a[normalize-space()='Tabs']")
    private WebElement tabsButton;

    /** Open Home Page button */
    @FindBy(id = "home")
    private WebElement openHomePageButton;
    
    /** Multiple Windows button */
    @FindBy(id = "multi")
    private WebElement multipleWindowsButton;
    
    /** Click on Multiple Windows button */
    public void clickMultipleWindowsButton() {
        multipleWindowsButton.click();
    }
    
    
    /* ---------------- Actions ---------------- */

    /** Click on Tabs button */
    public void clickTabsButton() {
        tabsButton.click();
    }

    /** Click on Home Page button → Switch to newly opened tab → Get its title */
    public String openHomePageAndGetTitle() {
        /** Store the parent window */
        String parentWindow = driver.getWindowHandle();

        /** Click Home Page button */
        openHomePageButton.click();

        /** Get all windows */
        Set<String> allWindows = driver.getWindowHandles();
        String childWindowTitle = null;

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                /** Switch to child */
                driver.switchTo().window(window);

                /** Get child window title */
                childWindowTitle = driver.getTitle();

                /** Close child window */
                driver.close();

                /** Switch back to parent */
                driver.switchTo().window(parentWindow);
            }
        }
        return childWindowTitle;
    }
    
    /** Multiple Window handing - Approach 1: Using List */
    public String getChildWindowTitle_UsingList() {
        String parentWindow = driver.getWindowHandle();
        clickMultipleWindowsButton();

        Set<String> windows = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windows);

        /** Assuming 2nd window is child */
        driver.switchTo().window(windowList.get(1));
        String childTitle = driver.getTitle();

        /** Close child and switch back */
        driver.close();
        driver.switchTo().window(parentWindow);
        return childTitle;
    }

    /** Approach 2: Using LinkedHashSet + Loop */
    public String getChildWindowTitle_UsingLinkedHashSetLoop() {
        String parentWindow = driver.getWindowHandle();
        clickMultipleWindowsButton();

        Set<String> windows = new LinkedHashSet<>(driver.getWindowHandles());
        String childTitle = null;

        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                childTitle = driver.getTitle();
                driver.close();
                driver.switchTo().window(parentWindow);
            }
        }
        return childTitle;
    }

    /** Approach 3: Using Iterator */
    public String getChildWindowTitle_UsingIterator() {
        String parentWindow = driver.getWindowHandle();
        clickMultipleWindowsButton();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        String childTitle = null;
        while (it.hasNext()) {
            String window = it.next();
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                childTitle = driver.getTitle();
                driver.close();
                driver.switchTo().window(parentWindow);
            }
        }
        return childTitle;
    }

    
}
