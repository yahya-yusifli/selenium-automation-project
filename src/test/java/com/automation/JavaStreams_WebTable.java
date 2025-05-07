package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams_WebTable {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        // capture all webelements into list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

        // capture text of all webelements into new (original) list
        List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());

        // sort on the original the list of step 3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        // compare original list vs sorted list
        Assert.assertTrue(originalList.equals(sortedList));

        // scan the name column and if we get with getText -> Beans -> print the price of Beans
        List<String> price;
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice"))
                    .map(s -> getPriceVeggie(s))
                    .collect(Collectors.toList());
            price.forEach(a -> System.out.println("Price: " + a));

            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while (price.size() < 1);


        driver.quit();
    }

    // tr/td[1]/following-sibling::td[1]
    private static String getPriceVeggie(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
