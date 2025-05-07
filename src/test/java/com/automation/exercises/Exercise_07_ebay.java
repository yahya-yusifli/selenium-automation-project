package com.automation.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class Exercise_07_ebay {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.ebay.com/");

        // Wait for footer to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("glbfooter")));

        WebElement footer = driver.findElement(By.id("glbfooter"));

        // Updated selector
        WebElement col = footer.findElement(By.cssSelector("td:nth-child(2) ul"));

        List<WebElement> links = col.findElements(By.tagName("a"));

        String beforeClicking = driver.getTitle();
        String afterClicking = "";

        for (WebElement link : links) {
            if (link.getText().contains("Site map")) {
                link.click();
                break;
            }
        }

        afterClicking = driver.getTitle();

        if (!beforeClicking.equals(afterClicking)) {
            if (driver.getPageSource().toLowerCase().contains("sitemap")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL: sitemap keyword not found");
            }
        } else {
            System.out.println("FAIL: Page title did not change");
        }

        driver.quit();
    }
}