package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Exercise_02_RadioButtonExample {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/yahyayusifli/Documents/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement radio1 = driver.findElement(By.cssSelector("input[value='radio1']"));
        if (!radio1.isSelected()) {
            radio1.click();
        }
        System.out.println("radio 1 selected? " + radio1.isSelected());

        // Instead of trying to uncheck, select another radio to change selection:
        WebElement radio2 = driver.findElement(By.cssSelector("input[value='radio2']"));
        radio2.click();
        System.out.println("Radio 2 selected? " + radio2.isSelected());
        System.out.println("Radio 1 still selected? " + radio1.isSelected());

        List<WebElement> radio = driver.findElements(By.className("radioButton"));
        System.out.println("Total radios on the page: " + radio.size());

        driver.quit();




    }
}
