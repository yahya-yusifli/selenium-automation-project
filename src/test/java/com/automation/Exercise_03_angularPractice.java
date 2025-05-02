package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise_03_angularPractice {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/yahyayusifli/Documents/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.cssSelector("div.form-group input[name='name']")).sendKeys("username");
        driver.findElement(By.cssSelector("div.form-group input[name='email']")).sendKeys("username@email.com");
        driver.findElement(By.cssSelector("div.form-group input[placeholder='Password']")).sendKeys("user@123");
        driver.findElement(By.id("exampleCheck1")).click();
        driver.findElement(By.cssSelector("select#exampleFormControlSelect1 option")).click();
        driver.findElement(By.cssSelector("select#exampleFormControlSelect1 option:nth-of-type(2)")).click();
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("10071994");
        driver.findElement(By.cssSelector("input.btn.btn-success")).click();

        System.out.println(driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).getText());
    }
}
