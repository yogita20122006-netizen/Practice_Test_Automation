package contacttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class ContactTest {

    public static void main(String[] args) {

        // Create Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize browser
        driver.manage().window().maximize();

        // Open Contact page
        driver.get("https://practicetestautomation.com/contact/");
        
        driver.findElement(By.id("wpforms-161-field_0"))
        .sendKeys("Palak");
        
     // Enter Last Name
        driver.findElement(By.id("wpforms-161-field_0-last"))
              .sendKeys("Srivastava");
        
     // Enter Email
        driver.findElement(By.id("wpforms-161-field_1"))
              .sendKeys("palak.test@example.com");

     // Enter Comment or Message
        driver.findElement(By.id("wpforms-161-field_2"))
              .sendKeys("This is a test message for the Contact form.");
        
        
        // Print page title
        System.out.println("Page Title: " + driver.getTitle());

        // Keep browser open
        // driver.quit();
    }
}