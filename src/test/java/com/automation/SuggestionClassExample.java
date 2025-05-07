package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SuggestionClassExample {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String countryToSelect = "United Kingdom (UK)";

        driver.findElement(By.id("autocomplete")).sendKeys("united");
        Thread.sleep(2000);

        List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item div"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(countryToSelect)) {
                option.click();
                break;
            }
        }
    }

}
