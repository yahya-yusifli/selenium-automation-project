package com.automation.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Exercise_04_LoginPage {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/yahyayusifli/Documents/chromedriver-mac-arm64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String username = "rahulshettyacademy";
        String password = "learning";
        String[] productArr = {"iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry"};

        loginPage(driver,wait,username,password);
        addToCart(driver,wait,productArr);


    }
    public static void loginPage(WebDriver driver, WebDriverWait wait, String username, String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='user']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModal")));
        driver.findElement(By.cssSelector("div.modal-footer.justify-content-center button#okayBtn")).click();
        driver.findElement(By.cssSelector("select.form-control ")).click();
        driver.findElement(By.cssSelector("select.form-control option[value='consult']")).click();
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
    }

    public static void addToCart(WebDriver driver, WebDriverWait wait, String[] productArr) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("app-card-list.row")));

        List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));

        int cartProductCount = 0;

        for (int i = 0; i < products.size(); i++) {

            List<String> productsList = Arrays.asList(productArr);

            if (productsList.contains(products.get(i).getText())) {
                driver.findElements(By.cssSelector("button.btn.btn-info")).get(i).click();
                cartProductCount++;
            }
            if (cartProductCount == productArr.length) {
                break;
            }
        }

        driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
    }

}
