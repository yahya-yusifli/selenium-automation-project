package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.JOptionPane;
import java.time.Duration;

public class Actions_01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/yahyayusifli/Documents/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");


        // Show a popup message to pause the script so you can manually solve CAPTCHA if present
        JOptionPane.showMessageDialog(null, "If there is a CAPTCHA, solve it manually and then click OK.");

        // Wait until the account list element is visible on the page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));

        // Create an Actions class instance
        Actions actions = new Actions(driver);

        // Hover the mouse over the account list element
        actions.moveToElement(accountList).build().perform();

        // Move to the search box, click on it, hold the SHIFT key, and type 'apple' (it will appear as 'APPLE')
        actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
                .click()                      // click on the search box
                .keyDown(Keys.SHIFT)          // hold down the SHIFT key
                .sendKeys("apple")            // type 'apple' (with SHIFT held, it types as 'APPLE')
                .doubleClick()
                .build().perform();

        // Hover the mouse over the account list element and perform a right-click (context click)
        actions.moveToElement(accountList)
                .contextClick()          // perform a right-click on the element
                .build()
                .perform();

        // Hover over the account list element and then move the mouse by a certain x, y offset
        // (You need to provide the x and y values in moveByOffset(x, y), e.g., moveByOffset(10, 20))
        actions.moveToElement(accountList)
                .moveByOffset( 50/* x offset */, /* y offset */20 )  // move mouse by x and y pixels relative to the current position
                .build()
                .perform();



    }
}