package com.automation.exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Exercise_01_Checkbox_Improved {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement checkbox = driver.findElement(By.cssSelector("input[id='checkBoxOption2'][value='option2']"));
        checkbox.click();

        WebElement label = driver.findElement(By.cssSelector("label[for='benz']"));
        String optionText = label.getText();
        System.out.println("Selected option text: " + optionText);

        WebElement dropdownElement = driver.findElement(By.cssSelector("#dropdown-class-example"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);

        WebElement inputField = driver.findElement(By.cssSelector("#name"));
        inputField.sendKeys(optionText);

        driver.findElement(By.id("alertbtn")).click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert says: " + alertText);

        if (alertText.contains(optionText)) {
            System.out.println("Alert message success: contains " + optionText);
        } else {
            System.out.println("Something went wrong: alert does not match");
        }

        driver.switchTo().alert().accept();

        driver.quit();

    }
}