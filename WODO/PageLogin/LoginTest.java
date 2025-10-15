package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    public static void main(String[] args) {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open the login page
            driver.get("https://example.com/login"); // Replace with actual login URL
            driver.manage().window().maximize();

            // Find and fill username field
            WebElement usernameField = driver.findElement(By.name("username"));
            usernameField.sendKeys("your_username");

            // Find and fill password field
            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("your_password");

            // Click login button
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();

            // Wait for page to load
            Thread.sleep(3000);

            // Check if login successful
            if (driver.getCurrentUrl().contains("dashboard")) {
                System.out.println("✔ Login successful!");
            } else {
                System.out.println("✘ Login failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
