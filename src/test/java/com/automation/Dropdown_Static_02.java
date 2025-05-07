package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
// TestNG is one of the testing framework


public class Dropdown_Static_02 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/yahyayusifli/Documents/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        // Checks if the checkbox with partial ID 'SeniorCitizenDiscount' is currently selected
        // Uses CSS Selector with a partial match: [id*='SeniorCitizenDiscount'] means any element whose id contains this text
        // The isSelected() method (from WebElement) returns true if the checkbox or radio button is selected, false otherwise
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        ///CALENDAR

        //System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
        // make it round trip
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
            System.out.println("its enabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        //driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();

        //driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        //driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();




        // Count the number of checkboxes
        // Uses CSS selector: input[type='checkbox']
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        /*
        Instead of manually clicking the "Add Adult" button multiple times:
        driver.findElement(By.id("hrefIncAdt")).click(); // Click 1
        driver.findElement(By.id("hrefIncAdt")).click(); // Click 2
        driver.findElement(By.id("hrefIncAdt")).click(); // Click 3
        driver.findElement(By.id("hrefIncAdt")).click(); // Click 4
        */

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); // 1 Adult


        // Using a for loop to click "Add Adult" button 3 times
        for (int i = 1; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        // After adding 4 adults, clicking the "Done" or "Close" button to confirm the selection
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"4 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); // 4 Adult

        driver.quit();

    }
}
