package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class DropdownCounter {
    public static void main(String[] args) {
        try {
            // Set path for ChromeDriver (update path as needed)
            System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");

            // Switch to frame containing dropdown
            driver.switchTo().frame("iframeResult");

            // Locate dropdown by its name
            WebElement dropdown = driver.findElement(By.name("cars"));

            // Create Select object
            Select select = new Select(dropdown);

            // Get all options
            List<WebElement> options = select.getOptions();

            // Print number of items
            System.out.println("Total number of items in combobox: " + options.size());

            // Print each item name
            for (WebElement option : options) {
                System.out.println(option.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            // driver.quit();  // Uncomment if running locally
        }
    }
}
