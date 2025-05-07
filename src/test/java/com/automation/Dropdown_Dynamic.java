package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown_Dynamic {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Using Selenium WebDriver to find and interact with the element by its unique ID (ID locator strategy)
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        // Using XPath locator strategy to select the <a> tag with attribute value='BLR'
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        // Applying a hard-coded wait using Java's Thread class (not Selenium-specific, general Java thread handling)
        Thread.sleep(2000);

        // (Commented out) Using XPath indexing to select the second occurrence of an element if multiple elements match
        // driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        // Using scoped XPath (relative XPath inside a container) to precisely locate the destination element within a specific div
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        // CALENDAR

    }
}
