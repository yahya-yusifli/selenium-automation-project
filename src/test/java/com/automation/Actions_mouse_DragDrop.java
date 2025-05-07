package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_mouse_DragDrop {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");

        // Print the size of the iframe element (just for checking)
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        // Switch Selenium context into the first iframe on the page (index 0)
        driver.switchTo().frame(0);
        // Alternative way to switch by using the iframe's CSS selector:
        // driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

        // Click the draggable element (just to confirm it's accessible)
        driver.findElement(By.id("draggable")).click();

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // Perform drag-and-drop from source to target
        actions.dragAndDrop(source, target).build().perform();
        driver.switchTo().defaultContent();

        Thread.sleep(5000);
        driver.quit();
    }
}