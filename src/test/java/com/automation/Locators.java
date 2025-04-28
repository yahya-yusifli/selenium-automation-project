package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

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

        Thread.sleep(1000);

        // 6. Enter the Name in the input field located by XPath (using placeholder attribute)
        // Note: 'name' in XPath should match exactly with placeholder value
        // <input type="text" placeholder="Name" css="1">
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("user2");

        // 7. Enter the Email in the input field located by CSS Selector (using placeholder attribute)
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("user2@email.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        // Locate the third input element of type 'text' using CSS Selector and enter an email address
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("user3@email.com");

        // Locate the third input element in the form and enter the phone number
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("4129991100");

        // Find the button with class 'reset-pwd-btn' and click it to submit the reset request
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        // Retrieve the text from the paragraph inside the form and print it to the console
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("user3");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        //Regular expression
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();


    }
}
