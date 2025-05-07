package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities_Navigation {

    public static void main(String[] args) {
        // SeleniumManager (Beta phase)
        System.setProperty("webdriver.chrome.driver", "/Users/yahyayusifli/Documents/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window to full screen
        driver.manage().window().maximize();

        // Load Google’s homepage and wait for it to fully render
        driver.get("http://google.com");

        // Navigate to Rahul Shetty Academy using the Navigation interface
        driver.navigate().to("https://rahulshettyacademy.com");

        // Move back to the previous page in the browser's history
        driver.navigate().back();

        // Move forward to the next page in the browser's history
        driver.navigate().forward();
    }
}
