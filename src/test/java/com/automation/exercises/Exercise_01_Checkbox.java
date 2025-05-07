package com.automation.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Exercise_01_Checkbox {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/yahyayusifli/Documents/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement checkbox1 = driver.findElement(By.id("checkBoxOption1"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        System.out.println("Checkbox 1 selected? " + checkbox1.isSelected());

        if (checkbox1.isSelected()) {
            checkbox1.click();
        }
        System.out.println("Checkbox 1 selected after unchecking? " + checkbox1.isSelected());

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println("Total checkboxes on the page: " + checkboxes.size());

        driver.quit();



    }
}
