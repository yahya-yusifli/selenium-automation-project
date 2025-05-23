package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_Static_01 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // 1   dropdown with select tag - static (have a selected option)
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);

        // 2   Selects the 4th option in the dropdown by its index (index starts from 0)
        dropdown.selectByIndex(3);
        // Prints the text of the currently selected option after selecting by index
        System.out.println(dropdown.getFirstSelectedOption().getText());

        // 3   Selects the option "AED" from the dropdown by visible text
        dropdown.selectByVisibleText("AED");
        // Prints the text of the currently selected option after selecting by visible text
        System.out.println(dropdown.getFirstSelectedOption().getText());

        // 4   Selects the option "USD" from the dropdown by value
        dropdown.selectByValue("USD");
        // Prints the text of the currently selected option after selecting by value
        System.out.println(dropdown.getFirstSelectedOption().getText());



    }
}
