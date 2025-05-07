package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Scope {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("a")));

        // Get the total count of all <a> (link) elements on the entire page
        int a = driver.findElements(By.tagName("a")).size();
        System.out.println("count of link: " + a);

        // Narrow the WebDriver scope to just the footer section (element with id 'gf-BIG')
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        int b = footerDriver.findElements(By.tagName("a")).size();
        System.out.println("Footer count of link: " + b);

        // Further narrow the scope to the first column inside the footer
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int c = columnDriver.findElements(By.tagName("a")).size();
        System.out.println("first column count inside Footer: " + c);

        // Loop through each link in the first column (starting from index 1)
        // Open each link in a new tab using COMMAND + RETURN (Mac shortcut)
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.COMMAND, Keys.RETURN);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            // Small delay to let the new tab open before continuing
            Thread.sleep(1000);
        }

        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it = abc.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

        driver.quit();
    }
}
