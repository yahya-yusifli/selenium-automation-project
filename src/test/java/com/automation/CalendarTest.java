package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalendarTest {

    public static void main(String[] args) {

        String month = "6";
        String day = "15";
        String year = "2025";
        String[] expectedList= {month,day,year};

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();

        List<WebElement>actualList =  driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for (int i =0; i< actualList.size();i++) {
            System.out.print(actualList.get(i).getAttribute("value") + "/");
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }

        driver.quit();
    }
}
