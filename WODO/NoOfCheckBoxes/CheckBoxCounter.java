package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;

public class CheckBoxCounter {
    public static void main(String[] args) {
        System.out.println("Starting ChromeDriver setup...");

        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open a webpage with checkboxes
            driver.get("https://the-internet.herokuapp.com/checkboxes");
            driver.manage().window().maximize();

            // Locate all checkboxes
            List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

            int checked = 0;
            int unchecked = 0;

            // Count checked and unchecked boxes
            for (WebElement checkbox : checkboxes) {
                if (checkbox.isSelected())
                    checked++;
                else
                    unchecked++;
            }

            System.out.println("Total checkboxes: " + checkboxes.size());
            System.out.println("Checked checkboxes: " + checked);
            System.out.println("Unchecked checkboxes: " + unchecked);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
