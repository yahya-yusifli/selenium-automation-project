package com.automation.exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandle_EBebek {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.e-bebek.com/");

        // Footer elementini bul (burada footer veya alt bilgi kısmını netleştir)
        WebElement footer = driver.findElement(By.cssSelector(".row-gap-8"));
        List<WebElement> links = footer.findElements(By.tagName("a"));
        System.out.println("Found " + links.size() + " links in footer.");

        for (WebElement link : links) {
            System.out.println("Opening: " + link.getText());
            link.sendKeys(Keys.chord(Keys.COMMAND, Keys.RETURN));
            Thread.sleep(1000);
        }

        // Tüm sekmeleri gez ve başlıkları yazdır
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();

        while (it.hasNext()) {
            String window = it.next();
            driver.switchTo().window(window);
            System.out.println("Page Title: " + driver.getTitle());
        }

        driver.quit();
    }
}
