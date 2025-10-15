package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class ElementCounter {
    public static void main(String[] args) {
        // Set path for ChromeDriver (adjust if needed)
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

        // Create driver instance
        WebDriver driver = new ChromeDriver();

        // Open target website
        driver.get("https://www.google.com");

        // Find all elements using tag name "*"
        List<WebElement> elements = driver.findElements(By.xpath("//*"));

        // Print total number of elements
        System.out.println("Total number of elements on the page: " + elements.size());

        // Close the browser
        driver.quit();
    }
}
