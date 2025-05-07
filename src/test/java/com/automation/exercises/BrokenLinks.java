package com.automation.exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.cssSelector("li.gf-li a"));

        //  1. Initialize SoftAssert to aggregate any link failures
        SoftAssert softAssert = new SoftAssert();

        //  2. Iterate through each link, send HEAD request, and validate response code
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode + " | URL: " + url);

            softAssert.assertTrue(
                    responseCode < 400,
                    "Broken link detected: [" + link.getText() + "] returned code " + responseCode
            );
        }

        //  3. Assert all collected link verifications
        softAssert.assertAll();

        //  4. Close the browser session
        driver.quit();
    }
}