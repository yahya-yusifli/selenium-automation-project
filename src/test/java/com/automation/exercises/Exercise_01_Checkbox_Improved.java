package com.automation.exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class Exercise_01_Checkbox_Improved {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        /*WebElement checkbox = driver.findElement(By.cssSelector("input[id='checkBoxOption2'][value='option2']"));
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

        driver.quit();*/

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

            // Step 1: Select Checkbox Option 2
            WebElement checkboxOption2 = driver.findElement(By.cssSelector("input[id='checkBoxOption2'][value='option2']"));
            checkboxOption2.click();

            // Step 2: Capture the label text (dynamically)
            WebElement labelOption2 = driver.findElement(By.cssSelector("label[for='benz']"));
            String optionText = labelOption2.getText();
            System.out.println("Selected Option Text: " + optionText);

            // Step 3: Select dropdown option matching the label
            Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
            dropdown.selectByVisibleText(optionText);

            // Step 4: Enter the label text into the input box
            WebElement inputName = driver.findElement(By.id("name"));
            inputName.clear();
            inputName.sendKeys(optionText);

            // Step 5: Trigger alert and capture the alert text
            driver.findElement(By.id("alertbtn")).click();
            Alert alert = driver.switchTo().alert();
            String alertMessage = alert.getText();
            System.out.println("Alert Message: " + alertMessage);

            // Step 6: Assert the alert contains the option text
            Assert.assertTrue(alertMessage.contains(optionText), "Alert message does not contain the selected option text!");
            alert.accept();

            System.out.println("✅ Test Passed Successfully");

        } catch (Exception e) {
            System.err.println("❌ Test Failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}