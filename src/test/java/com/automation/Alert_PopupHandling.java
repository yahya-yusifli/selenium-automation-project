package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_PopupHandling {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        handleAlert(driver, "alertbtn", true);
        handleAlert(driver, "confirmbtn", false);

        Thread.sleep(1000);
        driver.quit();
    }
    public static void handleAlert(WebDriver driver, String buttonId, boolean accept) {
        driver.findElement(By.id(buttonId)).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);

        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }
}