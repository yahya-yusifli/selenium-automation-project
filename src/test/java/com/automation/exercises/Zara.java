package com.automation.exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zara {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.zara.com/us/");

        driver.findElement(By.cssSelector("a[class='layout-header-action-search__content link']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("search-home-form-combo-input")).sendKeys("dress");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search-home-form-combo-menu li")));

        List<WebElement> suggestions = driver.findElements(By.cssSelector("#search-home-form-combo-menu li"));
        for (WebElement suggestion : suggestions) {
            System.out.println(suggestion.getText());
            if (suggestion.getText().toLowerCase().contains("dress")) {
                suggestion.click();
                break;
            }
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
