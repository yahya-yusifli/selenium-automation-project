package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Miscellaneous {
    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 1. Delete all cookies in the browser (clears session and site data)
        driver.manage().deleteAllCookies();

        // 2. Delete a specific cookie by name ("test")
        driver.manage().deleteCookieNamed("test");

        // 3. Delete another specific cookie by name ("Session")
        driver.manage().deleteCookieNamed("Session");

        // TODO: click on any link (e.g., login page) and verify the URL

        driver.get("https://google.com");

        // 4. Take a screenshot of the current page
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // 5. Save the screenshot to the specified file path
        FileUtils.copyFile(src, new File("/Users/yahyayusifli/Downloads/screenshot.png"));

        driver.quit();
    }
}