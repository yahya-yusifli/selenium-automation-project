package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators_XPathSibling {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Sibling - parent traverse
        // //header/div/button[1]/following-sibling::button[1]
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        /*
        * <header>
            <div>
                <button>Button A</button>
                <button>Button B</button>
                <button>Button C</button>
            </div>
          </header>
        * */
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]")).getText()); //Practice
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText()); //Login
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).getText()); //Signup




    }
}
