package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownCounters {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://demo.guru99.com/test/newtours/register.php");
            driver.manage().window().maximize();

            // Locate the dropdown element
            WebElement countryDropdown = driver.findElement(By.name("country"));

            // Select an option from dropdown
            Select select = new Select(countryDropdown);
            select.selectByVisibleText("INDIA");

            System.out.println("Dropdown selection successful!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
