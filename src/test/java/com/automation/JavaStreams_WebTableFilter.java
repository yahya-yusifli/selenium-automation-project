package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams_WebTableFilter {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("search-field")).sendKeys("Rice");
        // 5 results
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
        // 1 result
        List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice"))
                .collect(Collectors.toList());
        Assert.assertEquals(veggies.size(),filteredList.size());


        Thread.sleep(2000);
        driver.quit();
    }
}
