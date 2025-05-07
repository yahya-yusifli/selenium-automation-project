package com.automation.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Ecommerce_App_base {

    /*
    *   Amazon Interview Question:
        Write a Selenium WebDriver Java program that:
            - Opens an e-commerce website
            - Searches for multiple specific product names (e.g., Cucumber, Broccoli, Beetroot)
            - Adds only those matching products to the cart by clicking their corresponding 'ADD TO CART' buttons
            - Stops once all target products are added
    * */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/yahyayusifli/Documents/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        // Define the product names we want to match (e.g., Cucumber, Broccoli)
        String[] productsArr = {"Cucumber", "Brocolli", "Beetroot"};
        int cartProductCount = 0;


        // Find all product name elements on the page (list of <h4 class='product-name'>)
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {

            // Get the text of the current product (e.g., "Cucumber - 1 Kg")
            String[] productName = products.get(i).getText().split("-");
            String formatedName = productName[0].trim();

            List<String> productsList = Arrays.asList(productsArr);

            if (productsList.contains(formatedName)) {
                // If it matches, click the corresponding 'ADD TO CART' button (same index i)
//                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                cartProductCount++;
                if (cartProductCount == productsArr.length) {
                    break;
                }

            }
        }
        //driver.quit();

    }
}
