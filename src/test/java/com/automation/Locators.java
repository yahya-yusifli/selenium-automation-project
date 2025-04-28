package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {

    public static void main(String[] args) {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/yahyayusifli/Documents/chromedriver-mac-arm64/chromedriver");

        // Create a WebDriver instance for Chrome
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait of 2 seconds for the WebDriver session
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Open the specified URL in the browser
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // 1. Find an element by ID
        // HTML: <input type="text" placeholder="Username" id="inputUsername" value="">
        driver.findElement(By.id("inputUsername")).sendKeys("user1");

        // 2. Find an element by Name
        // HTML Example: <input name="inputPassword" ... >
        driver.findElement(By.name("inputPassword")).sendKeys("abc123");

        // 3. Find an element by Class Name
        // HTML: <button class="submit signInBtn" type="submit">Sign In</button>
        // Note: class="submit signInBtn" means two classes are declared: 'submit' and 'signInBtn'.
        // You must select by a single class name (e.g., "signInBtn")
        driver.findElement(By.className("signInBtn")).click();

        // 4. Find an element by CSS Selector and extract text
        // HTML: <p class="error">* Incorrect username or password </p>
        // CSS Selector: p.error
        // getText() method is used to extract visible text from the web element.
        String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(errorMessage);

        // 5. Click on the "Forgot your password?" link using linkText locator
        driver.findElement(By.linkText("Forgot your password?")).click();

        // 6. Enter the Name in the input field located by XPath (using placeholder attribute)
        // Note: 'name' in XPath should match exactly with placeholder value
        // <input type="text" placeholder="Name" css="1">
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("user2");

        // 7. Enter the Email in the input field located by CSS Selector (using placeholder attribute)
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("user2@email.com");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();

        // Locate the third input element of type 'text' using CSS Selector and enter an email address
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("user3@email.com");


        //input[@type='text'][2]

    }
}
