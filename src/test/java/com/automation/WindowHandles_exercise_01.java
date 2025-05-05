package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles_exercise_01 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itWindows = windows.iterator();

        String parenID = itWindows.next();
        String childID = itWindows.next();

        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());

        driver.switchTo().window(parenID);
        System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());

        driver.quit();



    }
}
