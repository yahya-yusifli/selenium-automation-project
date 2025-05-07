package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles_MultipleWindows {

    public static void main(String[] args) {

        // Setup ChromeDriver using WebDriverManager (no need to set system property manually)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.cssSelector(".blinkingText")).click();

        // Get all window handles (IDs) currently open in the browser [parentID, childID,subchildID]
        Set<String> windows = driver.getWindowHandles();

        // Create an iterator to loop through the window handles
        Iterator<String> it = windows.iterator();

        // Get the parent window ID (first one)
        String parentId = it.next();

        // (You still need to get the child window ID and switch to it here)
        String childId = it.next();

        driver.switchTo().window(childId);

        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailId);
        driver.findElement(By.id("password")).sendKeys("learning");

    }
}