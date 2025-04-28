package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntroduction {
    public static void main(String[] args) {
        /// Chrome Launch
        // webdriver.chrome.driver
        // chromedriver -> invoke Chrome browser
        // Set the path to the ChromeDriver executable
        // System.setProperty("webdriver.chrome.driver","/Users/yahyayusifli/Documents/chromedriver-mac-arm64/chromedriver");
        // Create a WebDriver instance for Chrome
        // WebDriver driver = new ChromeDriver();

        /// Firefox Launch
        // webdriver.gecko.driver
        // geckodriver
        // System.setProperty("webdriver.gecko.driver","/Users/yahyayusifli/Documents/geckodriver");
        // WebDriver driver = new FirefoxDriver();

        /// Microsoft EdgeBrowser Launch
        // webdriver.edge.driver
        // msedgedriver
        System.setProperty("webdriver.edge.driver","/Users/yahyayusifli/Documents/msedgedriver");
        WebDriver driver = new EdgeDriver();

        driver.get("https://rahulshettyacademy.com");
        System.out.println("Title: " + driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        // Close only current window
        driver.close();
        // Close all window
        driver.quit();





    }
}
