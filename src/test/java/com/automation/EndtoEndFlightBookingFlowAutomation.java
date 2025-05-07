package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EndtoEndFlightBookingFlowAutomation {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // ONE WAY
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

        // FROM
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);

        // TO
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        // CALENDAR
        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();

        // another calendar is visible
        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {

            System.out.println("its disabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        // SENIOR CHECKPOINT
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        // Using a for loop to click "Add Adult" button 3 times
        for (int i = 1; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        // ADD ADULTS
        // After adding 4 adults, clicking the "Done" or "Close" button to confirm the selection
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
        System.out.println("PASSENGERS: " + driver.findElement(By.id("divpaxinfo")).getText()); // 4 Adult

//      driver.findElement(By.xpath("//input[@value='Search']")).click();
//      driver.findElement(By.name("ctl00_mainContent_btn_FindFlights")).click();
//      driver.findElement(By.cssSelector("input[value='Search']")).click();
        driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();


    }
}
